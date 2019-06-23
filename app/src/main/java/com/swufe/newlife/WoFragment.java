package com.swufe.newlife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WoFragment extends Fragment {
    TextView wode;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frame_wode,container);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    public void openQue(View v) {
        Intent intent;
        intent = new Intent(getActivity(),QueActivity.class);
        startActivity(intent);
    }
    public void openAccount(View v) {
        Intent intent;
        intent = new Intent(getActivity(),LoginActivity.class);
        startActivity(intent);
    }
    public void openGeqian(View v) {
        Intent intent;
        intent = new Intent(getActivity(),GeQianActivity.class);
        startActivity(intent);
    }
}
