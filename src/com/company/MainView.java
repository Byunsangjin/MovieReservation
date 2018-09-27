package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ChangeListener;

public class MainView {

	JFrame frame2 = new JFrame(); // MainView 프레임

	// 탭버튼 패널
	private JPanel tabPanel = new JPanel(); // 탭 버튼 패널
	protected JButton btnMovie = new JButton("영화"); // 영화 탭 버튼
	protected JButton btnRecmov = new JButton("추천영화"); // 추천영화 탭 버튼
	protected JButton btnSnack = new JButton("매점"); // 매점 탭 버튼
	protected JButton btnPay = new JButton("결제"); // 결제 탭 버튼
	protected JButton btnHelp = new JButton("고객센터"); // 고객센터 탭 버튼


	protected ImageIcon movietab = new ImageIcon("src/com/company/img/movietab.png"); 
	protected ImageIcon recmovtab = new ImageIcon("src/com/company/img/recmovtab.png"); 
	protected ImageIcon snacktab = new ImageIcon("src/com/company/img/snacktab.png"); 
	protected ImageIcon paytab = new ImageIcon("src/com/company/img/paytab.png"); 
	protected ImageIcon helptab = new ImageIcon("src/com/company/img/helptab.png"); 


	// 배너이미지 패널(프레임 아래 이미지 패널)
	private JPanel banPanel = new JPanel(); // 프레임 아래에 배너 이미지 넣을 패널
	protected ImageIcon ban = new ImageIcon("src/com/company/img/ban.gif"); 
	protected JLabel banlbl = new JLabel();


	// 메인 배경
	protected ImageIcon mainbg = new ImageIcon("src/com/company/img/mainback.png"); 

