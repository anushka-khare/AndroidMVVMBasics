package com.example.daffodil_43.learningproject.create.presenter;

import android.support.annotation.NonNull;

import com.example.daffodil_43.learningproject.create.model.CreateUserResponse;

public interface ICreateUserResponseReceiver {


    void onSuccess(@NonNull CreateUserResponse data);

    void onFailure(@NonNull String error);
}
