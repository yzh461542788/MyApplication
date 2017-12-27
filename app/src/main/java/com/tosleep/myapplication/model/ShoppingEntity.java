package com.tosleep.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zihao on 2017/12/20.
 */

public class ShoppingEntity {

    @SerializedName("id")
    long id;

    @SerializedName("name")
    String name;

    @SerializedName("quantity")
    int quantity;

    @SerializedName("eleme_unit_price")
    double elemeUnitPrice;

    @SerializedName("meituan_unit_price")
    double meituanUnitPrice;

    @SerializedName("eleme_total_price")
    double elemeTotalPrice;

    @SerializedName("meituan_total_price")
    double meituanTotalPrice;

    @SerializedName("product")
    Product product;

    public static ShoppingEntity initWithProduct(Product product) {
        ShoppingEntity entity = new ShoppingEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setElemeUnitPrice(product.getElemePrice());
        entity.setMeituanUnitPrice(product.getMeituanPrice());
        entity.setQuantity(1);
        entity.setProduct(product);

        return entity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.elemeTotalPrice = this.quantity * this.elemeUnitPrice;
        this.meituanTotalPrice = this.quantity * this.meituanUnitPrice;
    }

    public double getElemeUnitPrice() {
        return elemeUnitPrice;
    }

    public void setElemeUnitPrice(double elemeUnitPrice) {
        this.elemeUnitPrice = elemeUnitPrice;
    }

    public double getElemeTotalPrice() {
        return elemeTotalPrice;
    }

    public void setElemeTotalPrice(double elemeTotalPrice) {
        this.elemeTotalPrice = elemeTotalPrice;
    }

    public double getMeituanUnitPrice() {
        return meituanUnitPrice;
    }

    public void setMeituanUnitPrice(double meituanUnitPrice) {
        this.meituanUnitPrice = meituanUnitPrice;
    }

    public double getMeituanTotalPrice() {
        return meituanTotalPrice;
    }

    public void setMeituanTotalPrice(double meituanTotalPrice) {
        this.meituanTotalPrice = meituanTotalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
