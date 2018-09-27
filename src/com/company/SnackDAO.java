package com.company;

import java.sql.ResultSet;

public class SnackDAO {
    DAOManager daoManager = AppManager.getInstance().getDAOManager();
    ResultSet rs;

    public SnackDAO () {
        AppManager.getInstance().getDAOManager().setSnackDAO(this);
    }

    //해당 메뉴 이름과 선택한 갯수를 인자로 받아 그 에 맞는 가격 반환
    public int getPrice (String snackname, int snackcount) {
        daoManager.connectDB();
        //snack DB에서 메뉴 이름에 맞는 가격을 찾아오는 쿼리문
        String sql = "SELECT snack_price FROM snack WHERE snack_name = ?";
        int allPrice =0;
        int snackPrice=0;

        try {
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, snackname);
            rs = daoManager.pstmt.executeQuery();
            if(rs.next())
                snackPrice=rs.getInt("snack_price");

            //가져온 메뉴 한 개당 가격을 선택한 개수 만큼 곱해서 총 가격 저장
            allPrice = snackPrice*snackcount;
            rs.close();
            daoManager.closeDB();
        }
        catch (Exception e) {
            System.out.println("priceError");
        }
        return allPrice;
    }
}
