package com.example.ordersapp;

class orders
{

    private int morderNo;
    private int mphone;
    private String mname;
    private String mareaCode;
    private int mquantity;
    private int mamount;
    private int mtotalPrice;

    public orders(int orderNo, int phone, String name, String areaCode, int quantity, int amount, int totalPrice)
    {
        morderNo = orderNo;
        mphone = phone;
        mname = name;
        mareaCode = areaCode;
        mquantity = quantity;
        mamount = amount;
        mtotalPrice = totalPrice;
    }

    public int getOrderNo(){
        return  morderNo;
    }

    public int getphone(){
        return  mphone;
    }

    public String getname(){
        return mname;
    }

    public String getareaCode(){
        return mareaCode;
    }

    public int getquantity(){
        return mquantity;
    }

    public int getamount(){
        return mamount;
    }

    public int gettotalPrice(){
        return mtotalPrice;
    }



}
