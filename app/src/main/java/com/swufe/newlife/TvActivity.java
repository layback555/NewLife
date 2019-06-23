package com.swufe.newlife;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TvActivity extends AppCompatActivity implements Runnable{
    private static final String TAG ="TvActivity" ;
    Handler handler;
    String data[]={"加载中，请稍后"};
    private ArrayList<HashMap<String,String>> listItems; // 存放文字、图片信息
    private SimpleAdapter listItemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        ListView listView=(ListView)findViewById(R.id.list_tv);
        ListAdapter adapter = new ArrayAdapter<String>(TvActivity.this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
        initListView();

        Thread t=new Thread(this);
        t.start();

        handler=new Handler() {
            public void handleMessage(Message msg) {
                if(msg.what==5);{
                    ListView listView=(ListView)findViewById(R.id.list_tv);
                List<String> list2= (List<String>) msg.obj;
                    ListAdapter adapter = new ArrayAdapter<String>(TvActivity.this, android.R.layout.simple_list_item_1, list2);
                    listView.setAdapter(adapter);
            }
              super.handleMessage(msg);
        }
    };

}

    private void initListView() {
        listItems = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "Rate： " + i); // 标题文字
            map.put("ItemDetail", "detail:" + i);
            map.put("Itemtype", "type:" + i);// 详情描述
            listItems.add(map);
        }  // 生成适配器的 Item 和动态数组对应的元素
        listItemAdapter = new SimpleAdapter(this, listItems, // listItems 数据源
                R.layout.activity_view, // ListItem 的 XML 布局实现
                new String[]{"ItemTitle", "ItemDetail","Itemtype"},
                new int[]{R.id.tvname, R.id.tvactor,R.id.tvtype});
    }
    @Override
    public void run() {
        Log.i(TAG, "run:run()....");

        List<String> relist=new ArrayList<String>();

        /*URL url= null;
        try {
            url = new URL("https://www.88ys.cc/lianxuju/2.html");
            HttpURLConnection http= (HttpURLConnection) url.openConnection();
            InputStream in=http.getInputStream();
            String html=inputStream2String(in);
            Document doc=Jsoup.parse(html);
            Log.i(TAG,"run:html="+html);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
         catch (IOException e) {
            e.printStackTrace();
        }*/
        Document doc=null;
        try {
            Thread.sleep(2000);
            Log.i(TAG,"run:run...");
            doc = Jsoup.connect("https://www.88ys.cc/lianxuju/2.html").get();
        Log.i(TAG, "run:title" + doc.title());
        Elements lists = doc.getElementsByTag("li");
        for(int i=40;i<=lists.size();i++){
            Element lis=lists.get(i);
            //Log.i(TAG,"run:list["+i+"]"+listi);
            Elements ps=lis.getElementsByTag("p");
                Element p1=ps.get(0);
                String tv_title=p1.text();
                Element p2=ps.get(1);
                String tv_actor=p2.text();
                Element p3=ps.get(2);
                String tv_type=p3.text();
                //Log.i(TAG,"run:list["+i+"]"+i+p);
                //Log.i(TAG,"run:text="+p.text());
            String content=tv_title+" "+tv_actor+" "+tv_type;
                Log.i(TAG,"list["+i+"]"+"p="+content);
                if(content.length()!=0&&content.length()<=25) {
                    relist.add(content);
                }else{
                    relist.add("too lang or too short");
                }
        }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Message msg=handler.obtainMessage(5);
        msg.obj=relist;
        handler.sendMessage(msg);
        Log.i(TAG,"run:msg="+msg);
    }


   public String inputStream2String(InputStream inputStream) throws IOException {
        final int bufferSize=1024;
        final char[] buffer=new char[bufferSize];
       final StringBuilder out = new StringBuilder();
       Reader in = new InputStreamReader(inputStream, "UTF-8");
       for (; ; ) {
           int rsz = in.read(buffer, 0, buffer.length);
           if (rsz < 0)
               break;
           out.append(buffer, 0, rsz);
       }
       return out.toString();
   }
   }

