package com.tosleep.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tosleep.myapplication.R;
import com.tosleep.myapplication.model.Product;
import com.tosleep.myapplication.model.ProductCategory;
import com.tosleep.myapplication.model.ShoppingCart;
import com.tosleep.myapplication.widget.ShoppingCountView;

import java.util.List;

import za.co.immedia.pinnedheaderlistview.SectionedBaseAdapter;

/**
 * Created by zihao on 2017/12/25.
 */

public class ProductItemAdapter extends SectionedBaseAdapter {
    private Context mContext;
    private List<ProductCategory> mCategories;
    private LayoutInflater mInflater;
    private ShoppingCart mShoppingCart;

    public ProductItemAdapter(@NonNull Context context, @NonNull List<ProductCategory> categories) {
        this.mContext = context;
        this.mCategories = categories;
        mInflater = LayoutInflater.from(mContext);
        mShoppingCart = ShoppingCart.getInstance();
    }

    @Override
    public Product getItem(int section, int position) {
        return mCategories.get(section).getProducts().get(position);
    }

    @Override
    public long getItemId(int section, int position) {
        return position;
    }

    @Override
    public int getSectionCount() {
        return mCategories.size();
    }

    @Override
    public int getCountForSection(int section) {
        return mCategories.get(section).getProducts().size();
    }

    @Override
    public View getItemView(int section, int position, View convertView, ViewGroup parent) {
        final ItemViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layout_product_item, null);
            holder = new ItemViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ItemViewHolder) convertView.getTag();
        }
        Product product = getItem(section, position);
//        holder.itemImage.loadProductPhoto(product);
        holder.tvProductName.setText(product.getName());
        if (product.getElemePrice() < 0 ) {
            holder.tvElemePrice.setText("暂无");
        } else {
            holder.tvElemePrice.setText("¥" + product.getElemePrice());
        }
        if (product.getMeituanPrice() < 0) {
            holder.tvMeituanPrice.setText("暂无");
        } else {
            holder.tvMeituanPrice.setText("¥" + product.getMeituanPrice());
        }

        final Product finalProduct = product;
        int quantity = ShoppingCart.getInstance().getQuantityForProduct(finalProduct);
        holder.shoppingCountView.setShoppingCount(quantity);
        holder.shoppingCountView.setOnShoppingClickListener(new ShoppingCountView.ShoppingClickListener() {
            @Override
            public void onAddClick(int num) {
                if (!ShoppingCart.getInstance().push(finalProduct)) {
                    // 添加失败则恢复数量
                    int oldQuantity = ShoppingCart.getInstance().getQuantityForProduct(finalProduct);
                    holder.shoppingCountView.setShoppingCount(oldQuantity);
                }
            }

            @Override
            public void onMinusClick(int num) {
                if (!ShoppingCart.getInstance().pop(finalProduct)) {
                    // 减少失败则恢复数量
                    int oldQuantity = ShoppingCart.getInstance().getQuantityForProduct(finalProduct);
                    holder.shoppingCountView.setShoppingCount(oldQuantity);
                }
            }
        });
        holder.shoppingCountView.setVisibility(View.VISIBLE);
        return convertView;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layout_product_header, parent, false);
            holder = new HeaderViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }
        ProductCategory productCategory = mCategories.get(section);
        holder.titleTxt.setText(productCategory.getName());
        return convertView;
    }

    public static class HeaderViewHolder {
        TextView titleTxt;
        HeaderViewHolder(View headerView) {
            titleTxt = headerView.findViewById(R.id.txt_title);
        }
    }

    public static class ItemViewHolder {
        ImageView itemImage;
        TextView tvProductName;
        TextView tvElemePrice;
        TextView tvMeituanPrice;
        ShoppingCountView shoppingCountView;

        ItemViewHolder(View itemView) {
            itemImage = itemView.findViewById(R.id.image_product_item);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvElemePrice = itemView.findViewById(R.id.tv_eleme_price);
            tvMeituanPrice = itemView.findViewById(R.id.tv_meituan_price);
            shoppingCountView = itemView.findViewById(R.id.shopping_count_view);
        }
    }
}
