package com.company;

import java.sql.ResultSet;

public class PaymentDAO {
    DAOManager daoManager = AppManager.getInstance().getDAOManager();

    ResultSet rs;
    int result;

    PaymentDAO(){
        AppManager.getInstance().getDAOManager().setPaymentDAO(this);
    }

    public boolean newPayment(int price, String op, String id){
        daoManager.connectDB();
        String sql = "INSERT INTO payment(total_price, payment_option, customer_ID) VALUES(?, ?, ?)";

        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setInt(1, price);
            daoManager.pstmt.setString(2, op);
            daoManager.pstmt.setString(3, id);

            result = daoManager.pstmt.executeUpdate();
            daoManager.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }

        if(result > 0)
            return true;
        else
            return false;
    }
}
