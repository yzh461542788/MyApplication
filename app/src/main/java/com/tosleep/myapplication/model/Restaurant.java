package com.tosleep.myapplication.model;

import java.io.Serializable;

/**
 * Created by yuzhaoxin on 2017/12/18.
 */

public class Restaurant implements Serializable {
    private String name;
    private String imagePath;
    private double elemeMinPrice;
    private double meituanMinPrice;
    private String telephone;
    private String address;
    private String elemeShippingTime;
    private String meituanShippingTime;
    private double elemeShippingFee;
    private double meituanShippingFee;
    private String elemeId;
    private String meituanId;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getElemeMinPrice() {
        return elemeMinPrice;
    }

    public void setElemeMinPrice(double elemeMinPrice) {
        this.elemeMinPrice = elemeMinPrice;
    }

    public double getMeituanMinPrice() {
        return meituanMinPrice;
    }

    public void setMeituanMinPrice(double meituanMinPrice) {
        this.meituanMinPrice = meituanMinPrice;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getElemeShippingTime() {
        return elemeShippingTime;
    }

    public void setElemeShippingTime(String elemeShippingTime) {
        this.elemeShippingTime = elemeShippingTime;
    }

    public String getMeituanShippingTime() {
        return meituanShippingTime;
    }

    public void setMeituanShippingTime(String meituanShippingTime) {
        this.meituanShippingTime = meituanShippingTime;
    }

    public String getElemeId() {
        return elemeId;
    }

    public void setElemeId(String elemeId) {
        this.elemeId = elemeId;
    }

    public String getMeituanId() {
        return meituanId;
    }

    public void setMeituanId(String meituanId) {
        this.meituanId = meituanId;
    }

    public double getElemeShippingFee() {
        return elemeShippingFee;
    }

    public void setElemeShippingFee(double elemeShippingFee) {
        this.elemeShippingFee = elemeShippingFee;
    }

    public double getMeituanShippingFee() {
        return meituanShippingFee;
    }

    public void setMeituanShippingFee(double meituanShippingFee) {
        this.meituanShippingFee = meituanShippingFee;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", elemeMinPrice=" + elemeMinPrice +
                ", meituanMinPrice=" + meituanMinPrice +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", elemeShippingTime='" + elemeShippingTime + '\'' +
                ", meituanShippingTime='" + meituanShippingTime + '\'' +
                ", elemeShippingFee=" + elemeShippingFee +
                ", meituanShippingFee=" + meituanShippingFee +
                ", elemeId='" + elemeId + '\'' +
                ", meituanId='" + meituanId + '\'' +
                '}';
    }
}