	// 영화 패널
	private JPanel moviePanel = new JPanel() {
		public void paintComponent(Graphics g) {
			g.drawImage(mainbg.getImage(),0,0,null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}; // 영화패널
	private JPanel preP = new JPanel(); // 이전 버튼 넣을 패널
	private JPanel nextP = new JPanel(); // 다음 버튼 넣을 패널
	private JPanel movieP = new JPanel();
	private JPanel movieimgP = new JPanel(); // 포스터  넣을 패널
	private JPanel movielblP = new JPanel(); // 영화 정보 라벨 넣을 패널
	private JPanel movielblP_2 = new JPanel();
	private JPanel movielblP_3 = new JPanel();
	private JPanel btnP_movie = new JPanel(); // 예매하기 버튼 넣을 패널


	protected JButton bookBtn = new JButton("예매하기"); // 예매하기 버튼
	protected JButton preBtn = new JButton("<"); // 슬라이드에서 이전 버튼
	protected JButton nextBtn = new JButton(">"); // 슬라이드에서 다음 버튼
	protected JButton detailBtn = new JButton("자세히"); // 자세히 버튼

	protected JLabel imgLbl = new JLabel(); // 포스터 넣을 라벨
	protected JLabel infoLbl[] = new JLabel[4]; // 영화정보 라벨

	protected ImageIcon prebtn = new ImageIcon("src/com/company/img/prebtn.png"); 
	protected ImageIcon nextbtn = new ImageIcon("src/com/company/img/nextbtn.png"); 
	protected ImageIcon bookbtn = new ImageIcon("src/com/company/img/bookbtn.png"); 
	protected ImageIcon datailbtn = new ImageIcon("src/com/company/img/detailbtn.png"); 


	ArrayList<String> title = new ArrayList<String>(5); // 영화 타이틀  배열리스트
	ArrayList<String> genre = new ArrayList<String>(5); // 장르 배열리스트
	ArrayList<String> cast = new ArrayList<String>(5); // 등장인물 배열리스트
	ArrayList<String> syn = new ArrayList<String>(5); // 줄거리 배열리스트

	protected Font movie_font;
	protected Font info_font;
	protected Font info_font2;

	protected JTextArea ta[] = new JTextArea[3];

	// 추천영화 패널
	private JPanel recmovPanel = new JPanel(){
		public void paintComponent(Graphics g) {
			g.drawImage(mainbg.getImage(),0,0,null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}; // 추천영화 패널
	private JPanel preP2 = new JPanel(); // 이전 버튼 넣을 패널
	private JPanel nextP2 = new JPanel(); // 다음 버튼 넣을 패널
	private JPanel movieP2 = new JPanel();
	private JPanel movieimgP2 = new JPanel(); // 포스터  넣을 패널
	private JPanel movielblP2 = new JPanel(); // 영화 정보 라벨 넣을 패널
	private JPanel movielblP2_2 = new JPanel();
	private JPanel movielblP2_3 = new JPanel();
	private JPanel btnP_movie2 = new JPanel(); // 예매하기 버튼 넣을 패널

	protected JButton bookBtn2 = new JButton("예매하기"); // 예매하기 버튼
	protected JButton preBtn2 = new JButton("<"); // 슬라이드에서 이전 버튼
	protected JButton nextBtn2 = new JButton(">"); // 슬라이드에서 다음 버튼
	protected JButton detailBtn2 = new JButton("자세히"); // 자세히 버튼

	protected JLabel imgLbl2 = new JLabel(); // 포스터 넣을 라벨
	protected JLabel infoLbl2[] = new JLabel[4]; // 영화정보 라벨

	protected ImageIcon prebtn2 = new ImageIcon("src/com/company/img/prebtn.png"); 
	protected ImageIcon nextbtn2 = new ImageIcon("src/com/company/img/nextbtn.png");

	ArrayList<String> title2 = new ArrayList<String>(5); // 영화 타이틀  배열리스트
	ArrayList<String> genre2 = new ArrayList<String>(5); // 장르 배열리스트
	ArrayList<String> cast2 = new ArrayList<String>(5); // 등장인물 배열리스트
	ArrayList<String> syn2 = new ArrayList<String>(5); // 줄거리 배열리스트

	protected JTextArea ta2[] = new JTextArea[3];


	// 예매 패널
	private JPanel bookPanel = new JPanel(){
		public void paintComponent(Graphics g) {
			g.drawImage(mainbg.getImage(),0,0,null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}; // 예매 패널
	private JPanel numP = new JPanel(); // 성인&청소년 라벨 넣을 패널
	private JPanel spiP = new JPanel(); // 스피너 넣을 패널
	private JPanel titP = new JPanel(); // 영화제목 라벨 넣을 패널
	private JPanel scrP = new JPanel(); // 스크린 이미지 넣을 패널
	private JPanel seatP = new JPanel(); // 좌석 선택할 수 있는 토글 버튼, 구역 지정하는 라벨 넣을 패널
	private JPanel btnP = new JPanel(); // 선택&취소 버튼 넣을 패널
	private JPanel areaP = new JPanel(); // A~E 구역 라벨 패널
	private JPanel numareaP = new JPanel(); // 1~10 구역 라벨 패널

	protected JLabel aduLbl = new JLabel("성인"); // 성인 라벨
	protected JLabel stuLbl = new JLabel("청소년"); // 청소년 라벨
	protected JLabel titLbl = new JLabel("영화 제목"); // 영화제목 라벨
	protected JLabel scrLbl = new JLabel(); // 스크린 이미지 넣을 라벨

	protected JSpinner aduSpi = new JSpinner(); // 성인 수 세는 스피너
	protected JSpinner stuSpi = new JSpinner(); // 청소년 수 세는 스피너

	protected JToggleButton tBtn[] = new JToggleButton[50]; // 50개 좌석버튼
	protected JLabel areaLbl[] = new JLabel[5]; // A~E을 넣을 5개 라벨
	protected JLabel numALbl[] = new JLabel[10]; // 1~10을 넣을 10개 라벨
	protected JButton btn_book[] = new JButton[2]; // 선택/취소를 위한 2개 버튼

	String movtit=""; // 영화 제목 받을 문자열

	protected Font book_font;

	protected ImageIcon screen = new ImageIcon("src/com/company/img/screen.png"); 
	protected ImageIcon selbtn = new ImageIcon("src/com/company/img/select.png"); 
	protected ImageIcon cancel_book = new ImageIcon("src/com/company/img/cancel_book.png"); 
	protected ImageIcon toggle_btn = new ImageIcon("src/com/company/img/seat2.png");
	protected ImageIcon toggle_btn1 = new ImageIcon("src/com/company/img/그림6.png");

	// 매점 패널
	private JPanel snackPanel = new JPanel(){
		public void paintComponent(Graphics g) {
			g.drawImage(mainbg.getImage(),0,0,null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}; // 매점 패널
	private JPanel menuP1 = new JPanel(); // 메뉴 테이블 패널
	private JPanel menuP2 = new JPanel(); // 메뉴 테이블 패널
	private JPanel menuP3 = new JPanel(); // 메뉴 테이블 패널
	private JPanel menuP4 = new JPanel(); // 메뉴 테이블 패널
	private JPanel menuP5 = new JPanel(); // 메뉴 테이블 패널
	private JPanel menuP6 = new JPanel(); // 메뉴 테이블 패널

	private JPanel currentP = new JPanel(); // 현재 금액 라벨 넣을 패널
	private JPanel btnP_snack = new JPanel(); // 확인, 건너뛰기 버튼 넣을 패널

	protected JLabel menu1[] = new JLabel[4]; // 첫번째 패널에 넣을 이미지 라벨
	protected JLabel menu3[] = new JLabel[4]; // 세번째 패널에 넣을 이미지 라벨
	protected JLabel menu5[] = new JLabel[4]; // 다섯번째 패널에 넣을 이미지 라벨

	protected JSpinner menu2[] = new JSpinner[4]; // 두번째 패널에 넣을 스피너
	protected JSpinner menu4[] = new JSpinner[4]; // 네번째 패널에 넣을 스피너
	protected JSpinner menu6[] = new JSpinner[4]; // 여섯번째 패널에 넣을 스피너

	protected String pName[] = {"고소팝콘M", "고소팝콘L", "달콤팝콘M", "달콤팝콘L"}; // 팝콘 이름 문자열
	protected String bName[] = {"콜라M", "콜라L", "사이다M", "사이다L", "자몽에이드M", "자몽에이드L", "오렌지에이드M", "오렌지에이드L"};

	String currentP_snack = ""; // 매점에서의 현재 금액

	protected JLabel currentPay = new JLabel("현재 금액 : " + currentP_snack + " 원"); // 현재 금액 라벨
	protected JButton btn_snack[] = new JButton[2]; // 확인, 건너뛰기 버튼

	protected Font snack_font; // 매점 폰트

	protected ImageIcon gosoM = new ImageIcon("src/com/company/img/gosoM.png"); 
	protected ImageIcon gosoL = new ImageIcon("src/com/company/img/gosoL.png"); 
	protected ImageIcon dalcomM = new ImageIcon("src/com/company/img/dalcomM.png"); 
	protected ImageIcon dalcomL = new ImageIcon("src/com/company/img/dalcomL.png"); 
	protected ImageIcon cokeM = new ImageIcon("src/com/company/img/cokeM.png"); 
	protected ImageIcon cokeL = new ImageIcon("src/com/company/img/cokeL.png"); 
	protected ImageIcon ciderM = new ImageIcon("src/com/company/img/ciderM.png"); 
	protected ImageIcon ciderL = new ImageIcon("src/com/company/img/ciderL.png"); 
	protected ImageIcon gfM = new ImageIcon("src/com/company/img/gfM.png"); 
	protected ImageIcon gfL = new ImageIcon("src/com/company/img/gfL.png"); 
	protected ImageIcon orangeM = new ImageIcon("src/com/company/img/orangeM.png"); 
	protected ImageIcon orangeL = new ImageIcon("src/com/company/img/orangeL.png"); 
	protected ImageIcon conf = new ImageIcon("src/com/company/img/conf.png"); 
	protected ImageIcon skip = new ImageIcon("src/com/company/img/skip.png"); 




	// 결제 패널
	private JPanel payPanel = new JPanel(){
		public void paintComponent(Graphics g) {
			g.drawImage(mainbg.getImage(),0,0,null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}; // 결제 패널
	private JPanel btnP_pay = new JPanel(); // 결제하기, 취소 버튼 넣을 패널
	protected JPanel imgP_pay = new JPanel(); // 영화 포스터 이미지 넣을 패널
	private JPanel infoP_pay = new JPanel(); // 결제 정보 라벨 넣을 패널
	private JPanel radioP_pay = new JPanel(); // 결제 수단 레디오 버튼 넣을 패널

	protected JLabel imgL_pay = new JLabel(""); // 영화 포스터 이미지 라벨
	protected JLabel infoL_pay[] = new JLabel[4]; // 영화 결제 정보 라벨

	protected JRadioButton rb[] = {new JRadioButton("신용카드"), new JRadioButton("현금"),new JRadioButton("문화상품권")};

	protected ButtonGroup group = new ButtonGroup();

	protected JButton btn_pay[] = new JButton[2]; // 결제하기, 취소 버튼

	protected JDialog diaSuc; // 예매 결제 완료했을 때 나오는 다이얼로그
	protected JPanel sucP = new JPanel();
	protected JLabel sucimgLbl = new JLabel("이미지 넣을게요~");

	String aduN=""; // 성인 수
	String stuN=""; // 청소년 수
	String comPay=""; // 총 결제 금액

	protected ImageIcon pay = new ImageIcon("src/com/company/img/pay.png");
	protected ImageIcon cancel_pay = new ImageIcon("src/com/company/img/cancel_pay.png"); 
	protected ImageIcon complete = new ImageIcon("src/com/company/img/complete.gif"); 
	
	
	// 고객센터 패널
	protected JDialog diaHelp; // 고객센터 탭버튼 눌렀을 때 나오는 다이얼로그
	protected JPanel helpP = new JPanel(); // 전체 패널
	protected JPanel lblP = new JPanel(); // 고객센터 라벨 패널
	protected JPanel msgPanel = new JPanel(); // 메세지 입력창 패널
	
	protected JLabel lblHelp = new JLabel("고객센터입니다. 무엇을 도와드릴까요?");
	
	protected JTextField msgInput = new JTextField(); // 메세지 입력창
	protected JButton exitButton = new JButton("종료"); // 다이얼로그 종료버튼
	
	protected JTextArea msgOut; // 메시지 나오는 창
	
	protected ImageIcon exitbutton = new ImageIcon("src/com/company/img/exitbutton.png"); 
	
	protected Font help_font;


	// 화면 구성 전환을 위한 카드 레이아웃
	protected Container tab;
	protected CardLayout card;


	//-------------------------------------------------------------------------------------------------------------------------------- 영화 테스트

	Customer customer = AppManager.getInstance().getDataManager().getCustomer();

	Movie movie = new Movie();
	MovieDAO movieDAO = new MovieDAO();

	// 모든 영화의 ArrayList
	ArrayList<Movie> movies = movieDAO.getAll();
	ArrayList<Movie> genreMovies = movieDAO.getGenreAll(customer.getGenre());
	int mIdx=0;
	int genreIdx=0;

	// 파싱한 데이터 사용하기
	APIMovie apiMovie = new APIMovie();

	//-------------------------------------------------------------------------------------------------------------------------------- 영화 테스트

	//---------------- 영화포스터 -----------------------------
	String movieTitle1 = movies.get(0).getTitle();
	ImageIcon movieImg1 = new ImageIcon("src/com/company/img/" + movieTitle1 + ".jpg"); // 포스터 이미지 배열리스트

	String movieTitle2 = genreMovies.get(0).getTitle();
	ImageIcon movieImg2 = new ImageIcon("src/com/company/img/" + movieTitle2 + ".jpg"); // 포스터 이미지 배열리스트
	// 생성자
	public MainView(){

		AppManager.getInstance().setMainView(this);

		frame2.setTitle("CINEMA PARADISO");
		frame2.setSize(800,800);
		frame2.setLayout(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//------------------------탭 메뉴 패널------------------------
		tabPanel.setBounds(0,0,800,100);
		tabPanel.setBackground(Color.WHITE);
		tabPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

		btnMovie.setPreferredSize(new Dimension(151,100));
		btnRecmov.setPreferredSize(new Dimension(167,100));
		btnSnack.setPreferredSize(new Dimension(156,100));
		btnPay.setPreferredSize(new Dimension(153,100));
		btnHelp.setPreferredSize(new Dimension(173,100));

		btnMovie.setIcon(movietab);
		btnMovie.setText(null);
		btnMovie.setBorderPainted(false); // 버튼 테두리 없이
		btnMovie.setContentAreaFilled(false); // 여백 없이

		btnRecmov.setIcon(recmovtab);
		btnRecmov.setText(null);
		btnRecmov.setBorderPainted(false); // 버튼 테두리 없이
		btnRecmov.setContentAreaFilled(false); // 여백 없이

		btnSnack.setIcon(snacktab);
		btnSnack.setText(null);
		btnSnack.setBorderPainted(false); // 버튼 테두리 없이
		btnSnack.setContentAreaFilled(false); // 여백 없이

		btnPay.setIcon(paytab);
		btnPay.setText(null);
		btnPay.setBorderPainted(false); // 버튼 테두리 없이
		btnPay.setContentAreaFilled(false); // 여백 없이
		btnPay.setEnabled(false);

		btnHelp.setIcon(helptab);
		btnHelp.setText(null);
		btnHelp.setBorderPainted(false); // 버튼 테두리 없이
		btnHelp.setContentAreaFilled(false); // 여백 없이


		tabPanel.add(btnMovie);
		tabPanel.add(btnRecmov);
		tabPanel.add(btnSnack);
		tabPanel.add(btnPay);
		tabPanel.add(btnHelp);
		frame2.add(tabPanel);

		//------------------------배너 이미지 패널------------------------
		banPanel.setBounds(0,700,800,100);
		banlbl.setPreferredSize(new Dimension(800, 100));
		banlbl.setIcon(ban);
		banPanel.add(banlbl);
		frame2.add(banPanel);


		//------------------------영화 패널------------------------
		moviePanel.setLayout(null);
		moviePanel.setBounds(0,100,800,600);

		preP.setLayout(new BorderLayout());
		preP.setBounds(0, 250, 100, 100);
		preP.setOpaque(false);
		preBtn.setIcon(prebtn);
		preBtn.setText(null);
		preBtn.setBorderPainted(false); // 버튼 테두리 없이
		preBtn.setContentAreaFilled(false); // 여백 없이
		preP.add(preBtn);
		moviePanel.add(preP);

		nextP.setLayout(new BorderLayout());
		nextP.setBounds(700, 250, 100, 100);
		nextP.setOpaque(false);
		nextBtn.setIcon(nextbtn);
		nextBtn.setText(null);
		nextBtn.setBorderPainted(false); // 버튼 테두리 없이
		nextBtn.setContentAreaFilled(false); // 여백 없이
		nextP.add(nextBtn);
		moviePanel.add(nextP);


		movieP.setLayout(null);
		movieP.setBounds(100, 50, 290, 400);
		movieP.setBackground(new Color(81,81,81));

		movieimgP.setLayout(new BorderLayout());
		movieimgP.setBounds(20, 20, 250, 355);
		imgLbl.setPreferredSize(new Dimension(250,355));
		imgLbl.setIcon(movieImg1);
		imgLbl.setText(null);
		movieimgP.add(imgLbl);
		movieP.add(movieimgP);


		movielblP.setLayout(new GridLayout(3,1));
		movielblP.setBounds(400, 0, 100, 381);
		movielblP.setOpaque(false);

		movie_font = new Font("돋움", Font.ITALIC, 19); 
		info_font = new Font("돋움", Font.PLAIN + Font.BOLD, 15); 

		// infoLbl 배치
		for(int i=0;i<3;i++){
			infoLbl[i] = new JLabel();
		}

		infoLbl[0].setText("영화제목 : ");
		infoLbl[0].setFont(movie_font);
		infoLbl[1].setText("장르 : ");
		infoLbl[1].setFont(info_font);
		infoLbl[2].setText("출연 : ");
		infoLbl[2].setFont(info_font);


		for(int i=0;i<3;i++){
			movielblP.add(infoLbl[i]);
		}		
		moviePanel.add(movielblP);

		movielblP_2.setLayout(new GridLayout(3,1));
		movielblP_2.setBounds(500, 50, 200, 331);
		movielblP_2.setOpaque(false);

		for(int i=0; i<3; i++) {
			ta[i] = new JTextArea(15, 2);
			ta[i].setLineWrap(true); // 자동 줄바꿈
			ta[i].setOpaque(false);
			ta[i].setFont(info_font);
			movielblP_2.add(ta[i]);
		}
		ta[0].setFont(movie_font);

		// 처음 화면에 뿌려줄 정보
        ta[0].setText(movies.get(0).getTitle());
        ta[1].setText("\n" + movies.get(0).getGenre());
        ta[2].setText("\n\n" + apiMovie.getinfo(movies.get(0).getTitle(), "actor"));


		moviePanel.add(movielblP_2);


		movielblP_3.setLayout(new FlowLayout(FlowLayout.LEFT, 0 , 30));
		movielblP_3.setBounds(400, 381, 150, 129);
		movielblP_3.setOpaque(false);

		infoLbl[3] = new JLabel();
		infoLbl[3].setText("평점 : "); // 평점 : 8.88 이건 라벨 하나에 다 넣을 수 있겠죠!?
		infoLbl[3].setFont(info_font);
		movielblP_3.add(infoLbl[3]);

        infoLbl[3].setText("평점 : " + apiMovie.getinfo(movies.get(0).getTitle(), "userRating"));

		moviePanel.add(movielblP_3);

		detailBtn.setBounds(600, 406, 100, 40);
		detailBtn.setIcon(datailbtn);
		detailBtn.setText(null);
		detailBtn.setBorderPainted(false); // 버튼 테두리 없이
		detailBtn.setContentAreaFilled(false); // 여백 없이		
		moviePanel.add(detailBtn);



		btnP_movie.setLayout(new FlowLayout());
		btnP_movie.setBounds(300, 510, 200, 50);
		btnP_movie.setOpaque(false);
		bookBtn.setPreferredSize(new Dimension(200,50));
		bookBtn.setIcon(bookbtn);
		bookBtn.setText(null);
		bookBtn.setBorderPainted(false); // 버튼 테두리 없이
		bookBtn.setContentAreaFilled(false); // 여백 없이
		btnP_movie.add(bookBtn);
		moviePanel.add(btnP_movie);

		moviePanel.add(movieP);

		//frame2.add(moviePanel);


		//------------------------추천 영화 패널------------------------
		recmovPanel.setLayout(null);
		recmovPanel.setBounds(0,100,800,600);

		preP2.setLayout(new BorderLayout());
		preP2.setBounds(0, 250, 100, 100);
		preP2.setOpaque(false);
		preBtn2.setIcon(prebtn);
		preBtn2.setText(null);
		preBtn2.setBorderPainted(false); // 버튼 테두리 없이
		preBtn2.setContentAreaFilled(false); // 여백 없이
		preP2.add(preBtn2);
		recmovPanel.add(preP2);

		nextP2.setLayout(new BorderLayout());
		nextP2.setBounds(700, 250, 100, 100);
		nextP2.setOpaque(false);
		nextBtn2.setIcon(nextbtn);
		nextBtn2.setText(null);
		nextBtn2.setBorderPainted(false); // 버튼 테두리 없이
		nextBtn2.setContentAreaFilled(false); // 여백 없이
		nextP2.add(nextBtn2);
		recmovPanel.add(nextP2);


		movieP2.setLayout(null);
		movieP2.setBounds(100, 50, 290, 400);
		movieP2.setBackground(new Color(81,81,81)); // 바탕색

		movieimgP2.setLayout(new BorderLayout());
		movieimgP2.setBounds(20, 20, 250, 355);

		imgLbl2.setPreferredSize(new Dimension(250,355));
		imgLbl2.setIcon(movieImg2);
		imgLbl2.setText(null);
		movieimgP2.add(imgLbl2);
		movieP2.add(movieimgP2);


		movielblP2.setLayout(new GridLayout(3,1));
		movielblP2.setBounds(400, 0, 100, 381);
		movielblP2.setOpaque(false);
		// infoLbl2 배치
		for(int i=0;i<3;i++){
			infoLbl2[i] = new JLabel();
		}

		infoLbl2[0].setText("영화제목 : ");
		infoLbl2[0].setFont(movie_font);
		infoLbl2[1].setText("장르 : ");
		infoLbl2[1].setFont(info_font);
		infoLbl2[2].setText("출연 : ");
		infoLbl2[2].setFont(info_font);

		for(int i=0;i<3;i++){
			movielblP2.add(infoLbl2[i]);
		}

		recmovPanel.add(movielblP2);

		//---------------------movielblP2_2 이부분이 textarea인데 장르, 출연 넣을 때는 \n 사용해서 줄 맞춰주시면 될 것 같아요!!---------------
		movielblP2_2.setLayout(new GridLayout(3,1));
		movielblP2_2.setBounds(500, 50, 200, 331);
		movielblP2_2.setOpaque(false);

		for(int i=0; i<3; i++) {
			ta2[i] = new JTextArea(15, 2);
			ta2[i].setLineWrap(true); // 자동 줄바꿈
			ta2[i].setOpaque(false);
			ta2[i].setFont(info_font);
			movielblP2_2.add(ta2[i]);
		}
		ta2[0].setFont(movie_font);

		// 추천영화 첫 화면
        ta2[0].setText(genreMovies.get(0).getTitle());
        ta2[1].setText("\n" + genreMovies.get(0).getGenre());
        ta2[2].setText("\n\n" + apiMovie.getinfo(genreMovies.get(0).getTitle(), "actor"));

		recmovPanel.add(movielblP2_2);


		movielblP2_3.setLayout(new FlowLayout(FlowLayout.LEFT, 0 , 30));
		movielblP2_3.setBounds(400, 381, 150, 129);
		movielblP2_3.setOpaque(false);

		infoLbl2[3] = new JLabel();
		infoLbl2[3].setText("평점 : "); // 평점 : 8.88 이건 라벨 하나에 다 넣을 수 있겠죠!?
		infoLbl2[3].setFont(info_font);

        infoLbl2[3].setText("평점 : " + apiMovie.getinfo(genreMovies.get(0).getTitle(), "userRating"));

		movielblP2_3.add(infoLbl2[3]);
		recmovPanel.add(movielblP2_3);

		detailBtn2.setBounds(600, 406, 100, 40);
		detailBtn2.setIcon(datailbtn);
		detailBtn2.setText(null);
		detailBtn2.setBorderPainted(false); // 버튼 테두리 없이
		detailBtn2.setContentAreaFilled(false); // 여백 없이		
		recmovPanel.add(detailBtn2);





		btnP_movie2.setLayout(new FlowLayout());
		btnP_movie2.setBounds(300, 510, 200, 50);
		btnP_movie2.setOpaque(false);
		bookBtn2.setPreferredSize(new Dimension(200, 50));
		bookBtn2.setIcon(bookbtn);
		bookBtn2.setText(null);
		bookBtn2.setBorderPainted(false); // 버튼 테두리 없이
		bookBtn2.setContentAreaFilled(false); // 여백 없이
		btnP_movie2.add(bookBtn2);
		recmovPanel.add(btnP_movie2); 


		recmovPanel.add(movieP2);


		//frame2.add(recmovPanel);


		//------------------------예매 패널------------------------
		bookPanel.setLayout(null);
		bookPanel.setBounds(0,100,800,600);

		numP.setLayout(new GridLayout(2,1));
		numP.setBounds(20, 20, 80, 80);
		numP.setOpaque(false);
		numP.add(aduLbl);
		numP.add(stuLbl);
		bookPanel.add(numP);

		spiP.setLayout(new GridLayout(2,1));
		spiP.setBounds(120, 20, 100, 80);
		spiP.add(aduSpi);
		spiP.add(stuSpi);
		bookPanel.add(spiP);

		book_font = new Font("돋움", Font.BOLD + Font.ITALIC, 25); 

		titP.setLayout(new BorderLayout());
		titP.setBounds(240, 20, 560, 80);
		titP.setOpaque(false);
		titLbl.setFont(book_font);
		titP.add(titLbl, BorderLayout.CENTER);
		bookPanel.add(titP);

		scrP.setLayout(new BorderLayout());
		scrP.setBounds(0,120,800,60);
		scrLbl.setIcon(screen);
		scrLbl.setText(null);
		scrP.add(scrLbl);
		bookPanel.add(scrP); // 스크린 이미지 넣을 공간

		areaP.setLayout(new GridLayout(5,1));
		areaP.setBounds(0, 220, 40, 310);
		areaP.setOpaque(false);
		// areaLbl 배치
		for(int i=0;i<5;i++){
			areaLbl[i] = new JLabel();
		}
		areaLbl[0].setText("A");
		areaLbl[1].setText("B");
		areaLbl[2].setText("C");
		areaLbl[3].setText("D");
		areaLbl[4].setText("E");

		for(int i=0;i<5;i++){
			areaP.add(areaLbl[i]);
		}

		bookPanel.add(areaP);

		numareaP.setLayout(new GridLayout(1,10));
		numareaP.setBounds(40, 180, 760, 40);
		numareaP.setOpaque(false);
		// areaLbl 배치
		for(int i=0;i<10;i++){
			numALbl[i] = new JLabel();
		}
		numALbl[0].setText("1");
		numALbl[1].setText("2");
		numALbl[2].setText("3");
		numALbl[3].setText("4");
		numALbl[4].setText("5");
		numALbl[5].setText("6");
		numALbl[6].setText("7");
		numALbl[7].setText("8");
		numALbl[8].setText("9");
		numALbl[9].setText("10");

		for(int i=0;i<10;i++){
			numareaP.add(numALbl[i]);
		}
		bookPanel.add(numareaP);		


		seatP.setLayout(new GridLayout(5,10));
		seatP.setBounds(40, 220, 760, 310);
		//seatP.setBackground(Color.blue);
		// tBtn 배치
		for(int i=0;i<50;i++){
			tBtn[i] = new JToggleButton();
			//버튼마다 좌석번호 set
			if(i/10==0) {tBtn[i].setText("A"+(i+1));}
			else if(i/10==1) {tBtn[i].setText("B"+(i%10+1));}
			else if(i/10==2) {tBtn[i].setText("C"+(i%10+1));}
			else if(i/10==3) {tBtn[i].setText("D"+(i%10+1));}
			else if(i/10==4) {tBtn[i].setText("E"+(i%10+1));}

			tBtn[i].setEnabled(false);
			if(AppManager.getInstance().getDAOManager().getSeatDAO().getBooking(tBtn[i].getText())==1) {
				tBtn[i].setText("X");
			}
			else {
				tBtn[i].setForeground(Color.black);
			}

		}


		for(int i=0;i<50;i++){
			seatP.add(tBtn[i]);
		}
		bookPanel.add(seatP); // 좌석버튼 넣을 공간


		btnP.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 20));
		btnP.setBounds(0, 525, 800, 70);
		btnP.setOpaque(false);
		btn_book[0] = new JButton();
		btn_book[0].setPreferredSize(new Dimension(100, 50));
		btn_book[0].setIcon(selbtn);
		btn_book[0].setText(null);
		btn_book[0].setBorderPainted(false); // 버튼 테두리 없이
		btn_book[0].setContentAreaFilled(false); // 여백 없이
		btn_book[0].setEnabled(false);

		btn_book[1] = new JButton();
		btn_book[1].setPreferredSize(new Dimension(100, 50));
		btn_book[1].setIcon(cancel_book);
		btn_book[1].setText(null);
		btn_book[1].setBorderPainted(false); // 버튼 테두리 없이
		btn_book[1].setContentAreaFilled(false); // 여백 없이

		for(int i=0;i<2;i++){
			btnP.add(btn_book[i]);
		}		

		bookPanel.add(btnP); // 선택,취소 버튼 넣을 공간

		// frame2.add(bookPanel);

		//------------------------매점 패널------------------------
		snackPanel.setLayout(null);
		snackPanel.setBounds(0,100,800,600);
		snackPanel.setBackground(Color.pink);

		menuP1.setLayout(new GridLayout(1,4));
		menuP1.setBounds(50, 40, 700, 80);


		// menu1 라벨 배치
		for(int i=0;i<4;i++){
			menu1[i] = new JLabel();
		}
		menu1[0].setIcon(gosoM);
		menu1[0].setText(null);
		menu1[1].setIcon(gosoL);
		menu1[1].setText(null);
		menu1[2].setIcon(dalcomM);
		menu1[2].setText(null);
		menu1[3].setIcon(dalcomL);
		menu1[3].setText(null);

		for(int i=0;i<4;i++){
			menuP1.add(menu1[i]);
		}
		snackPanel.add(menuP1);

		menuP2.setLayout(new GridLayout(1,4));
		menuP2.setBounds(50, 120, 700, 20);

		// menu2 라벨 배치
		for(int i=0;i<4;i++){
			menu2[i] = new JSpinner();
		}

		for(int i=0;i<4;i++){
			menuP2.add(menu2[i]);
		}
		snackPanel.add(menuP2);

		menuP3.setLayout(new GridLayout(1,4));
		menuP3.setBounds(50, 140, 700, 80);

		// menu3 라벨 배치
		for(int i=0;i<4;i++){
			menu3[i] = new JLabel();
		}
		menu3[0].setIcon(cokeM);
		menu3[0].setText(null);
		menu3[1].setIcon(cokeL);
		menu3[1].setText(null);
		menu3[2].setIcon(ciderM);
		menu3[2].setText(null);
		menu3[3].setIcon(ciderL);
		menu3[3].setText(null);


		for(int i=0;i<4;i++){
			menuP3.add(menu3[i]);
		}
		snackPanel.add(menuP3);

		menuP4.setLayout(new GridLayout(1,4));
		menuP4.setBounds(50, 220, 700, 20);

		// menu4 라벨 배치
		for(int i=0;i<4;i++){
			menu4[i] = new JSpinner();
		}

		for(int i=0;i<4;i++){
			menuP4.add(menu4[i]);
		}
		snackPanel.add(menuP4);

		menuP5.setLayout(new GridLayout(1,4));
		menuP5.setBounds(50, 240, 700, 80);

		// menu5 라벨 배치
		for(int i=0;i<4;i++){
			menu5[i] = new JLabel();
		}
		menu5[0].setIcon(gfM);
		menu5[0].setText(null);
		menu5[1].setIcon(gfL);
		menu5[1].setText(null);
		menu5[2].setIcon(orangeM);
		menu5[2].setText(null);
		menu5[3].setIcon(orangeL);
		menu5[3].setText(null);

		for(int i=0;i<4;i++){
			menuP5.add(menu5[i]);
		}
		snackPanel.add(menuP5);

		menuP6.setLayout(new GridLayout(1,4));
		menuP6.setBounds(50, 320, 700, 20);

		// menu6 라벨 배치
		for(int i=0;i<4;i++){
			menu6[i] = new JSpinner();
		}

		for(int i=0;i<4;i++){
			menuP6.add(menu6[i]);
		}
		snackPanel.add(menuP6);


		snack_font = new Font("돋움", Font.BOLD, 25);

		currentP.setLayout(new BorderLayout());
		currentP.setBounds(450, 380, 350, 80);
		currentP.setOpaque(false);
		currentPay.setFont(snack_font);
		currentP.add(currentPay); // 현재 금액 라벨 추가
		snackPanel.add(currentP);


		btnP_snack.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		btnP_snack.setBounds(0, 460, 800, 100);
		btnP_snack.setOpaque(false);

		btn_snack[0] = new JButton();
		btn_snack[0].setPreferredSize(new Dimension(150, 50));
		btn_snack[0].setIcon(conf);
		btn_snack[0].setText(null);
		btn_snack[0].setBorderPainted(false); // 버튼 테두리 없이
		btn_snack[0].setContentAreaFilled(false); // 여백 없이
		btn_snack[0].setEnabled(false);


		btn_snack[1] = new JButton();
		btn_snack[1].setPreferredSize(new Dimension(150, 50));
		btn_snack[1].setIcon(skip);
		btn_snack[1].setText(null);
		btn_snack[1].setBorderPainted(false); // 버튼 테두리 없이
		btn_snack[1].setContentAreaFilled(false); // 여백 없이

		for(int i=0;i<2;i++){
			btnP_snack.add(btn_snack[i]);
		}		
		snackPanel.add(btnP_snack); // 확인, 건너뛰기




		// frame2.add(snackPanel);

		//------------------------결제 패널------------------------
		payPanel.setLayout(null);
		payPanel.setBounds(0,100,800,600);
		payPanel.setBackground(Color.orange);

		imgP_pay.setLayout(new FlowLayout(FlowLayout.CENTER,0,35));
		// imgP_pay.setOpaque(false);
		imgP_pay.setBackground(new Color(51,51,51));
		imgP_pay.setBounds(30, 20, 310, 430);
		imgP_pay.add(imgL_pay); // 영화 이미지 넣을 라벨 추가
		payPanel.add(imgP_pay);
		
		infoP_pay.setLayout(new GridLayout(4,1));
		infoP_pay.setOpaque(false);
		infoP_pay.setBounds(400, 20, 350, 350);

		// infoL_pay 라벨 배치
		for(int i=0;i<4;i++){
			infoL_pay[i] = new JLabel();
			infoL_pay[i].setFont(info_font);
		}
		infoL_pay[0].setText("티켓 수 : 성인 " + aduN +"명, 청소년 " + stuN +"명");
		infoL_pay[1].setText("팝콘 : ");
		infoL_pay[2].setText("음료 : ");
		infoL_pay[3].setText("* 총 결제 금액 : " + comPay + " 원");


		for(int i=0;i<4;i++){
			infoP_pay.add(infoL_pay[i]);
		}

		payPanel.add(infoP_pay);

		// 레디오 버튼 배치
		radioP_pay.setLayout(new GridLayout(1,3));
		radioP_pay.setOpaque(false);
		radioP_pay.setBounds(400, 360, 350, 90);
		
		info_font2 = new Font("돋움", Font.PLAIN + Font.ITALIC + Font.BOLD, 15); 

		for(int i=0;i<3;i++){
			group.add(rb[i]);
			radioP_pay.add(rb[i]);
			rb[i].setFont(info_font2);
			rb[i].setOpaque(false);
		}

		payPanel.add(radioP_pay);

		btnP_pay.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 30));
		btnP_pay.setBounds(0, 500, 800, 100);
		btnP_pay.setOpaque(false);

		btn_pay[0] = new JButton();
		btn_pay[0].setPreferredSize(new Dimension(150, 50));
		btn_pay[0].setIcon(pay);
		btn_pay[0].setText(null);
		btn_pay[0].setBorderPainted(false); // 버튼 테두리 없이
		btn_pay[0].setContentAreaFilled(false); // 여백 없이
		btn_pay[0].setEnabled(false);

		btn_pay[1] = new JButton();
		btn_pay[1].setPreferredSize(new Dimension(150, 50));
		btn_pay[1].setIcon(cancel_pay);
		btn_pay[1].setText(null);
		btn_pay[1].setBorderPainted(false); // 버튼 테두리 없이
		btn_pay[1].setContentAreaFilled(false); // 여백 없이
		for(int i=0;i<2;i++){
			btnP_pay.add(btn_pay[i]);
		}
		payPanel.add(btnP_pay); // 선택,취소 버튼 넣을 공간


		//--------------------------결제하기 버튼 클릭시 나오는 다이얼로그 화면-----------
		diaSuc = new JDialog();
		diaSuc.setModal(true);
		diaSuc.setTitle("예매완료");
		diaSuc.setSize(500, 281);

		sucP.setLayout(new BorderLayout());
		sucimgLbl.setPreferredSize(new Dimension(600, 600));
		sucimgLbl.setIcon(complete);
		sucimgLbl.setText(null);
		sucP.add(sucimgLbl);
		diaSuc.add(sucP);
		
		//------------------------고객센터 패널------------------------
		diaHelp = new JDialog();
		diaHelp.setTitle("::고객센터::");
		diaHelp.setSize(600, 600);
		
		helpP.setLayout(new BorderLayout());
		helpP.setSize(600, 600);
		
		help_font = new Font("돋움", Font.ITALIC, 18); 
		
		lblHelp.setFont(help_font);
		lblP.setBounds(20, 20, 580, 40);
		lblP.setBackground(new Color(242,240,229));
		lblP.add(lblHelp);
		helpP.add(lblP, BorderLayout.NORTH); // lblHelp 상단에 배치
		
		// 메시지 입력 패널에 위젯 구성
		msgPanel.setLayout(new BorderLayout());
		msgPanel.add(msgInput, BorderLayout.CENTER);
		
		exitButton.setIcon(exitbutton);
		exitButton.setText(null);
		exitButton.setBorderPainted(false); // 버튼 테두리 없이
		exitButton.setContentAreaFilled(false); // 여백 없이		
		msgPanel.add(exitButton, BorderLayout.EAST);
		helpP.add(msgPanel, BorderLayout.SOUTH);
		
		// 메시지 출력 영역 초기화
		msgOut = new JTextArea("", 10, 30);
		// JTextArea의 내용을 수정하지 못하도록 한다. 즉, 출력 전용으로 사용한다.
		msgOut.setEditable(false);
		
		// 메시지 출력 영역 스크롤바를 구성한다.
		// 수직 스크롤 바는 항상 나타내고 수평 스크롤 바는 필요할 때 나타나도록 한다.
		JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		helpP.add(jsp, BorderLayout.CENTER);
		
		diaHelp.add(helpP);		


		// 영화,추천영화,매점,결제 패널 중 하나를 선택하는 CardLayout 패널
		tab = new JPanel();
		tab.setBounds(0,100,800,700);
		card = new CardLayout();
		tab.setLayout(card);
		tab.add(moviePanel, "movie"); // 영화 탭
		tab.add(bookPanel, "book"); // 예매 화면
		tab.add(recmovPanel, "recmovie"); // 추천영화 탭
		tab.add(snackPanel, "snack"); // 매점 탭
		tab.add(payPanel, "pay"); // 결제 탭
		card.show(tab, "movie");
		frame2.add(tab, BorderLayout.CENTER);
		frame2.setVisible(true);
	}// MainView()

	public void addListenerMain (ActionListener listener) {
		nextBtn.addActionListener(listener);
		nextBtn2.addActionListener(listener);
		preBtn.addActionListener(listener);
		preBtn2.addActionListener(listener);
		btnMovie.addActionListener(listener);
		bookBtn.addActionListener(listener);
		btnRecmov.addActionListener(listener);
		bookBtn2.addActionListener(listener);
		btn_book[0].addActionListener(listener);
		btn_book[1].addActionListener(listener);
		btnSnack.addActionListener(listener);
		btn_snack[0].addActionListener(listener);
		btn_snack[1].addActionListener(listener);
		btnPay.addActionListener(listener);
		btn_pay[0].addActionListener(listener);
		btn_pay[1].addActionListener(listener);
		for(int i=0; i<50; i++) tBtn[i].addActionListener(listener);
		for(int i=0; i<3; i++) rb[i].addActionListener(listener);
		btnHelp.addActionListener(listener);
		detailBtn.addActionListener(listener);
		detailBtn2.addActionListener(listener);
		exitButton.addActionListener(listener);
		msgInput.addActionListener(listener);

	}

	//JSpinner 버튼들 이벤트 핸들링 리스너 함수
	public void addChangeListenerMain (ChangeListener changeListener) {
		menu2[0].addChangeListener(changeListener);
		menu2[1].addChangeListener(changeListener);
		menu2[2].addChangeListener(changeListener);
		menu2[3].addChangeListener(changeListener);
		menu4[0].addChangeListener(changeListener);
		menu4[1].addChangeListener(changeListener);
		menu4[2].addChangeListener(changeListener);
		menu4[3].addChangeListener(changeListener);
		menu6[0].addChangeListener(changeListener);
		menu6[1].addChangeListener(changeListener);
		menu6[2].addChangeListener(changeListener);
		menu6[3].addChangeListener(changeListener);
		aduSpi.addChangeListener(changeListener);
		stuSpi.addChangeListener(changeListener);
	}

}// MainView class

