package com.swufe.newlife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    EditText name;
    EditText tel;
    EditText password;
    Button btn_register;
    String sname,stel,spassword;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register=(Button) findViewById(R.id.btn_register);
        name=(EditText)findViewById(R.id.reg_name);
        tel=(EditText)findViewById(R.id.reg_tel);
        password=(EditText)findViewById(R.id.reg_password);
    }
    public void getRegister(View v) {
        sname=name.getText().toString();
        stel=tel.getText().toString();
        spassword=password.getText().toString();

        Intent regis;
        regis = new Intent();
        Bundle b=new Bundle();
        b.putString("user-name",sname);
        b.putString("user-password",spassword);
        regis.putExtras(b);
        setResult(2,regis);
        finish();
    }

}
