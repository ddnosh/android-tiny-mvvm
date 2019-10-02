package com.androidwind.mvvm.sample.type3;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.androidwind.mvvm.sample.BaseViewModel;
import com.androidwind.mvvm.sample.type1.Type1Repository;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class Type3ViewModel extends BaseViewModel<Type3Repository> {

    public Type3ViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadData1() {
        repository.getData1();
    }

    public void loadData2() {
        repository.getData2();
    }
}
