package com.tosleep.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.tosleep.myapplication.R;
import com.tosleep.myapplication.adapter.ShopListAdapter;
import com.tosleep.myapplication.model.Restaurant;
import com.tosleep.myapplication.widget.ShoppingCartPanel;

import za.co.immedia.pinnedheaderlistview.PinnedHeaderListView;

/**
 * Created by zihao on 2017/12/19.
 */

public class MenuActivity extends AppCompatActivity {
    private Restaurant mRestaurant;

    private BottomSheetLayout mBottomSheetLayout;
    private ListView mCategoryListView;
    private PinnedHeaderListView mProductListView;
    private LinearLayout mShoppingInfoLayout;
    private ImageView mCartLogoImg;
    private TextView mSelectedCountTxt;
    private TextView mTotalPriceTxt;
    private Button mSettleBtn;

    private ShoppingCartPanel mShoppingCartPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bindWidgets();
        Intent intent = getIntent();
        mRestaurant = (Restaurant) intent.getSerializableExtra("restaurant");

        mShoppingCartPanel = new ShoppingCartPanel(this);

    }

    private void bindWidgets() {
        mBottomSheetLayout = findViewById(R.id.bottom_sheet_layout);
        mCategoryListView = findViewById(R.id.lv_product_category);
        mProductListView = findViewById(R.id.lv_product_list);
        mShoppingInfoLayout = findViewById(R.id.layout_shopping_info);
        mCartLogoImg = findViewById(R.id.img_cart_logo);
        mSelectedCountTxt = findViewById(R.id.txt_selected_count);
        mTotalPriceTxt = findViewById(R.id.txt_total_price);
        mSettleBtn = findViewById(R.id.btn_settle);
    }
}
