package com.company;

public class TicketDAO {
    DAOManager daoManager = AppManager.getInstance().getDAOManager();

    public TicketDAO() {
        AppManager.getInstance().getDAOManager().setM_ticketDAO(this);
    }

    public void newTicket (Ticket ticket) {
        daoManager.connectDB();

        String sql = "INSERT INTO ticket(customer_UID, totalnum, selectseat,totalticket_price) VALUES(?, ?, ?, ?)";

        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, ticket.getCutomername());
            daoManager.pstmt.setInt(2, ticket.getTotalnum());
            daoManager.pstmt.setString(3, ticket.getSeletseat());
            daoManager.pstmt.setInt(4, ticket.getTotalprice());

            daoManager.pstmt.executeUpdate();
            daoManager.closeDB();
        }catch (Exception e){
            System.out.println("newTicketError");
        }
    }
}
