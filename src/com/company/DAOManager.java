package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAOManager {
    private CustomerDAO m_customerDAO;
    private MovieDAO m_movieDAO;
    private PaymentDAO m_paymentDAO;
    private SeatDAO m_seatDAO;
    private SnackDAO m_snackDAO;
    private SnackOrderDAO m_snackOrderDAO;
    private TicketDAO m_ticketDAO;

    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost/theater?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    Connection conn;
    PreparedStatement pstmt;

    public DAOManager(){
        AppManager.getInstance().setDAOManager(this);
    }

    // DB 연동
    public void connectDB(){
        try{
            Class.forName(jdbcDriver);


            conn = DriverManager.getConnection(jdbcUrl, "root", "비밀먼호");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // DB 닫기
    public void closeDB(){
        try{
            pstmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // set 메소
    public void setCustomerDAO (CustomerDAO customerdao) {
        m_customerDAO=customerdao;
    }
    public void setMovieDAO (MovieDAO moviedao) {
        m_movieDAO = moviedao;
    }
    public void setPaymentDAO (PaymentDAO paymentdao) {
        m_paymentDAO = paymentdao;
    }
    public void setSeatDAO (SeatDAO seatdao) {
        m_seatDAO = seatdao;
    }
    public void setSnackDAO (SnackDAO snackdao) {
        m_snackDAO = snackdao;
    }
    public void setSnackOrderDAO (SnackOrderDAO snackOrderdao) {
        m_snackOrderDAO = snackOrderdao;
    }
    public void setM_ticketDAO (TicketDAO ticketdao) {
        m_ticketDAO = ticketdao;
    }

    // get 메소드
    public CustomerDAO getCustomerDAO() {
        return m_customerDAO;
    }
    public MovieDAO getMovieDAO() {
        return m_movieDAO;
    }
    public PaymentDAO getPaymentDAO() {
        return m_paymentDAO;
    }
    public SeatDAO getSeatDAO() {
        return m_seatDAO;
    }
    public SnackDAO getSnackDAO() {
        return m_snackDAO;
    }
    public SnackOrderDAO getSnackOrderDAO() {
        return m_snackOrderDAO;
    }
    public TicketDAO getTicketDAO() {
        return m_ticketDAO;
    }
}

