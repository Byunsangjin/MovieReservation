package com.company;

public class SnackOrder {
    String pSnackID = "";
    String bSnackID = "";

    SnackOrder(){
        AppManager.getInstance().getDataManager().setSnackOrder(this);
    }

    // get 메소드
    public String getPSnackID(){
        return pSnackID;
    }
    public String getBSnackID(){
        return bSnackID;
    }

    // set 메소드
    public void setPSnackID(String pSnackID){
        this.pSnackID = pSnackID;
    }
    public void setBSnackID(String bSnackID){
        this.bSnackID = bSnackID;
    }
}
