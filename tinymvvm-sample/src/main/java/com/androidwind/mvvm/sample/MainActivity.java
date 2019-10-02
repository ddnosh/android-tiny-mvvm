package com.androidwind.mvvm.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.androidwind.mvvm.sample.type1.Type1Activity;
import com.androidwind.mvvm.sample.type2.Type2Activity;
import com.androidwind.mvvm.sample.type3.Type3Activity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickType1(View view) {
        startActivity(new Intent(this, Type1Activity.class));
    }

    public void clickType2(View view) {
        startActivity(new Intent(this, Type2Activity.class));
    }

    public void clickType3(View view) {
        startActivity(new Intent(this, Type3Activity.class));
    }
}
