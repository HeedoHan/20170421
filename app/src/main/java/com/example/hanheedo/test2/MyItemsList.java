package com.example.hanheedo.test2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyItemsList extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FloatingActionButton addFab;

    private ListView listView;
    private ItemListAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myitemslist);


        Intent intent = getIntent();

        String id = intent.getStringExtra("id");
        String pw = intent.getStringExtra("pw");
        String name = intent.getStringExtra("name");
        String pnum = intent.getStringExtra("pnum");
        String gname = intent.getStringExtra("gname");
        String sd = intent.getStringExtra("sd");
        String sgg = intent.getStringExtra("sgg");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        View nav_header_view = navigationView.inflateHeaderView(R.layout.nav_header_my_items_list);
        View nav_header_view = navigationView.getHeaderView(0);

        TextView nameNavText = (TextView) nav_header_view.findViewById(R.id.nav_head_name);
        TextView localNavText = (TextView) nav_header_view.findViewById(R.id.nav_head_local);
        TextView groupNavText = (TextView) nav_header_view.findViewById(R.id.nav_head_group);

        nameNavText.setText(name);
        localNavText.setText(sd + " " + sgg);
        groupNavText.setText(gname);

//        Toast.makeText(getApplicationContext(), id +"님, 환영합니다.", Toast.LENGTH_SHORT).show();


        //////////////////////////////////////////////////////////

        listView = (ListView) findViewById(R.id.listView);
        itemList = new ArrayList<Item>();
        adapter = new ItemListAdapter(getApplicationContext(), itemList);
        listView.setAdapter(adapter);
        Log.d("tag", "debugging message");

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("itemList"));
            Log.d("tag", "debugging message");
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String itemNum, itemType, itemName, price, day, lentStatus;
            while(count < jsonArray.length())
            {
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

        //////////////////////////////////////////////////////////

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.my_items_list);

        ///////////////////////////////////////////////////////////

        SearchView mSearchView;

        mSearchView = (SearchView) toolbar.getMenu().findItem(R.id.menu_search).getActionView();
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        /////////////////////////////////////////////////////////////////////////////


        FloatingActionButton addFab = (FloatingActionButton) findViewById(R.id.add);

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyItemsList.this, AddItem.class);
                intent.putExtra("itemList","data_3"); // "DataKey" , "Data"
                startActivity(intent);
            }
        });

        /////////////////////////////////////////////////////////////////////////////


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ////////////////////////////////////////////////////////////////////////////////

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }

        else
        {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_items_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.MailBox) {

            //
            return true;
        }
        else if (id==R.id.menu_search) {
            //

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_local) {
            // Handle the communicate action

        } else if (id == R.id.my_group) {

        } else if (id == R.id.my_info) {

        } else if (id == R.id.local_communicate) {

        } else if (id == R.id.group_communicate) {

        } else if (id == R.id.setting) {

        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Log.d("tag","debugging message");
        drawer.closeDrawer(GravityCompat.START);
        Log.d("tag","debugging message");
        return true;
    }

}
