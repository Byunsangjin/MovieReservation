package com.company;

import java.sql.ResultSet;

public class SnackOrderDAO {
    DAOManager daoManager = AppManager.getInstance().getDAOManager();
    SnackOrder snackOrder = AppManager.getInstance().getDataManager().getSnackOrder();
    Customer customer = AppManager.getInstance().getDataManager().getCustomer();

    int result;

    SnackOrderDAO() { AppManager.getInstance().getDAOManager().setSnackOrderDAO(this);}

    boolean newSnackOrder(){
        daoManager.connectDB();

        String sql = "INSERT INTO snack_order(customer_id, p_snack_ID, b_snack_ID) VALUES(?, ?, ?)";

        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, customer.getId());
            daoManager.pstmt.setString(2, snackOrder.getPSnackID());
            daoManager.pstmt.setString(3, snackOrder.getBSnackID());

            result = daoManager.pstmt.executeUpdate();
            daoManager.closeDB();
        } catch (Exception e){
            e.printStackTrace();
        }
        if(result > 0)
            return true;
        else
            return false;
    }


}
