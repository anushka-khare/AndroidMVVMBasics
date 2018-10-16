package com.example.daffodil_43.learningproject.create.manager;

import android.support.annotation.NonNull;

import api.ResponseCallBack;
import api.ResponseWrapper;
import api.RetrofitClient;
import retrofit2.Call;
import com.example.daffodil_43.learningproject.create.model.CreateUserRequest;
import com.example.daffodil_43.learningproject.create.model.CreateUserResponse;
import com.example.daffodil_43.learningproject.create.presenter.ICreateUserResponseReceiver;

public class CreateUserManager implements ResponseCallBack<CreateUserResponse> {


    ICreateUserResponseReceiver responseReceiver;
    private Call<CreateUserResponse> responseCall;

    public void createUser(CreateUserRequest request,ICreateUserResponseReceiver responseReceiver)
    {
        this.responseReceiver=responseReceiver;
        responseCall=RetrofitClient.getApiService().createUser(request);
        responseCall.enqueue(new ResponseWrapper(this));
    }



    @Override
    public void onSuccess(@NonNull CreateUserResponse data) {
        responseReceiver.onSuccess( data);

    }

    @Override
    public void onFailure(@NonNull String error) {
        responseReceiver.onFailure( error);

    }
}
