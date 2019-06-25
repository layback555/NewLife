package com.swufe.newlife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends ArrayAdapter {
    public MyAdapter(Context context, int resource, List<HashMap<String, String>> list) {
        super(context, resource, list);
    }

    public View getView(int position, View convertView,ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null){
            itemView=LayoutInflater.from(getContext()).inflate(R.layout.item_view,parent,false);
        }
        Map<String,String> map=(Map<String,String>)getItem(position);
        TextView name=(TextView)itemView.findViewById(R.id.tvname);
        TextView actor=(TextView)itemView.findViewById(R.id.tvactor);
        TextView type=(TextView)itemView.findViewById(R.id.tvtype);
        name.setText(map.get("ItemTitle"));
        actor.setText(map.get("ItemDetail"));
        type.setText(map.get("ItemType"));
        return itemView;
    }
}
