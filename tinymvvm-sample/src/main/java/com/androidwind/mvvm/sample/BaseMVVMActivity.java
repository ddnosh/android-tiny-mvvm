package com.androidwind.mvvm.sample;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public abstract class BaseMVVMActivity<T extends BaseViewModel> extends AppCompatActivity {

    protected T mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        if (mViewModel == null) {
            mViewModel = ViewModelProviders.of(this).get(getTClass());
        }

        init();
    }

    public Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected abstract int getContentView();

    protected abstract void init();
}
