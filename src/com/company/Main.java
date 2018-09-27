package com.company;

public class Main {
    public static void main(String[] args) {
    	MyActionListener my = new MyActionListener();
    	my.LoginListenerSet();

    	AppManager.getInstance().getLoginView();
    }
}

