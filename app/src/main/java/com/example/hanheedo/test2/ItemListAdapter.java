package com.example.hanheedo.test2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Han Heedo on 2017-05-25.
 */

public class ItemListAdapter extends BaseAdapter {
    private Context context;
    private List<Item> itemList;
    private Activity parentActivity;
    private List<Item> saveList;

    public ItemListAdapter (Context context, List<Item> itemList, Activity parentActivity, List<Item> saveList) {
        this.context = context;
        this.itemList = itemList;
        this.parentActivity = parentActivity;
        this.saveList = saveList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.item, null);
        final TextView itemNum = (TextView) v.findViewById(R.id.itemNum);
        TextView itemType = (TextView) v.findViewById(R.id.itemType);
        final TextView itemName = (TextView) v.findViewById(R.id.itemName);
        TextView price = (TextView) v.findViewById(R.id.price);
        TextView day = (TextView) v.findViewById(R.id.day);
        TextView lentStatus = (TextView) v.findViewById(R.id.lentStatus);
        TextView contactInfo = (TextView) v.findViewById(R.id.contactInfo);

        itemNum.setText(itemList.get(i).getItemNum());
        itemType.setText(itemList.get(i).getItemType());
        itemName.setText(itemList.get(i).getItemName());
        price.setText(itemList.get(i).getPrice());
        day.setText(itemList.get(i).getDay());
        lentStatus.setText(itemList.get(i).getLentStatus());
        contactInfo.setText(itemList.get(i).getContactInfo());


        v.setTag(itemList.get(i).getItemNum());

        Button deleteButton = (Button) v.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Response.Listener<String> responseListener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success)
                            {
                                itemList.remove(i);
                                for(int i=0; i<saveList.size();i++)
                                {
                                    if(saveList.get(i).getItemName().equals(itemName.getText().toString()))
                                    {
                                        saveList.remove(i);
                                        break;
                                    }
                                }
                                notifyDataSetChanged();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                DeleteRequest deleteRequest = new DeleteRequest(itemNum.getText().toString(), responseListener);
                RequestQueue queue = Volley.newRequestQueue(parentActivity);
                queue.add(deleteRequest);
            }
        });

        return v;
    }
}
