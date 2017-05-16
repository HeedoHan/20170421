package com.example.hanheedo.test2;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Han Heedo on 2017-03-17.
 */

public class AddItem extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem);

        ///////////////////////////////////////////////////////

        Intent intent = getIntent();
        String data = intent.getStringExtra("List_Add");

        ///////////////////////////////////////////////////////

        final EditText ItemName = (EditText) findViewById(R.id.item_name); //Item_name
        ItemName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout = (LinearLayout) findViewById(R.id.additem); //Item_name
        MainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(ItemName.getWindowToken(),0);
            }
        });

        final EditText ItemType = (EditText) findViewById(R.id.item_type); //Item_type
        ItemType.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout2 = (LinearLayout) findViewById(R.id.additem); //Item_type
        MainLayout2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(ItemType.getWindowToken(),0);
            }
        });

        final EditText ItemInfo = (EditText) findViewById(R.id.item_information); //Item_info
        ItemInfo.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout3 = (LinearLayout) findViewById(R.id.additem); //Item_info
        MainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(ItemInfo.getWindowToken(),0);
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////

    }


    public void cancelClick(View view)
    {
        finish();
    }

//    public void AddClick(View view) { }

}
