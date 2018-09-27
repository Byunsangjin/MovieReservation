package com.company;

import java.sql.ResultSet;

public class SeatDAO {
    DAOManager daoManager = AppManager.getInstance().getDAOManager();
    ResultSet rs;

    public SeatDAO() {
        AppManager.getInstance().getDAOManager().setSeatDAO(this);
    }
    //결제가 완료되면 해당 좌석 booking 1로 바꿈
    public void setSelectedSeat (String seatname) {
        daoManager.connectDB();

        String sql = "UPDATE seat SET booking=1 WHERE seat_UID=?";
        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, seatname);
            daoManager.pstmt.executeUpdate();
            daoManager.closeDB();
        }catch (Exception e){
            System.out.println("newSeatDAO Error");
        }
    }
    //결제가 진행중인 좌석은 booking 2로 바꿈
    public void setPayingSeat (String seatname) {
        daoManager.connectDB();

        String sql = "UPDATE seat SET booking=2 WHERE seat_UID=?";
        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, seatname);
            daoManager.pstmt.executeUpdate();
            daoManager.closeDB();
        }catch (Exception e){
            System.out.println("newSeatDAO Error");
        }
    }
    //결제가 진행중인 좌석 취소시 booking 0으로 바꿈
    public void setPayCancel (String seatname) {
        daoManager.connectDB();

        String sql = "UPDATE seat SET booking=0 WHERE seat_UID=?";
        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, seatname);
            daoManager.pstmt.executeUpdate();
            daoManager.closeDB();
        }catch (Exception e){
            System.out.println("newSeatDAO Error");
        }
    }
    public int getBooking (String seatname) {
        daoManager.connectDB();

        String sql = "SELECT booking FROM seat WHERE seat_UID=?";
        int book=0;
        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, seatname);
            rs = daoManager.pstmt.executeQuery();
            if(rs.next())
                book =rs.getInt("booking");
            daoManager.closeDB();
        }catch (Exception e){
            System.out.println("newSeatDAO Error");
        }
        return book;
    }
}
