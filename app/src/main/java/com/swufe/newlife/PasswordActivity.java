package com.swufe.newlife;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {
    EditText oldpassword;
    EditText newpassword;
    EditText renewpassword;
    String oldpass,old_pass;
    String newpass;
    String renewpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        SharedPreferences sharedPerferences = getSharedPreferences("register", Context.MODE_PRIVATE);
        old_pass = sharedPerferences.getString("user_name","");

    }
    public void rePass(View v) {
        oldpassword=(EditText)findViewById(R.id.oldpassword);
        newpassword=(EditText)findViewById(R.id.newpassword);
        renewpassword=(EditText)findViewById(R.id.renewpassword);
        oldpass=oldpassword.getText().toString();
        newpass=newpassword.getText().toString();
        renewpass=renewpassword.getText().toString();
        if(oldpass.equals(old_pass)) {
            if (newpass.equals(renewpass)) {
                SharedPreferences ps = getSharedPreferences("regis", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = ps.edit();
                editor.putString("user_password", newpass);
                editor.commit();

                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "两次输入密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "输入的原密码不正确", Toast.LENGTH_SHORT).show();
        }
    }
}
