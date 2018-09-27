package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LoginView{

	// Login 화면
	protected JButton btnLogin = new JButton("로그인");
	protected JButton btnJoin = new JButton("회원가입");
	protected JTextField tfLogin[] = new JTextField[2];
	protected JPanel titlePane;
	protected JPanel mainPane; // 입력창, 로그인, 회원가입버튼
	protected JLabel title;
	
	protected ImageIcon main = new ImageIcon("src/com/company/img/main.gif");
	protected ImageIcon login = new ImageIcon("src/com/company/img/loginbtn.png");
	protected ImageIcon join = new ImageIcon("src/com/company/img/joinbtn.png");
	protected ImageIcon loginbg = new ImageIcon("src/com/company/img/loginback.png");


	JFrame frame = new JFrame("CINEMA PARADISO");

	// Join 화면
	protected Font joinF; // 회원가입 창 폰트
	protected JDialog diaJoin;
	protected JPanel joinPane; // 가입창 패널
	protected JOptionPane diaNoti; // 다이얼 알림창
	JTextField tfJoin[] = new JTextField[4];
	JLabel lblJoin[] = new JLabel[5];
	JButton btn[] = new JButton[3];
	JPanel rbp = new JPanel(); // 레디오버튼패널
	JRadioButton rb[] = new JRadioButton[6]; // 레디오버튼
	ButtonGroup group = new ButtonGroup(); // 레디오버튼 그룹
	
	protected ImageIcon joinbg = new ImageIcon("src/com/company/img/joinback.png"); // 배경이미지
	protected ImageIcon confdup = new ImageIcon("src/com/company/img/confdup.png"); // 중복확인
	protected ImageIcon join_join = new ImageIcon("src/com/company/img/join_join.png"); // 가입
	protected ImageIcon cancel_join = new ImageIcon("src/com/company/img/cancel_join.png"); // 취소

	public LoginView() {
		AppManager.getInstance().setLoingView(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		setUI();

		frame.setSize(800, 800);
		frame.setVisible(true);
	}// LoginView()

	public void setUI() {

		// 타이틀 부분(이미지 넣을 것)
		titlePane = new JPanel(new BorderLayout());
		titlePane.setBounds(0, 0, 800, 400);
		title = new JLabel("");
		title.setPreferredSize(new Dimension(800, 400));
		title.setIcon(main);
		title.setText(null);
		titlePane.add(title);
		frame.add(titlePane);	
		

		mainPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(loginbg.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		mainPane.setLayout(null);
		mainPane.setBounds(0, 400, 800, 400);
		
		// textField 배치
		JPasswordField pwField = new JPasswordField();
		for(int i=0;i<2;i++) {
			tfLogin[i] = new JTextField();
			if(i==1)
				tfLogin[i] = pwField;
			tfLogin[i].setBounds(200, 130+50*i, 400, 30);
			mainPane.add(tfLogin[i]);
		}

		// Login 버튼
		btnLogin.setBounds(200, 230, 400, 30);
		btnLogin.setIcon(login);
		btnLogin.setText(null);
		btnLogin.setBorderPainted(false); // 버튼 테두리 없이
		btnLogin.setContentAreaFilled(false); // 여백 없이
		mainPane.add(btnLogin);

		// Join 버튼
		btnJoin.setBounds(500, 300, 100, 30);
		btnJoin.setIcon(join);
		btnJoin.setText(null);
		btnJoin.setBorderPainted(false); // 버튼 테두리 없이
		btnJoin.setContentAreaFilled(false); // 여백 없이
		mainPane.add(btnJoin);
		
		
		frame.add(mainPane);

	}// setUI()

	public void joinUI() {

		diaJoin = new JDialog();
		diaJoin.setTitle("회원가입");
		diaJoin.setModal(true);
		diaJoin.setSize(620, 600);
		diaJoin.setBackground(Color.blue);

		joinF = new Font("돋움", Font.PLAIN, 14);
		
		joinPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(joinbg.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		joinPane.setLayout(null);
		joinPane.setBackground(new Color(242,240,229)); 
		joinPane.setBounds(0, 0, 620, 600);


		// textField 배치
		JPasswordField pwField2 = new JPasswordField();
		for(int i=0;i<4;i++) {
			tfJoin[i] = new JTextField();
			if(i==1)
				tfJoin[i] = pwField2;
			tfJoin[i].setBounds(230, 80+60*i, 100, 30);
			joinPane.add(tfJoin[i]);
		}// for

		// label 배치
		for(int i=0;i<5;i++){
			lblJoin[i] = new JLabel();
			lblJoin[i].setBounds(130, 80+60*i, 80, 30);
			lblJoin[i].setFont(joinF);
		}
		lblJoin[0].setText("아이디");
		lblJoin[1].setText("비밀번호");
		lblJoin[2].setText("이름");
		lblJoin[3].setText("전화번호");
		lblJoin[4].setText("선호장르");
		for(int i=0;i<5;i++){
			joinPane.add(lblJoin[i]);
		}

		// radiobutton 배치
		rbp = new JPanel();
		rbp.setLayout(new GridLayout(2,3));
		rbp.setBounds(230, 320, 320, 80);

		for(int i=0; i<6; i++) {
			rb[i] = new JRadioButton();
			rb[i].setFont(joinF);
			rb[i].setBackground(Color.WHITE);
		}    	
		rb[0].setText("SF");
		rb[1].setText("액션");
		rb[2].setText("스릴러/공포");
		rb[3].setText("코미디");
		rb[4].setText("멜로");
		rb[5].setText("애니");   

		for(int i=0; i<6; i++) {
			group.add(rb[i]);
			rbp.add(rb[i]);
		}        
		joinPane.add(rbp);


		// 회원가입 버튼
		btn[0] = new JButton("가입");
		btn[0].setBounds(130, 480, 100, 30);
		btn[0].setIcon(join_join);
		btn[0].setText(null);
		btn[0].setBorderPainted(false); // 버튼 테두리 없이
		btn[0].setContentAreaFilled(false); // 여백 없이
		btn[0].setEnabled(false);
		joinPane.add(btn[0]);

		// 취소 버튼
		btn[1] = new JButton("취소");
		btn[1].setBounds(370, 480, 100, 30);
		btn[1].setIcon(cancel_join);
		btn[1].setText(null);
		btn[1].setBorderPainted(false); // 버튼 테두리 없이
		btn[1].setContentAreaFilled(false); // 여백 없이
		joinPane.add(btn[1]);

		// 중복 확인 버튼
		btn[2] = new JButton("중복 확인");
		btn[2].setBounds(370, 80, 100, 30);
		btn[2].setIcon(confdup);
		btn[2].setText(null);
		btn[2].setBorderPainted(false); // 버튼 테두리 없이
		btn[2].setContentAreaFilled(false); // 여백 없이
		joinPane.add(btn[2]);

		AppManager.getInstance().getMyactionListener().JoinListenerSet();

		// 이걸 안 넣으면 중복 확인 버튼이 바탕에 깔리게 됨.. 왜 그런지 잘 모르겠어요ㅠ
		JLabel lbl = new JLabel("");
		lbl.setBounds(500, 40, 30, 30);
		joinPane.add(lbl);
		
		diaJoin.add(joinPane);

		diaJoin.setVisible(true);

		diaNoti = new JOptionPane();

	}// joinUI()

	public void addListenerLogin(ActionListener listener) {
		btnLogin.addActionListener(listener);
		btnJoin.addActionListener(listener);
	}
	public void addLisenerJoin(ActionListener listener) {
		btn[0].addActionListener(listener);
		btn[1].addActionListener(listener);
		btn[2].addActionListener(listener);
	}

}// LoginView class
