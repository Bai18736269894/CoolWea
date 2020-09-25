package com.example.coolweather;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.coolweather.fragment.BlankFragment;


public class MainActivity extends FragmentActivity {
    FrameLayout choose;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    BlankFragment blankFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        blankFragment=new BlankFragment();
        fragmentTransaction.add(R.id.choose,blankFragment);
        fragmentTransaction.commit();

    }

}