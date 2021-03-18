package com.example.group2;

public class RentalShoesData {

    String custShoes, name, IcNum, PhoneNum, Add, Date, Price;

    public RentalShoesData(){

    }

    public String getPrice() { return Price; }

    public void setPrice(String price) { Price = price; }

    public String getCustShoes() {
        return custShoes;
    }

    public void setCustShoes(String custShoes) {
        this.custShoes = custShoes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcNum() {
        return IcNum;
    }

    public void setIcNum(String icNum) {
        IcNum = icNum;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String add) {
        Add = add;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
