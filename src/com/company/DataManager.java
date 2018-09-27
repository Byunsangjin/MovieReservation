package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataManager {
    private Customer m_customer;
    private Movie m_movie;
    private Payment m_payment;
    private Seat m_seat;
    private Snack m_snack;
    private SnackOrder m_snackOrder;
    private Ticket m_ticket;

    public DataManager() {
        AppManager.getInstance().setDataManager(this);
    }

    public void setCustomer (Customer customer) {
        m_customer = customer;
    }
    public void setMovie (Movie movie) {
        m_movie = movie;
    }
    public void setPayment (Payment payment) {
        m_payment = payment;
    }
    public void setSeat (Seat seat) {
        m_seat = seat;
    }
    public void setSnack (Snack snack) {
        m_snack = snack;
    }
    public void setSnackOrder (SnackOrder snackOrder) {
        m_snackOrder = snackOrder;
    }
    public void setTicket (Ticket ticket) {
        m_ticket = ticket;
    }

    public Customer getCustomer() {
        return m_customer;
    }
    public Movie getMovie() {
        return m_movie;
    }
    public Payment getPayment() {
        return m_payment;
    }
    public Seat getSeat() {
        return m_seat;
    }
    public Snack getSnack() {
        return m_snack;
    }
    public Ticket getTicket() {
        return m_ticket;
    }
    public SnackOrder getSnackOrder() {
        return m_snackOrder;
    }
}

