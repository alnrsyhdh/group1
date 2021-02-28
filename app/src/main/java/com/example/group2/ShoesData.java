package com.example.group2;

public class ShoesData {

    private String shoesName;
    private String shoesColour;
    private String shoesDetails;
    private String shoesSize;
    private String shoesPrice;
    private Integer shoesImage;

    public ShoesData(String shoesName, String shoesColour, String shoesDetails, String shoesSize, String shoesPrice, Integer shoesImage) {
        this.shoesImage = shoesImage;
        this.shoesName = shoesName;
        this.shoesColour = shoesColour;
        this.shoesDetails = shoesDetails;
        this.shoesSize = shoesSize;
        this.shoesPrice = shoesPrice;
    }

    public Integer getShoesImage() {
        return shoesImage;
    }

    public void setShoestImage(Integer shoesImage) {
        this.shoesImage = shoesImage;
    }

    public String getShoesName() {
        return shoesName;
    }

    public void setShoesName(String shoesName) {
        this.shoesName = shoesName;
    }

    public String getShoesColour() {
        return shoesColour;
    }

    public void setShoesColour(String shoesColour) {
        this.shoesColour = shoesColour;
    }

    public String getShoesDetails() {
        return shoesDetails;
    }

    public void setShoesDetails(String shoesDetails) {
        this.shoesDetails = shoesDetails;
    }

    public String getShoesSize() {
        return shoesSize;
    }

    public void setShoesSize(String shoesSize) {
        this.shoesSize = shoesSize;
    }

    public String getShoesPrice() {
        return shoesPrice;
    }

    public void setShoesPrice(String shoesPrice) {
        this.shoesPrice = shoesPrice;
    }
}


