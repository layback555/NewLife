package com.swufe.newlife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class NewManager {
    private DBHelper dbHelper;
    private String TBNAME;
    public NewManager(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME;//通过类直接访问
    }

    public void add(Reg item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();  //获得数据库
        ContentValues values = new ContentValues();
        values.put("Name", item.getCurname());  //把数据放到对象里边去
        values.put("TEL", item.getCurtel());
        values.put("PASSWORD", item.getCurpassword());
        db.insert(TBNAME, null, values);
        db.close();
    }
    public List<Reg> find(Reg reg){
        List<Reg> rateList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase(); //获得只读数据库
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);  //查询表里所有数据
        if(cursor!=null){  //当游标不为空
            rateList = new ArrayList<Reg>();  //将其实例化
            while(cursor.moveToNext()){  //当光标移到下一有数据行
                Reg item = new Reg();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID"))); //获取ID索引值
                item.setCurname(cursor.getString(cursor.getColumnIndex("CURNAME")));
                item.setCurtel(cursor.getString(cursor.getColumnIndex("CURRATE")));
                item.setCurpassword(cursor.getString(cursor.getColumnIndex("CURRATE")));
                rateList.add(item);  //将每一行的item数据，放到列表里边
            }
            cursor.close(); //关闭光标
        }
        db.close();  //关闭数据库
        return rateList;     }
    }
