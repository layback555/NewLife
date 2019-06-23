package com.swufe.newlife;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.SimpleAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TvseriesActivity extends ListActivity implements Runnable{
    String tv_title="";
    String tv_actor="";
    String tv_type="";
    private static final String TAG = "TvseriesActivity";
    Handler handler;
    public ArrayList<HashMap<String, String>> listItems; // 存放文字、图片信息
    public SimpleAdapter listItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListView();
        //MyAdapter myAdapter = new MyAdapter(this, R.layout.activity_view, listItems);
        this.setListAdapter(listItemAdapter);

        Thread t=new Thread(this);
        t.start();

        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 7) {
                    listItems= (ArrayList<HashMap<String, String>>)msg.obj;
                    listItemAdapter = new SimpleAdapter(TvseriesActivity.this, listItems,//listItems数据源
                            R.layout.activity_view,//ListItem的XML布局实现
                            new String[]{"ItemTitle", "ItemDetail","ItemType"},
                            new int[]{R.id.tvname, R.id.tvactor,R.id.tvtype}
                    );
                    setListAdapter(listItemAdapter);
                }
                super.handleMessage(msg);
            }
        };
}
    public void initListView() {
        listItems = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "Rate： " + i); // 标题文字
            map.put("ItemDetail", "detail:" + i);
            map.put("ItemType", "type:" + i); // 详情描述
            listItems.add(map);
            Log.i(TAG,"run:map"+map);
        }  // 生成适配器的 Item 和动态数组对应的元素
        listItemAdapter = new SimpleAdapter(this, listItems, // listItems 数据源
                R.layout.activity_view, // ListItem 的 XML 布局实现
                new String[]{"ItemTitle", "ItemDetail","ItemType"},
                new int[]{R.id.tvname, R.id.tvactor,R.id.tvtype}
                );
    }
    public void run() {
        List<HashMap<String,String>> retList=new ArrayList<HashMap<String, String>>();
        Document doc=null;
        try {
            Thread.sleep(9000);
            Log.i(TAG,"run:run...");
            doc = Jsoup.connect("https://www.88ys.cc/lianxuju/2.html").get();
            Log.i(TAG, "run:title" + doc.title());
            Elements lests = doc.getElementsByTag("li");
              for(int i=40;i<=lests.size();i++){
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
}
