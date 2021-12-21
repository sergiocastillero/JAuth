package com.example.jauth.Fragments.Auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AuthViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AuthViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Auth fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}