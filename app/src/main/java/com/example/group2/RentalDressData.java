package com.example.group2;

public class RentalDressData {
    String custDress, name, IcNum, PhoneNum, Add, Date, Price;

    public RentalDressData(){
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
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

    public String getCustDress() {
        return custDress;
    }

    public void setCustDress(String custDress) {
        this.custDress = custDress;
    }
}
