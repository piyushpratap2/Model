package com.example.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.net.URL;

public class MyViewModel extends ViewModel implements Observable {
    private MutableLiveData<String> currentdata;
    private PropertyChangeRegistry listener = new PropertyChangeRegistry();

    @Bindable
    public MutableLiveData<String> getCurrentdata() {
        if(currentdata == null){
            currentdata = new MutableLiveData<String>();
        }
        return currentdata;
    }

    public void setCurrentdata(MutableLiveData<String> currentdata) {
        this.currentdata = currentdata;
        listener.notifyChange(this,BR.currentdata);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        listener.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        listener.remove(callback);
    }
}
