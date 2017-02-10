package com.example.avaqi.zapposapp.model;

import java.io.Serializable;

/**
 * Created by Avaqi on 2017/2/8.
 */

public class Item implements Serializable {
    private String productName;
    private String price;
    private String thumbnail;
    private String details;

    public Item() {
    }

    public Item(String productName, String price, String thumbnail, String details) {
        this.productName = productName;
        this.price = price;
        this.thumbnail = thumbnail;
        this.details = details;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String name) {
        this.productName = name;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
}
