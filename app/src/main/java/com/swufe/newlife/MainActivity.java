package com.swufe.newlife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button tiyan;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ViewPager viewpager=(ViewPager)findViewById(R.id.viewpager);
        MyPageAdapter pageAdapter=new MyPageAdapter(getSupportFragmentManager());
        viewpager.setAdapter(pageAdapter);
    }
    public void onClick(View v) {
        Intent intent;
        intent = new Intent(this,FrameActicity.class);
        startActivity(intent);
    }
}
