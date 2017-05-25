package com.example.hanheedo.test2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Han Heedo on 2017-05-25.
 */

public class ItemListAdapter extends BaseAdapter {
    private Context context;
    private List<Item> itemList;

    public ItemListAdapter (Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.item, null);
        TextView itemNum = (TextView) v.findViewById(R.id.itemNum);
        TextView itemType = (TextView) v.findViewById(R.id.itemType);
        TextView itemName = (TextView) v.findViewById(R.id.itemName);
        TextView price = (TextView) v.findViewById(R.id.price);
        TextView day = (TextView) v.findViewById(R.id.day);
        TextView lentStatus = (TextView) v.findViewById(R.id.lentStatus);

        itemNum.setText(itemList.get(i).getItemNum());
        itemType.setText(itemList.get(i).getItemType());
        itemName.setText(itemList.get(i).getItemName());
        price.setText(itemList.get(i).getPrice());
        day.setText(itemList.get(i).getDay());
        lentStatus.setText(itemList.get(i).getLentStatus());

        v.setTag(itemList.get(i).getItemNum());
        return v;
    }
}
