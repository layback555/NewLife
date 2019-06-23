package com.swufe.newlife;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FrameActicity extends FragmentActivity {
    public Fragment mFragments[];
    public RadioGroup radioGroup;
    public FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;
    public RadioButton rbtShou,rbtFa,rbtWo;
   TextView wode;
    String wo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_frame);
        wode=(TextView) findViewById(R.id.textView_wode);
        SharedPreferences geq = getSharedPreferences("geqian", Context.MODE_PRIVATE);
        wo = geq.getString("ge_qian","");
        wode.setText(wo);
        mFragments=new Fragment[3];
        fragmentManager=getSupportFragmentManager();
        mFragments[0]=fragmentManager.findFragmentById(R.id.fragment_shouye);
        mFragments[1]=fragmentManager.findFragmentById(R.id.fragment_faxian);
        mFragments[2]=fragmentManager.findFragmentById(R.id.fragment_wode);
        fragmentTransaction=fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
        fragmentTransaction.show(mFragments[0]).commit();

        radioGroup=(RadioGroup)findViewById(R.id.bottomGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group,int checkedID){
                Log.i("radioGroup","checkedID="+checkedID);
                fragmentTransaction=fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
                switch(checkedID){
                    case R.id.btn_Shouye:
                        fragmentTransaction.show(mFragments[0]).commit();
                        break;
                    case R.id.btn_Faxian:
                        fragmentTransaction.show(mFragments[1]).commit();
                        break;
                    case R.id.btn_Wode:
                        fragmentTransaction.show(mFragments[2]).commit();
                        break;
                    default:
                        break;
                }
            }
        } );

        /*
        Bundle b=getIntent().getExtras();
         wo=b.getString("user-name");
         wode.setText(wo+"\n"+"Welcome to the NewLife!");*/
           }
    public void openTv(View v) {
        Intent intent;
        intent = new Intent(this,TvActivity.class);
        startActivity(intent);
    }
    public void openAccount(View v) {
        Intent Ac;
        Ac = new Intent(this,LoginActivity.class);
        startActivity(Ac);
    }
    public void openQue(View v) {
        Intent intent;
        intent = new Intent(this,QueActivity.class);
        startActivity(intent);
    }
    public void openPass(View v) {
        Intent ge;
        ge = new Intent(this,PasswordActivity.class);
        startActivity(ge);
    }
    public void openGeqian(View v) {
        Intent ge;
        ge = new Intent(this,GeQianActivity.class);
        startActivity(ge);
    }
    public void openMusic(View v) {
        Intent intent= new Intent();
        intent.setData(Uri.parse("https://music.163.com/"));
        intent.setAction(Intent.ACTION_VIEW);
        this.startActivity(intent);
    }
    public void openZongyi(View v) {
        Intent intent= new Intent();
        intent.setData(Uri.parse("https://v.qq.com/channel/variety"));
        intent.setAction(Intent.ACTION_VIEW);
        this.startActivity(intent);
    }
    public void openMovie(View v) {
        Intent intent= new Intent();
        intent.setData(Uri.parse("https://v.qq.com/channel/movie"));
        intent.setAction(Intent.ACTION_VIEW);
        this.startActivity(intent);
    }
    public void openYuedu(View v) {
        Intent intent= new Intent();
        intent.setData(Uri.parse("http://www.jjwxc.net/channeltopten.php?channelid=2&str=1"));
        intent.setAction(Intent.ACTION_VIEW);
        this.startActivity(intent);
    }

}
