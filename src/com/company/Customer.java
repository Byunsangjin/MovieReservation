package com.company;

import javax.xml.crypto.Data;

public class Customer {
    String id;
    String pw;
    String name;
    String tel;
    String genre;

    Customer(){
        AppManager.getInstance().getDataManager().setCustomer(this);
    }

    // get메소드
    public String getId(){
        return id;
    }
    public String getPw(){
        return pw;
    }
    public String getName(){
        return name;
    }
    public String getTel(){
        return tel;
    }
    public String getGenre(){
        return genre;
    }

    // set메소드
    public void setId(String id){
        this.id = id;
    }
    public void setPw(String pw){
        this.pw = pw;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
}
