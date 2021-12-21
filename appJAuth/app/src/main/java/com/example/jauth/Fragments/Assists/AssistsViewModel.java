package com.example.jauth.Fragments.Assists;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AssistsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AssistsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Assists fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}