package com.example.hanheedo.test2;

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
 * Created by Han Heedo on 2017-03-29.
 */

public class SignUp extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Intent intent = getIntent();
        String data = intent.getStringExtra("Login_SignUp");

        final EditText Id = (EditText) findViewById(R.id.Id); //Id
        Id.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout = (LinearLayout) findViewById(R.id.signup); //Id
        MainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Id.getWindowToken(),0);
            }
        });

        final EditText Password = (EditText) findViewById(R.id.Password); //password
        Password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout2 = (LinearLayout) findViewById(R.id.signup); //password
        MainLayout2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Password.getWindowToken(),0);
            }
        });

        final EditText Name = (EditText) findViewById(R.id.Name); //name
        Name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout3 = (LinearLayout) findViewById(R.id.signup); //name
        MainLayout3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Name.getWindowToken(),0);
            }
        });

        final EditText RePassword = (EditText) findViewById(R.id.Password_confirm); //RePassword
        RePassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout4 = (LinearLayout) findViewById(R.id.signup); //RePassword
        MainLayout4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(RePassword.getWindowToken(),0);
            }
        });

        final EditText PhoneNumber = (EditText) findViewById(R.id.Phone_number); //P/N
        PhoneNumber.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout5 = (LinearLayout) findViewById(R.id.signup); //P/N
        MainLayout5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(PhoneNumber.getWindowToken(),0);
            }
        });

        final EditText GroupName = (EditText) findViewById(R.id.custom_Group); //GroupName
        GroupName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout6 = (LinearLayout) findViewById(R.id.signup); //GroupName
        MainLayout6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(GroupName.getWindowToken(),0);
            }
        });
    }

    public void CancelClick(View view)
    {
        finish();
    }

//    public void SignupClick(View view) { }
}
