package com.tosleep.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tosleep.myapplication.R;
import com.tosleep.myapplication.model.ProductCategory;

import java.util.List;

/**
 * Created by zihao on 2017/12/21.
 */

public class ProductCategoryListAdapter extends BaseAdapter {
    private List<ProductCategory> mCategories;
    private Context mContext;
    private int mIndex;

    public ProductCategoryListAdapter(Context context, List<ProductCategory> categories) {
        mCategories = categories;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public ProductCategory getItem(int position) {
        return mCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_menu_item, null);
            holder.tv_menu = convertView.findViewById(R.id.tv_category_name);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.updateView(position);
        return convertView;
    }

    public void setIndex(int index) {
        this.mIndex = index;
        notifyDataSetChanged();
    }

    private class Holder {
        private TextView tv_menu;

        public void updateView(final int position) {
            tv_menu.setText(mCategories.get(position).getName());
            if (mIndex == position) {
                tv_menu.setBackgroundColor(Color.WHITE);
            } else {
                tv_menu.setBackgroundColor(Color.GRAY);
            }
        }

    }
}