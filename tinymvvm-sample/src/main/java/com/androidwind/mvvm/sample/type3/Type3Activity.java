package com.androidwind.mvvm.sample.type3;

import android.arch.lifecycle.Observer;
import android.view.View;
import android.widget.Button;

import com.androidwind.mvvm.sample.BaseMVVMActivity;
import com.androidwind.mvvm.sample.R;

public class Type3Activity extends BaseMVVMActivity<Type3ViewModel> {

    @Override
    protected int getContentView() {
        return R.layout.activity_type;
    }

    @Override
    protected void init() {
        Button btn = findViewById(R.id.button);
        TinyLiveBus.getInstance()
                .register("one", Boolean.class)
                .observe(this, (Observer<Boolean>) bool -> btn.setText(bool ? "success" : "fail"));
        Button btn2 = findViewById(R.id.button2);
        TinyLiveBus.getInstance()
                .register("two", String.class)
                .observe(this, (Observer<String>) string -> btn2.setText(string));
    }

    public void clickMe(View view) {
        mViewModel.loadData1();
    }

    public void clickOther(View view) {
        mViewModel.loadData2();
    }
}
