package com.example.avaqi.zapposapp.model;

/**
 * Created by Avaqi on 2017/2/8.
 */
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("brandName")
    private String brandName;
    @SerializedName("thumbnailImageUrl")
    private String thumbnailImageUrl;
    @SerializedName("productId")
    private String productId;
    @SerializedName("originalPrice")
    private String originalPrice;
    @SerializedName("styleId")
    private String styleId;
    @SerializedName("colorId")
    private String colorId;
    @SerializedName("price")
    private String price;
    @SerializedName("percentOff")
    private String percentOff;
    @SerializedName("productUrl")
    private String productUrl;
    @SerializedName("productName")
    private String productName;


    public Product(String brandName, String thumbnailImageUrl, String productId, String originalPrice,
    String styleId, String colorId, String price, String percentOff, String productUrl, String productName) {
        this.brandName = brandName;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.productId = productId;
        this.originalPrice=originalPrice;
        this.styleId=styleId;
        this.colorId=colorId;
        this.price=price;
        this.percentOff = percentOff;
        this.productUrl=productUrl;
        this.productName=productName;
    }

    public String getBrandName() {
        return brandName;
    }
    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }
    public String getProductId() {
        return productId;
    }
    public String getOriginalPrice() {
        return originalPrice;
    }
    public String getStyleId() {
        return styleId;
    }
    public String getColorId() {
        return colorId;
    }
    public String getPrice() {
        return price;
    }
    public String getPercentOff() {
        return percentOff;
    }
    public String getProductUrl() {
        return productUrl;
    }
    public String getProductName() {
        return productName;
    }
}
