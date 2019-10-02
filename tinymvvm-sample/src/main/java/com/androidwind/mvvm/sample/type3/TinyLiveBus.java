package com.androidwind.mvvm.sample.type3;

import android.arch.lifecycle.MutableLiveData;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class TinyLiveBus {

    private ConcurrentHashMap<String, MutableLiveData<Object>> liveDatas = new ConcurrentHashMap<>();

    private static volatile TinyLiveBus sTinyBus;

    public static TinyLiveBus getInstance() {
        if (sTinyBus == null) {
            return sTinyBus = new TinyLiveBus();
        }
        return sTinyBus;
    }

    public <T> MutableLiveData<T> register(String key, Class<T> clazz) {
        if (!liveDatas.containsKey(key)) {
            liveDatas.put(key, new MutableLiveData<>());
        }
        return (MutableLiveData<T>) liveDatas.get(key);
    }

    public <T> void post(String key, T value) {
        if (liveDatas.containsKey(key)) {
            MutableLiveData liveData = liveDatas.get(key);
            liveData.postValue(value);
        }
    }
}
