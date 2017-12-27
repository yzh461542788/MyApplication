package com.tosleep.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tosleep.myapplication.R;
import com.tosleep.myapplication.model.Restaurant;
import com.tosleep.myapplication.model.ShoppingCart;

import java.util.List;

/**
 * Created by zihao on 2017/12/19.
 */

public class ShopListAdapter extends ArrayAdapter<Restaurant> {
    private Context mContext;
    private List<Restaurant> mRestaurants;


    public ShopListAdapter(@NonNull Context context, int resource, @NonNull List<Restaurant> restaurants) {
        super(context, resource, restaurants);
        this.mContext = context;
        this.mRestaurants = restaurants;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.layout_shop_item, parent, false);
        Restaurant restaurant = mRestaurants.get(position);

        ImageView avatar = rowView.findViewById(R.id.shop_avatar);

        TextView name = rowView.findViewById(R.id.txt_name);
        name.setText(restaurant.getName());

        String content = "起送  ¥" + restaurant.getElemeMinPrice() + "  配送费 ¥ " + restaurant.getElemeShippingFee()
                + "  平均"  + restaurant.getElemeShippingTime();
        TextView contentView = rowView.findViewById(R.id.txt_content);
        contentView.setText(content);
        // TODO: render the list item view
        ShoppingCart shoppingCart = ShoppingCart.getInstance();
        return rowView;
    }
}
