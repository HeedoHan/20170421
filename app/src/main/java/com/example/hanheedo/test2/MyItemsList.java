package com.example.hanheedo.test2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MyItemsList extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myitemslist);
        Log.d("tag","debugging message");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Log.d("tag","debugging message");

        toolbar.inflateMenu(R.menu.my_items_list);

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


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        Log.d("tag","debugging message");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("tag","debugging message");
                Intent intent = new Intent(MyItemsList.this, AddItem.class);
                intent.putExtra("List_Add","data_3");
                Log.d("tag","debugging message");
                startActivity(intent);
            }
        });
        Log.d("tag","debugging message");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Log.d("tag","debugging message");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        Log.d("tag","debugging message");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Log.d("tag","debugging message");


        ListView listView = (ListView) findViewById(R.id.listView);
        Log.d("tag","debugging message");

        String[] listVal = new String[] {
                "감자",
                "사과",
                "배",
                "양파",
                "호박"
        };

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < listVal.length; ++i) {
            list.add(listVal[i]);
        }


        final ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(mAdapter);
        Log.d("tag","debugging message");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Log.d("tag","debugging message");
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            Log.d("tag","debugging message");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_items_list, menu);
        Log.d("tag","debugging message");
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

        if (id == R.id.communicate) {
            // Handle the communicate action


        } else if (id == R.id.my_local) {

        } else if (id == R.id.my_group) {

        } else if (id == R.id.my_info) {

        } else if (id == R.id.group_info) {

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
