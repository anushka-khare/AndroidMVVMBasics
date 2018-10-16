package com.example.daffodil_43.learningproject.create.view;

import com.example.daffodil_43.learningproject.create.model.CreateUserResponse;

public interface ICreateUserView {


    void onSuccessFulCreation(CreateUserResponse data);

    void onError(String msg);
}
