package com.example.hanheedo.test2;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Han Heedo on 2017-03-17.
 */

public class AddItem extends AppCompatActivity
{
    private EditText ItemType, ItemName, Price, Day;
    ArrayAdapter<CharSequence> spinner3;
    String lentStatus;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem);

        Log.d("tag", "debugging message");

        ItemType = (EditText) findViewById(R.id.item_type);
        ItemName = (EditText) findViewById(R.id.item_name);
        Price = (EditText) findViewById(R.id.editprice);
        Day = (EditText) findViewById(R.id.editday);

        final Spinner spin3 = (Spinner) findViewById(R.id.status_spinner);

        ////////////////////////////////////////////////////////

        spinner3 = ArrayAdapter.createFromResource(AddItem.this, R.array.spinner_lentStatus, R.layout.support_simple_spinner_dropdown_item);
        spin3.setAdapter(spinner3);
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lentStatus = spinner3.getItem(position).toString();
                String lentStatus = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ///////////////////////////////////////////////////////////////////

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
    }


    public void cancelClick(View view)
    {
        finish();
    }

    public void AddClick(View view)
    {
        String itemType = ItemType.getText().toString();
        String itemName = ItemName.getText().toString();
        String price = Price.getText().toString();
        String day = Day.getText().toString();
        Log.d("tag", "debugging message");

        if (ItemType.getText().toString().length() == 0) {
            Toast.makeText(AddItem.this, "ItemType을 입력하세요.", Toast.LENGTH_SHORT).show();
            ItemType.requestFocus();
            return;
        }

        if (ItemName.getText().toString().length() == 0) {
            Toast.makeText(AddItem.this, "ItemName을 입력하세요.", Toast.LENGTH_SHORT).show();
            ItemName.requestFocus();
            return;
        }

        if (Price.getText().toString().length() == 0) {
            Toast.makeText(AddItem.this, "Price를 입력하세요.", Toast.LENGTH_SHORT).show();
            Price.requestFocus();
            return;
        }

        if (Day.getText().toString().length() == 0) {
            Toast.makeText(AddItem.this, "Day를 입력하세요.", Toast.LENGTH_SHORT).show();
            Day.requestFocus();
            return;
        }

        insertToDataBase(itemType, itemName, price, day, lentStatus);
        new BackgroundTask().execute();
        finish();
    }

    private void insertToDataBase(String itemType, String itemName, String price, String day, String lentStatus) {
        class InsertData extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(AddItem.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                try {
                    String itemType = (String) params[0];
                    String itemName = (String) params[1];
                    String price = (String) params[2];
                    String day = (String) params[3];
                    String lentStatus = (String) params[4];

                    String link = "http://hido0604.dothome.co.kr/YI/addItem.php";
                    String data = URLEncoder.encode("itemType", "UTF-8") + "=" + URLEncoder.encode(itemType, "UTF-8");
                    data += "&" + URLEncoder.encode("itemName", "UTF-8") + "=" + URLEncoder.encode(itemName, "UTF-8");
                    data += "&" + URLEncoder.encode("price", "UTF-8") + "=" + URLEncoder.encode(price, "UTF-8");
                    data += "&" + URLEncoder.encode("day", "UTF-8") + "=" + URLEncoder.encode(day, "UTF-8");
                    data += "&" + URLEncoder.encode("lentStatus", "UTF-8") + "=" + URLEncoder.encode(lentStatus, "UTF-8");

                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write(data);
                    wr.flush();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }
                    return sb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }
            }
        }

        InsertData task = new InsertData();
        task.execute(itemType, itemName, price, day, lentStatus);
    }

    private class BackgroundTask extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected void onPreExecute() {
            target = "http://hido0604.dothome.co.kr/YI/ItemsRequest.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp=bufferedReader.readLine())!= null)
                {
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public  void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        public void onPostExecute(String result) {
            Intent intent = new Intent(AddItem.this, MyItemsList.class);
            intent.putExtra("itemList", result);
            AddItem.this.startActivity(intent);
        }
    }
}
