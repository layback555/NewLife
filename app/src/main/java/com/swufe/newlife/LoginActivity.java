package com.swufe.newlife;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG ="LoginActivity" ;
    EditText lname;
    EditText lpassword;
    String uname,usename;
    String upassword,usepassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lname = (EditText) findViewById(R.id.user_name);
        lpassword = (EditText) findViewById(R.id.user_password);

        SharedPreferences sharedPerferences = getSharedPreferences("register", Activity.MODE_PRIVATE);
        usename = sharedPerferences.getString("user_name","");
        usepassword = sharedPerferences.getString("user_password","");
}
    public void loGin(View v) {
        String u_name=lname.getText().toString();
        String u_password=lpassword.getText().toString();
        if(u_name.equals(usename)&&u_password.equals(usepassword)){
            Intent intent;
            intent = new Intent(this,FrameActicity.class);
            Bundle b=new Bundle();
            b.putString("user-name",uname);
            intent.putExtras(b);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"用户名或密码不符",Toast.LENGTH_SHORT).show();
        }
    }
    public void reGister(View v) {
        Intent re;
        re = new Intent(this,RegisterActivity.class);
        startActivityForResult(re,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent regis) {
        if(requestCode==1&&resultCode==2){
            Bundle bundle = regis.getExtras();
            uname = bundle.getString("user-name","");
            upassword = bundle.getString("user-password","");
            Log.i(TAG,"onActivityResult: uname="+uname);
            Log.i(TAG,"onActivityResult: upassword="+upassword);

            SharedPreferences sharedPerferences = getSharedPreferences("register", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPerferences.edit();
            editor.putString("user_name",uname);
            editor.putString("user_password",upassword);
            editor.commit();

        }
        super.onActivityResult(requestCode, resultCode, regis);
    }
}
