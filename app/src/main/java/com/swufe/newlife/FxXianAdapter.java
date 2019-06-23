package com.swufe.newlife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class FxXianAdapter extends ArrayAdapter {
    public FxXianAdapter(Context context, int resource, List<Map<String, String>> list) {
        super(context, resource, list);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null){
            itemView=LayoutInflater.from(getContext()).inflate(R.layout.item_layout,parent,false);
        }
        Map<String,String> map=(Map<String,String>)getItem(position);
        TextView name=(TextView)itemView.findViewById(R.id.f_name);
        TextView question=(TextView)itemView.findViewById(R.id.f_question);
        TextView time=(TextView)itemView.findViewById(R.id.f_time);
        name.setText(map.get("F_NAME"));
        question.setText(map.get("F_QUESTION"));
        time.setText(map.get("F_TIME"));
        return itemView;
    }
}
