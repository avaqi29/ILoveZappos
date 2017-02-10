package com.example.avaqi.zapposapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Avaqi on 2017/2/8.
 */

public class ProductResponse {
    @SerializedName("originalTerm")
    private String originalTerm;
    @SerializedName("results")
    private List<Product> results;
    @SerializedName("currentResultCount")
    private String currentResultCount;
    @SerializedName("totalResultCount")
    private String totalResultCount;
    @SerializedName("statusCode")
    private String statusCode;
    @SerializedName("term")
    private String term;

    public String getOriginalTerm() {return originalTerm;}
    public String getTotalResultCount(){ return totalResultCount;}
    public String getTerm(){ return term;}
    public String getStatusCode(){ return statusCode;}
    public String getCurrentResultCount(){ return currentResultCount;}

    public List<Product> getResults() {
        return results;
    }

    public void setResults(List<Product> results) {
        this.results = results;
    }

}
