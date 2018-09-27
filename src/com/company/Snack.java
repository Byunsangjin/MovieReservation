package com.company;

public class Snack {
    private int snack_ID;
    private String snack_Type;
    private String snack_Name;
    private int snack_Price;

    public void Snack () { AppManager.getInstance().getDataManager().setSnack(this);}

    public void setSnack_ID (int id) { snack_ID = id; }
    public void setSnack_Type (String type) { snack_Type = type; }
    public void setSnack_Name (String name) { snack_Name = name; }
    public void setSnack_Price (int price) { snack_Price = price; }

    public int getSnack_ID () { return snack_ID; }
    public String getSnack_Type() { return snack_Type; }
    public String getSnack_Name() { return snack_Name; }
    public int getSnack_Price() { return snack_Price; }
}
