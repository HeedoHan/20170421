package com.example.hanheedo.test2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Han Heedo on 2017-03-23.
 */

public class Splash_activity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        startActivity(new Intent(Splash_activity.this, LoginActivity.class));
        finish();
    }
}