package com.swufe.newlife;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class RecordActivity extends AppCompatActivity {

EditText t_record,t_name,t_type;
String tvname;
String tvtype;
String tvrecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        t_name=(EditText)findViewById(R.id.t_name);
        t_type=(EditText)findViewById(R.id.t_type);
        t_record=(EditText)findViewById(R.id.t_record);
        SharedPreferences jilu= getSharedPreferences("record", Activity.MODE_PRIVATE);
        tvname = jilu.getString("t_name","");
        tvtype = jilu.getString("t_type","");
        tvrecord = jilu.getString("t_record","");

        t_name.setText(tvname);
        t_type.setText(tvtype);
        t_record.setText(tvrecord);

    }
    public void onRecord(View btn){
        tvname=t_name.getText().toString();
        tvtype=t_type.getText().toString();
        tvrecord=t_record.getText().toString();
        SharedPreferences rec = getSharedPreferences("record", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=rec.edit();
        editor.putString("t_name",tvname);
        editor.putString("t_type",tvtype);
        editor.putString("t_record",tvrecord);
        editor.commit();
    }
}
