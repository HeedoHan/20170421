package com.example.hanheedo.test2;

/**
 * Created by Han Heedo on 2017-05-25.
 */

public class Item {
    private String itemNum;
    private String itemType;
    private String itemName;
    private String price;
    private String day;
    private String lentStatus;


    public String getItemNum() {
        return itemNum;
    }

    public void setItemNum(String itemNum) {
        this.itemNum = itemNum;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLentStatus() {
        return lentStatus;
    }

    public void setLentStatus(String lentStatus) {
        this.lentStatus = lentStatus;
    }

    public Item(String itemNum, String itemType, String itemName, String price, String day, String lentStatus) {
        this.itemNum = itemNum;
        this.itemType = itemType;
        this.itemName = itemName;
        this.price = price;
        this.day = day;
        this.lentStatus = lentStatus;
    }
}
