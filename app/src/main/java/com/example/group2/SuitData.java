package com.example.group2;

public class SuitData {

    private String suitName;
    private String suitColour;
    private String suitDetails;
    private String suitSize;
    private String suitPrice;
    private Integer suitImage;

    public SuitData(String suitName, String suitColour, String suitDetails, String suitSize, String suitPrice, Integer suitImage) {
        this.suitImage = suitImage;
        this.suitName = suitName;
        this.suitColour = suitColour;
        this.suitDetails = suitDetails;
        this.suitSize = suitSize;
        this.suitPrice = suitPrice;
    }

    public Integer getSuitImage() {
        return suitImage;
    }

    public void setSuitImage(Integer suitImage) {
        this.suitImage = suitImage;
    }

    public String getSuitName() {
        return suitName;
    }

    public void setSuitName(String suitName) {
        this.suitName = suitName;
    }

    public String getSuitColour() {
        return suitColour;
    }

    public void setSuitColour(String suitColour) {
        this.suitColour = suitColour;
    }

    public String getSuitDetails() {
        return suitDetails;
    }

    public void setSuitDetails(String suitDetails) {
        this.suitDetails = suitDetails;
    }

    public String getSuitSize() {
        return suitSize;
    }

    public void setSuitSize(String suitSize) {
        this.suitSize = suitSize;
    }

    public String getSuitPrice() {
        return suitPrice;
    }

    public void setSuitPrice(String suitPrice) {
        this.suitPrice = suitPrice;
    }
}


