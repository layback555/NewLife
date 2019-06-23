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
    List<Map<String,String>> list;
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frame_faxian,null);
        lv_record=(ListView)view.findViewById(R.id.l_record);

        SharedPreferences sharedPerferences = getActivity().getSharedPreferences("register", Context.MODE_PRIVATE);
        name = sharedPerferences.getString("user_name","");

        SharedPreferences sp = getActivity().getSharedPreferences("faxian", Context.MODE_PRIVATE);
        question = sp.getString("ques","");
       // Bundle bundle=this.getArguments();
        //question=bundle.getString("ques","");
        list = getData();
        FxXianAdapter myAdapter = new FxXianAdapter(getActivity(),R.layout.item_layout,list);
        lv_record.setAdapter(myAdapter);
        return view;
    }
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
    Date date=new Date(System.currentTimeMillis());
    String d=simpleDateFormat.format(date);

    public List<Map<String,String>> getData(){
        String []na=new String[7];
        String []re=new String[7];
        na[0]=name;na[1]="Jackson";na[2]="王志";na[3]="韩宇";na[4]="时宜";na[5]="Jackson";na[6]="Jackson";
        re[0]=question;re[1]="Is China beautiful?";re[2]="西南财经大学经济信息工程学院怎么样";re[3]="北方有佳人，遗世而独立。";re[4]="哈哈哈哈哈哈或或或或";re[5]="咱也不知道，咱也不敢问";re[6]="规划局看下哈牛";

        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        for(int i=0;i<=6;i++){
            Map<String, String> map=new HashMap<String,String>();
            map.put("F_NAME",na[i]);
            map.put("F_QUESTION",re[i]);
            map.put("F_TIME",d);
            list.add(map);
        }
        return list;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
