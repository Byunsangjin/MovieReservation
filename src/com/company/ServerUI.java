package com.company;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerUI extends JFrame {
    protected JPanel lblP = new JPanel(); // 고객센터 라벨 패널
    protected JPanel msgPanel = new JPanel(); // 메세지 입력창 패널
    protected JLabel lblHelp = new JLabel("고객센터입니다. 무엇을 도와드릴까요?");
    protected JTextField msgInput = new JTextField(); // 메세지 입력창
    protected JButton exitButton = new JButton("종료"); // 다이얼로그 종료버튼
    protected JTextArea msgOut; // 메시지 나오는 창
    protected ImageIcon exitbutton = new ImageIcon("src/com/company/img/exitbutton.png");
    protected Font help_font;
    protected ServerUIActionL sL = new ServerUIActionL();

    ChatData data = new ChatData();
    ServiceCenter serviceCenter = new ServiceCenter();
    Socket socket;
    BufferedReader inMsg;
    PrintWriter outMsg;
    Gson gson=new Gson();
    Message m;
    boolean status;
    Thread thread;
    String id="고객센터";

    public  ServerUI() {
        setTitle("::고객센터::");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        help_font = new Font("돋움", Font.ITALIC, 18);

        lblHelp.setFont(help_font);
        lblP.setBounds(20, 20, 580, 40);
        lblP.setBackground(new Color(242,240,229));
        lblP.add(lblHelp);
        c.add(lblP, BorderLayout.NORTH); // lblHelp 상단에 배치

        msgInput.addActionListener(sL);
        // 메시지 입력 패널에 위젯 구성
        msgPanel.setLayout(new BorderLayout());
        msgPanel.add(msgInput, BorderLayout.CENTER);

        exitButton.setIcon(exitbutton);
        exitButton.addActionListener(sL);
        exitButton.setText(null);
        exitButton.setBorderPainted(false); // 버튼 테두리 없이
        exitButton.setContentAreaFilled(false); // 여백 없이
        msgPanel.add(exitButton, BorderLayout.EAST);
        c.add(msgPanel, BorderLayout.SOUTH);

        // 메시지 출력 영역 초기화
        msgOut = new JTextArea("", 10, 30);
        // JTextArea의 내용을 수정하지 못하도록 한다. 즉, 출력 전용으로 사용한다.
        msgOut.setEditable(false);

        // 메시지 출력 영역 스크롤바를 구성한다.
        // 수직 스크롤 바는 항상 나타내고 수평 스크롤 바는 필요할 때 나타나도록 한다.
        JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        c.add(jsp, BorderLayout.CENTER);

        data.addObj(msgOut);
        serviceCenter.connectServer();
        setSize(600,600);
        setVisible(true);
    } // ServerUI()

    class ServerUIActionL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            // 메세지 입력
            if(obj== msgInput) {
                outMsg.println(gson.toJson(new Message(id,"",msgInput.getText(),"msg")));
                msgInput.setText("");
            }
            // 종료 버튼
            else if (obj == exitButton) {
                //종료했다는 것을 서버에 알림
                outMsg.println(gson.toJson(new Message(id, "", "", "종료")));
                outMsg.close();
                try {
                    inMsg.close();
                    socket.close();
                } catch (Exception ex) {
                    System.out.println("Error");
                }
                status = false;
            }
        }
    }
    class ServiceCenter extends Thread {

        //서버와 연결
        public void connectServer ()  {
            try {
                socket = new Socket("127.0.0.1",8437);
                System.out.println("클라이언트 연결 성공");
                inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                outMsg = new PrintWriter(socket.getOutputStream(),true);
                m = new Message(id,"","","입장"); //로그인 할 때 아이디와 타입을 로그인으로 메세지 객체 초기화

                outMsg.println(gson.toJson(m)); //위의 값을 출력스트림으로 가져옴
                thread = new Thread(this);
                thread.start(); //클라이언트 시작
            }   catch (Exception e3) {
                System.out.println("connectError");
            }
        }
        public void run() {
            String msg;
            status =true;

            while (status) {
                try {
                    msg = inMsg.readLine(); //입력스트림에 입력된 한 줄 읽이옴
                    m=gson.fromJson(msg,Message.class); //읽어온 메세지를 Message.class형태로 파싱
                    data.refreshData(m.getId()+">"+m.getMsg()+"\n");//메세지를 입력한 클라이언트 아이디와 메세지출력
                    msgOut.setCaretPosition(msgOut.getDocument().getLength());
                }  catch (Exception e2) { System.out.println("run Error");}
            }
        }
    } // ServiceCenter class
}
