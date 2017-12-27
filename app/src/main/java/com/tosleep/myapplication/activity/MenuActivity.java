package com.tosleep.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tosleep.myapplication.R;
import com.tosleep.myapplication.adapter.ProductCategoryListAdapter;
import com.tosleep.myapplication.adapter.ProductItemAdapter;
import com.tosleep.myapplication.model.Product;
import com.tosleep.myapplication.model.ProductCategory;
import com.tosleep.myapplication.model.Restaurant;

import java.util.Arrays;
import java.util.List;

import za.co.immedia.pinnedheaderlistview.PinnedHeaderListView;

/**
 * Created by zihao on 2017/12/19.
 */

public class MenuActivity extends AppCompatActivity {
    private ListView lv_menu;
    private PinnedHeaderListView lv_item;
    private ProductCategoryListAdapter menuAdapter;
    private ProductItemAdapter itemAdapter;
    private Restaurant mRestaurant;
    private List<ProductCategory> mCategories;
    private int mSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        mRestaurant = (Restaurant) intent.getExtras().getSerializable("restaurant");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);
        setView();
        setData();
    }

    private void setView() {
        lv_menu = findViewById(R.id.lv_menu);
        lv_item = findViewById(R.id.lv_item);
    }

    private void setData() {
        mCategories = getProductCategory(mRestaurant);
        itemAdapter = new ProductItemAdapter(this, mCategories);
        lv_item.setAdapter(itemAdapter);
        menuAdapter = new ProductCategoryListAdapter(this, mCategories);
        lv_menu.setAdapter(menuAdapter);
        lv_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                menuAdapter.setIndex(position);
                int rightSection = 0;
                for (int i = 0; i < position; i++) {
                    rightSection += itemAdapter.getCountForSection(i) + 1;
                }
                lv_item.setSelection(rightSection);
            }
        });

        lv_item.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView arg0, int scrollState) {
                switch (scrollState) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (lv_item.getLastVisiblePosition() == (lv_item.getCount() - 1)) {
                            lv_menu.setSelection(ListView.FOCUS_DOWN);
                        }

                        // 判断滚动到顶部
                        if (lv_item.getFirstVisiblePosition() == 0) {
                            lv_menu.setSelection(0);
                        }
                        break;
                }
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int section = itemAdapter.getSectionForPosition(firstVisibleItem);
                if (mSection != section) {
                    menuAdapter.setIndex(section);
                    mSection = section;
                }
            }
        });
    }

    private List<ProductCategory> getProductCategory(Restaurant mRestaurant) {
        Product[] products = new Product[100];
        for (int i = 0; i < 100; i++) {
            products[i] = new Product();
            products[i].setName("p" + i);
            products[i].setRestaurantId("1");
        }
        ProductCategory[] categories = new ProductCategory[10];
        for (int i = 0; i < 10; i++) {
            categories[i] = new ProductCategory();
            for (int j = 0; j < 10; j++) {
                categories[i].addProduct(products[i * 10 + j]);
            }
            categories[i].setName("c" + i);
        }
        return Arrays.asList(categories);
    }
}
