package com.androidwind.mvvm.sample.type1;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.androidwind.mvvm.sample.BaseRepository;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class Type1Repository extends BaseRepository {

    protected MutableLiveData<Boolean> mLiveData1;
    protected MutableLiveData<String> mLiveData2;

    public LiveData<Boolean> getLiveData1() {
        if (mLiveData1 == null) {
            mLiveData1 =  new MutableLiveData<>();
        }
        return mLiveData1;
    }

    public LiveData<String> getLiveData2() {
        if (mLiveData2 == null) {
            mLiveData2 =  new MutableLiveData<>();
        }
        return mLiveData2;
    }

    public void getData1() {

        Observable.create((ObservableOnSubscribe<Boolean>) emitter -> {
            try {
                Thread.sleep(2000); // 假设此处是耗时操作
            } catch (Exception e) {
                e.printStackTrace();
                emitter.onError(new RuntimeException());
            }
            emitter.onNext(true);
        }
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
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

    public void getData2() {

        Observable.create((ObservableOnSubscribe<String>) emitter -> {
                    try {
                        Thread.sleep(2000); // 假设此处是耗时操作
                    } catch (Exception e) {
                        e.printStackTrace();
                        emitter.onError(new RuntimeException());
                    }
                    emitter.onNext("Tom");
                }
        )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
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
