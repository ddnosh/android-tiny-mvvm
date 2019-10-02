package com.androidwind.mvvm.sample.type2;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.androidwind.mvvm.sample.BaseViewModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class Type2ViewModel extends BaseViewModel<Type2Repository> {

    protected MutableLiveData<Boolean> mLiveData1;
    protected MutableLiveData<String> mLiveData2;

    public Type2ViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getLiveData1() {
        if (mLiveData1 == null) {
            mLiveData1 = new MutableLiveData<>();
        }
        return mLiveData1;
    }

    public LiveData<String> getLiveData2() {
        if (mLiveData2 == null) {
            mLiveData2 = new MutableLiveData<>();
        }
        return mLiveData2;
    }

    public void loadData1() {
        repository.getData1().subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Boolean orderValues) {
                mLiveData1.setValue(orderValues);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

    public void loadData2() {
        repository.getData2().subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String orderValues) {
                mLiveData2.setValue(orderValues);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }
}

