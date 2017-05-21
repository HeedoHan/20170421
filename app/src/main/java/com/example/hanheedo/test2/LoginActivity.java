package com.example.hanheedo.test2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.facebook.FacebookSdk;

import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("tag", "debugging message");

        ///////////////////////////////////////////

        final EditText editId = (EditText) findViewById(R.id.edit_id); //Id
        editId.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout = (LinearLayout) findViewById(R.id.login); //Id
        MainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editId.getWindowToken(), 0);
            }
        });

        final EditText editPassword = (EditText) findViewById(R.id.edit_password); //password
        editPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    return true;
                }
                return false;
            }
        });

        LinearLayout MainLayout2 = (LinearLayout) findViewById(R.id.login); //password
        MainLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editPassword.getWindowToken(), 0);
            }
        });
        

    }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void loginClick(View view) // Login Button Click
    {

        final EditText IdInput = (EditText) findViewById(R.id.edit_id);
        final EditText PasswordInput = (EditText) findViewById(R.id.edit_password);
        final String id = IdInput.getText().toString();
        final String pw = PasswordInput.getText().toString();
        Log.d("tag", "debugging message");

        Response.Listener<String> responseListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    Log.d("tag", "debugging message");

                    if (success) {
                        String id = jsonResponse.getString("id");
                        String pw = jsonResponse.getString("pw");
                        Log.d("tag", "debugging message");
                        Intent intent = new Intent(LoginActivity.this, MyItemsList.class);
                        intent.putExtra("id", id);
                        intent.putExtra("pw", pw);
                        Log.d("tag", "debugging message");
                        LoginActivity.this.startActivity(intent);
                        Log.d("tag", "debugging message");
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        Log.d("tag", "debugging message");
                        builder.setMessage("로그인에 실패하였습니다.")
                                .setNegativeButton("다시 시도", null)
                                .create()
                                .show();
                        Log.d("tag", "debugging message");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        LoginRequest loginRequest = new LoginRequest(id, pw, responseListener);
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        queue.add(loginRequest);
    }


    public void signUpClick(View view) // SignUp Button Click
    {
        Intent intent = new Intent(LoginActivity.this, SignUp.class);
        intent.putExtra("Login_SignUp", "data_2");
        startActivity(intent);
        Log.d("tag", "debugging message");
    }
}

