package com.swufe.newlife;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class QueActivity extends AppCompatActivity {
    EditText questions;
    FragmentManager manager;
    android.support.v4.app.FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que);
    }
    public void getOk(View v) {
        questions=(EditText)findViewById(R.id.editText_ques);
        String q=questions.getText().toString();
        SharedPreferences sp = getSharedPreferences("faxian", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("ques",q);
        editor.commit();

        Intent i=new Intent(this,FrameActicity.class);
        startActivity(i);
    }

}
