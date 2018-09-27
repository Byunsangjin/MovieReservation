package com.company;

public class Payment {
    private int price;
    private String paymentOption;
    private String customerID;

    Payment(){
        AppManager.getInstance().getDataManager().setPayment(this);
    }

    public int getPrice(){
        return price;
    }
    public String getPaymentOption(){
        return paymentOption;
    }
    public String getCustomerID(){
        return customerID;
    }

    public void setPrice(int price){
        this.price = price;
    }
    public void setPaymentOption(String paymentOption){
        this.paymentOption = paymentOption;
    }
    public void setCustomerID(String customerID){
        this.customerID = customerID;
    }



}
