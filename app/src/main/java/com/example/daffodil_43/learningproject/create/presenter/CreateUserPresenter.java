package com.example.daffodil_43.learningproject.create.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.daffodil_43.learningproject.create.manager.CreateUserManager;
import com.example.daffodil_43.learningproject.create.model.CreateUserRequest;
import com.example.daffodil_43.learningproject.create.model.CreateUserResponse;
import com.example.daffodil_43.learningproject.create.view.ICreateUserView;

public class CreateUserPresenter implements ICreateUserPresenter,ICreateUserResponseReceiver {

    CreateUserManager manager;
    ICreateUserView createUserView;
    Context context;

    public CreateUserPresenter(CreateUserManager manager, ICreateUserView createUserView, Context context) {
        this.manager = manager;
        this.createUserView = createUserView;
        this.context = context;
    }

    @Override
    public void createUser(String name, String job) {

        if(name!=null&&!name.isEmpty() && job!=null&&!job.isEmpty())
        {
            CreateUserRequest request=new CreateUserRequest();
            request.setName(name);
            request.setJob(job);
            manager.createUser(request,this);
        }

    }

    @Override
    public void onSuccess(@NonNull CreateUserResponse data) {
        createUserView.onSuccessFulCreation(data);

    }

    @Override
    public void onFailure(@NonNull String error) {
        createUserView.onError(error);
    }
}
