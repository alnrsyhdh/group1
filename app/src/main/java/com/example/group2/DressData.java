package com.example.group2;

public class DressData {

    private String dressName;
    private String dressColour;
    private String dressDetails;
    private String dressSize;
    private String dressPrice;
    private Integer dressImage;

    public DressData(String dressName, String dressColour, String dressDetails, String dressSize, String dressPrice, Integer dressImage) {
        this.dressImage = dressImage;
        this.dressName = dressName;
        this.dressColour = dressColour;
        this.dressDetails = dressDetails;
        this.dressSize = dressSize;
        this.dressPrice = dressPrice;
    }

    public Integer getDressImage() {
        return dressImage;
    }

    public void setDressImage(Integer dressImage) {
        this.dressImage = dressImage;
    }

    public String getDressName() {
        return dressName;
    }

    public void setDressName(String dressName) {
        this.dressName = dressName;
    }

    public String getDressColour() {
        return dressColour;
    }

    public void setDressColour(String dressColour) {
        this.dressColour = dressColour;
    }

    public String getDressDetails() {
        return dressDetails;
    }

    public void setDressDetails(String dressDetails) {
        this.dressDetails = dressDetails;
    }

    public String getDressSize() {
        return dressSize;
    }

    public void setDressSize(String dressSize) {
        this.dressSize = dressSize;
    }

    public String getDressPrice() {
        return dressPrice;
    }

    public void setDressPrice(String dressPrice) {
        this.dressPrice = dressPrice;
    }
}
