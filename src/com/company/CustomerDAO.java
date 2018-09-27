package com.company;

import java.sql.ResultSet;

public class CustomerDAO {
    DAOManager daoManager = AppManager.getInstance().getDAOManager();
    Customer customer = AppManager.getInstance().getDataManager().getCustomer();

    int result;
    ResultSet rs;

    public CustomerDAO(){
        AppManager.getInstance().getDAOManager().setCustomerDAO(this);
    }

    // 회원 가입
    boolean newCustomer(){
        daoManager.connectDB();

        String sql = "INSERT INTO customer(customer_id, customer_pw, customer_name, customer_tel, customer_genre) VALUES(?, ?, ?, ?, ?)";

        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, customer.getId());
            daoManager.pstmt.setString(2, customer.getPw());
            daoManager.pstmt.setString(3, customer.getName());
            daoManager.pstmt.setString(4, customer.getTel());
            daoManager.pstmt.setString(5, customer.getGenre());

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

    // 로그인 기능
    boolean login(){
        daoManager = AppManager.getInstance().getDAOManager();
        customer = AppManager.getInstance().getDataManager().getCustomer();

        daoManager.connectDB();
        String sql = "SELECT * FROM customer WHERE customer_id = ?";

        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, customer.getId());
            rs = daoManager.pstmt.executeQuery();


            // 아이디와 비밀번호가 맞으면 회원정보를 불러와 저장
            if(rs.next()) {
                if (customer.getPw().equals(rs.getString(3))) {
                    customer.setId(rs.getString("customer_id"));
                    customer.setPw(rs.getString("customer_pw"));
                    customer.setName(rs.getString("customer_name"));
                    customer.setTel(rs.getString("customer_tel"));
                    customer.setGenre(rs.getString("customer_genre"));
                    return true;
                }
            }
            rs.close();
            daoManager.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    // 중복검사
    boolean idCheck(){
        daoManager = AppManager.getInstance().getDAOManager();
        customer = AppManager.getInstance().getDataManager().getCustomer();

        daoManager.connectDB();
        String sql = "SELECT customer_id FROM customer";

        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            rs = daoManager.pstmt.executeQuery();
            while(rs.next()){
                if(customer.getId().equals(rs.getString(1)))
                    return false;
            }
            rs.close();
            daoManager.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }
}
