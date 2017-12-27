package com.tosleep.myapplication.model;

import android.support.annotation.NonNull;

/**
 * Created by zihao on 2017/12/27.
 */

public class Discount implements Comparable<Discount> {
    private double lowLimit;
    private double discountPrice;

    public double getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(double lowLimit) {
        this.lowLimit = lowLimit;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public int compareTo(@NonNull Discount o) {
        double d = this.discountPrice - o.discountPrice;
        if (d == 0) return 0;
        if (d < 0) return -1;
        return 1;
    }
}
