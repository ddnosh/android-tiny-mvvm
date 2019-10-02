package com.androidwind.mvvm.sample.type1;

import android.view.View;
import android.widget.Button;

import com.androidwind.mvvm.sample.BaseMVVMActivity;
import com.androidwind.mvvm.sample.R;

public class Type1Activity extends BaseMVVMActivity<Type1ViewModel> {

    @Override
    protected int getContentView() {
        return R.layout.activity_type;
    }

    @Override
    protected void init() {
        Button btn = findViewById(R.id.button);
        mViewModel.getLiveData1().observe(this, bool -> {
            btn.setText(bool ? "success" : "fail");
        });
        Button btn2 = findViewById(R.id.button2);
        mViewModel.getLiveData2().observe(this, string -> {
            btn2.setText(string);
        });
    }

    public void clickMe(View view) {
        mViewModel.loadData1();
    }

    public void clickOther(View view) {
        mViewModel.loadData2();
    }

    public void clickType3(View view) {
    }
}
