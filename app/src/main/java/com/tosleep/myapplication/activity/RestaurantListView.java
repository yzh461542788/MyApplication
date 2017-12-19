package com.tosleep.myapplication.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.tosleep.myapplication.model.Restaurant;
import com.tosleep.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuzhaoxin on 2017/12/18.
 */

public class RestaurantListView extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.restaurant,new String[]{"name"},new int[]{R.id.name_rest});
    }
    private List<Map<String, Object>> getData() {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0;i < restaurants.size();i++){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("name",restaurants.get(i).getName());

        }
        return list;
    }
}
