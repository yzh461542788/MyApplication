package com.tosleep.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tosleep.myapplication.R;
import com.tosleep.myapplication.adapter.ShopListAdapter;
import com.tosleep.myapplication.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView shopList = findViewById(R.id.shop_list);
        shopList.setAdapter(new ShopListAdapter(this, R.id.shop_list, getNearByRestaurants()));
        shopList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("MAIN", "item has bee clicked");
                Restaurant restaurant = (Restaurant) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("restaurant", restaurant);
                Log.e("MAIN", restaurant.toString());
                startActivity(intent, bundle);
            }
        });
    }

    private List<Restaurant> getNearByRestaurants() {
        // TODO
        List<Restaurant> restaurants = fakeRestaurants();
        return restaurants;
    }

    private List<Restaurant> fakeRestaurants() {
        Restaurant r1 = new Restaurant();
        r1.setAddress("上海市浦东新区碧波路635号105室1F01B-1F01C");
        r1.setName("鲜芋仙（张江店）");
        r1.setImagePath("https://fuss10.elemecdn.com/0/33/f94d302f9a1a1a189240080a099aejpeg.jpeg?imageMogr2/thumbnail/190x190/format/webp/quality/85");
        r1.setElemeMinPrice(25);
        r1.setElemeShippingFee(6);
        r1.setElemeShippingTime("40分钟");

        Restaurant r2 = new Restaurant();
        r2.setAddress("中国（上海）自由贸易试验区碧波路635号1幢101-1F07C区");
        r2.setName("桂源铺（浦东传奇广场店）");
        r2.setImagePath("https://fuss10.elemecdn.com/4/c1/345012e4cca9df3e0ad8e86a43819jpeg.jpeg?imageMogr2/thumbnail/190x190/format/webp/quality/85");
        r2.setElemeMinPrice(20);
        r2.setElemeShippingFee(5);
        r2.setElemeShippingTime("25分钟");

        List<Restaurant> r = new ArrayList<>();
        r.add(r1);
        r.add(r2);
        return r;
    }
}
