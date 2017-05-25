package com.example.hanheedo.test2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Han Heedo on 2017-05-25.
 */

public class RealMyitemsList extends AppCompatActivity {
    private ListView listView;
    private ItemListAdapter adapter;
    private List<Item> itemList;
    private List<Item> saveList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myitemslist_buttonclick);

        Intent intent = getIntent();

        listView = (ListView) findViewById(R.id.listView);
        itemList = new ArrayList<Item>();
        saveList = new ArrayList<Item>();
        adapter = new ItemListAdapter(getApplicationContext(), itemList, this, saveList);
        listView.setAdapter(adapter);

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("itemList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String itemNum, itemType, itemName, price, day, lentStatus;
            while (count < jsonArray.length()) {
                JSONObject object = jsonArray.getJSONObject(count);
                itemNum = object.getString("itemNum");
                itemType = object.getString("itemType");
                itemName = object.getString("itemName");
                price = object.getString("price");
                day = object.getString("day");
                lentStatus = object.getString("lentStatus");
                Item item = new Item(itemNum, itemType, itemName, price, day, lentStatus);
                itemList.add(item);
                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

