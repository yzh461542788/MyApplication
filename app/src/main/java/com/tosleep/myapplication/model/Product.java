package com.tosleep.myapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zihao on 2017/12/20.
 */

public class Product {
    //在饿了么中的itemId
    @SerializedName("id")
    String _id;

    //用饿了么餐馆id而不是美团
    @SerializedName("restaurant_id")
    String restaurantId;

    //分类名
    @SerializedName("category_id")
    String categoryId;

    //商品中文名
    @SerializedName("name")
    String name;

    @SerializedName("eleme_price")
    Double elemePrice;

    @SerializedName("meituan_price")
    Double meituanPrice;

    @SerializedName("description")
    String description;

    @SerializedName("image_path")
    String imagePath;

    @SerializedName("eleme_month_sales")
    int elemeMonthSales;

    @SerializedName("meituan_month_sales")
    int meituanMonthSales;

    @SerializedName("eleme_rate")
    int elemeRate;

    @SerializedName("meituan_rate")
    int meituanRate;

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getElemePrice() {
        return elemePrice;
    }

    public void setElemePrice(Double elemePrice) {
        this.elemePrice = elemePrice;
    }

    public Double getMeituanPrice() {
        return meituanPrice;
    }

    public void setMeituanPrice(Double meituanPrice) {
        this.meituanPrice = meituanPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getElemeMonthSales() {
        return elemeMonthSales;
    }

    public void setElemeMonthSales(int elemeMonthSales) {
        this.elemeMonthSales = elemeMonthSales;
    }

    public int getElemeRate() {
        return elemeRate;
    }

    public void setElemeRate(int elemeRate) {
        this.elemeRate = elemeRate;
    }

    public int getMeituanMonthSales() {
        return meituanMonthSales;
    }

    public void setMeituanMonthSales(int meituanMonthSales) {
        this.meituanMonthSales = meituanMonthSales;
    }

    public int getMeituanRate() {
        return meituanRate;
    }

    public void setMeituanRate(int meituanRate) {
        this.meituanRate = meituanRate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + _id +
                ", restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", elemePrice=" + elemePrice +
                ", meituanPrice=" + meituanPrice +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", elemeMonthSales=" + elemeMonthSales +
                ", meituanMonthSales=" + meituanMonthSales +
                ", elemeRate=" + elemeRate +
                ", meiruanRate=" + meituanRate +
                '}';
    }
}
