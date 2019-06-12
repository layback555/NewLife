package com.swufe.newlife;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FrameActicity extends FragmentActivity {
    private Fragment mFragments[];
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton rbtShou,rbtGuan,rbtFa,rbtWo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_frame);
        mFragments=new Fragment[4];
        fragmentManager=getSupportFragmentManager();
        mFragments[0]=fragmentManager.findFragmentById(R.id.fragment_shouye);
        mFragments[1]=fragmentManager.findFragmentById(R.id.fragment_guanzhu);
        mFragments[2]=fragmentManager.findFragmentById(R.id.fragment_faxian);
        mFragments[3]=fragmentManager.findFragmentById(R.id.fragment_wode);
        fragmentTransaction=fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]);
        fragmentTransaction.show(mFragments[0]).commit();

        radioGroup=(RadioGroup)findViewById(R.id.bottomGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group,int checkedID){
                Log.i("radioGroup","checkedID="+checkedID);
                fragmentTransaction=fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]);
                switch(checkedID){
                    case R.id.btn_Shouye:
                        fragmentTransaction.show(mFragments[0]).commit();
                        break;
                    case R.id.btn_Guanzhu:
                        fragmentTransaction.show(mFragments[1]).commit();
                        break;
                    case R.id.btn_Faxian:
                        fragmentTransaction.show(mFragments[2]).commit();
                        break;
                    case R.id.btn_Wode:
                        fragmentTransaction.show(mFragments[3]).commit();
                        break;
                    default:
                        break;
                }
            }
        } );
    }
}
