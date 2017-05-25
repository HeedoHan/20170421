package com.example.hanheedo.test2;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Han Heedo on 2017-05-25.
 */

public class DeleteRequest extends StringRequest {

    final static private  String URL = "http://hido0604.dothome.co.kr/YI/delete.php";
    private Map<String,String> parameters;

    public DeleteRequest(String num, Response.Listener<String> listener)
    {
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("itemNum", num);
    }

    @Override
    public Map <String, String> getParams() {
        return parameters;
    }
}
