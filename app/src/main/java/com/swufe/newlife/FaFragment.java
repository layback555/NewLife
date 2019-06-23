package com.swufe.newlife;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaFragment extends Fragment {
    ListView lv_record;
    String name;
   String question;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frame_faxian,null);

        SharedPreferences sharedPerferences = getActivity().getSharedPreferences("register", Context.MODE_PRIVATE);
        name = sharedPerferences.getString("user_name","");

        SharedPreferences sp = getActivity().getSharedPreferences("faxian", Context.MODE_PRIVATE);
        question = sp.getString("ques","");
       // Bundle bundle=this.getArguments();
        //question=bundle.getString("ques","");

        lv_record=(ListView)view.findViewById(R.id.l_record);
        List<Map<String,String>>list=getData();
        FxXianAdapter myAdapter = new FxXianAdapter(getActivity(),R.layout.item_layout,list);
        lv_record.setAdapter(myAdapter);
        return view;
    }
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
    Date date=new Date(System.currentTimeMillis());
    String d=simpleDateFormat.format(date);

    public List<Map<String,String>>getData(){
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        for(int i=0;i<1;i++){
            Map<String, String> map=new HashMap<String,String>();
            map.put("F_NAME",name);
            map.put("F_QUESTION",question);
            map.put("F_TIME",d);
            list.add(map);
        }
        return list;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
