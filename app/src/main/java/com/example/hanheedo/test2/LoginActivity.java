package com.example.hanheedo.test2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.util.Log;
import com.facebook.FacebookSdk;


public class LoginActivity extends AppCompatActivity
{
    EditText IdInput, PasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /////////////////////////////////////////////

        IdInput = (EditText) findViewById(R.id.edit_id);
        PasswordInput = (EditText) findViewById(R.id.edit_password);

        final EditText editId = (EditText) findViewById(R.id.edit_id); //Id
        editId.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout = (LinearLayout) findViewById(R.id.login); //Id
        MainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editId.getWindowToken(),0);
            }
        });

        final EditText editPassword = (EditText) findViewById(R.id.edit_password); //password
        editPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout2 = (LinearLayout) findViewById(R.id.login); //password
        MainLayout2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editPassword.getWindowToken(),0);
            }
        });
    }



    public void loginClick(View view) // Login Button Click
    {
        Intent intent = new Intent(LoginActivity.this, MyItemsList.class);
        intent.putExtra("Login_List","data_1"); // "DataKey" , "Data"
        startActivity(intent);
        Log.d("tag","debugging message");
    }

    public void signUpClick(View view) // SignUp Button Click
    {
        Intent intent = new Intent(LoginActivity.this, SignUp.class);
        intent.putExtra("Login_SignUp","data_2");
        startActivity(intent);
        Log.d("tag","debugging message");
    }
}
