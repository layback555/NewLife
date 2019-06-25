package com.swufe.newlife;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TvseriesActivity extends AppCompatActivity implements Runnable{
    String tv_title="";
    String tv_actor="";
    String tv_type="";
    private static final String TAG = "TvseriesActivity";
    Handler handler;
    public List<HashMap<String, String>> listItems; // 存放文字、图片信息
    MyAdapter adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tv);
        list=(ListView)findViewById(R.id.tv_list);
        Thread t=new Thread(this);
        t.start();

        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 7) {
                    list=(ListView)findViewById(R.id.tv_list);
                    listItems=(List<HashMap<String, String>>)msg.obj;
                    adapter = new MyAdapter(TvseriesActivity.this,R.layout.item_view,listItems);
                    list.setAdapter(adapter);
                }
                super.handleMessage(msg);
            }
        };
}
    public void run() {
        List<HashMap<String,String>> retList=new ArrayList<HashMap<String, String>>();
        Document doc=null;
        try {
            Thread.sleep(3000);
            Log.i(TAG,"run:run...");
            doc = Jsoup.connect("https://www.88ys.cc/lianxuju/2.html").get();
            Log.i(TAG, "run:title" + doc.title());
            Elements lests = doc.getElementsByTag("li");
              for(int i=42;i<=69;i++){
                Element lest=lests.get(i);
                //Log.i(TAG,"run:list["+i+"]"+lest);
                Elements ps=lest.getElementsByTag("p");
                Element p1=ps.get(0);
                if(p1.text()==null){
                    tv_title="";
                }else{
                    tv_title=p1.text();}
                Element p2=ps.get(1);
                if(p2.text()==null){
                    tv_actor="";
                }else{
                 tv_actor=p2.text();}
                Element p3=ps.get(2);
                if(p3.text()==null){
                    tv_actor="";
                }else{
                 tv_type=p3.text();    }            //Log.i(TAG,"run:list["+i+"]"+i+p);            //Log.i(TAG,"run:text="+p.text());
                String content=tv_title+" "+tv_actor+" "+tv_type;
                Log.i(TAG,"list["+i+"]"+"p="+content);
                  HashMap<String, String> map = new HashMap<String, String>();
                  map.put("ItemTitle", tv_title);
                  map.put("ItemDetil", tv_actor);
                  map.put("ItemType", tv_type);
                  Log.i(TAG,"run:map="+map);
                  retList.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message msg=handler.obtainMessage(7);
        msg.obj=retList;
        handler.sendMessage(msg);
        Log.i(TAG,"run:obj="+msg.obj);
    }
    public void onClickRe(View btn){
        Intent rec=new Intent(this,RecordActivity.class);
        startActivity(rec);
    }
    }

