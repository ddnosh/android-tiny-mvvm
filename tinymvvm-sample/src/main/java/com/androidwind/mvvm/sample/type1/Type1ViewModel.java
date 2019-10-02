package com.androidwind.mvvm.sample.type1;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.androidwind.mvvm.sample.BaseViewModel;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class Type1ViewModel extends BaseViewModel<Type1Repository> {

    public Type1ViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getLiveData1() {
        return repository.getLiveData1();
    }

    public LiveData<String> getLiveData2() {
        return repository.getLiveData2();
    }

    public void loadData1() {
        repository.getData1();
    }

    public void loadData2() {
        repository.getData2();
    }
}
