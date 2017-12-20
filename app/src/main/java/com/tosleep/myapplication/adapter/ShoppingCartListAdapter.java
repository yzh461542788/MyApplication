package com.tosleep.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.tosleep.myapplication.model.ShoppingEntity;

import java.util.List;

/**
 * Created by zihao on 2017/12/20.
 */

public class ShoppingCartListAdapter extends RecyclerView.Adapter {
    private List<ShoppingEntity> items;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setItems(List<ShoppingEntity> items) {
        this.items = items;
    }

    public void clearItems() {

    }
}
