package com.androidwind.mvvm.sample.type2;

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
public class Type2Repository extends BaseRepository {

    public Observable<Boolean> getData1() {

        return Observable.create((ObservableOnSubscribe<Boolean>) emitter -> {
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
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<String> getData2() {

        return Observable.create((ObservableOnSubscribe<String>) emitter -> {
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
                .observeOn(AndroidSchedulers.mainThread());
    }
}
