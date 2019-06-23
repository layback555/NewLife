package com.swufe.newlife;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class GeQianActivity extends AppCompatActivity {
String geqian;
EditText ge_qian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ge_qian);
        ge_qian=(EditText)findViewById(R.id.editText_geqian);
    }
    public void onWo(View v) {
        ge_qian=(EditText)findViewById(R.id.editText_geqian);
        geqian=ge_qian.getText().toString();
        Intent ge;
        SharedPreferences geq = getSharedPreferences("geqian", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=geq.edit();
        editor.putString("ge_qian",geqian);
        editor.commit();

        ge = new Intent(this,FrameActicity.class);
        Bundle b=new Bundle();
        b.putString("ge-qian",geqian);
        ge.putExtras(b);
        startActivity(ge);
    }
}
