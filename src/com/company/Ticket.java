package com.company;

public class Ticket {
    String cutomername;
    int totalnum;
    String seletseat;
    int totalprice;

    Ticket(){
        AppManager.getInstance().getDataManager().setTicket(this);
    }

    // get메소드
    public String getCutomername(){ return cutomername; }
    public int getTotalnum(){
        return totalnum;
    }
    public String getSeletseat(){
        return seletseat;
    }
    public int getTotalprice(){
        return totalprice;
    }

    // set메소드
    public void setCutomername(String cutomername){
        this.cutomername = cutomername;
    }
    public void setTotalnum(int totalnum){
        this.totalnum = totalnum;
    }
    public void setSeletseat(String seletseat){
        this.seletseat = seletseat;
    }
    public void setTotalprice(int totalprice){ this.totalprice = totalprice; }
}

