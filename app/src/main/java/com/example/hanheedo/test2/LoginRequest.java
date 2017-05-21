package com.example.hanheedo.test2;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Han Heedo on 2017-05-20.
 */

public class LoginRequest extends StringRequest {

    final static private String URL = "http://hido0604.dothome.co.kr/YI/Login.php";
    private Map<String, String> parameters;

    public LoginRequest(String id, String pw, Response.Listener<String> listener)
    {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("id", id);
        parameters.put("pw", pw);
    }

    @Override
    public Map<String, String> getParams() {return parameters;}
}
