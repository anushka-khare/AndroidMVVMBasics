package com.example.daffodil_43.learningproject.create;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.daffodil_43.learningproject.R;
import com.example.daffodil_43.learningproject.create.manager.CreateUserManager;
import com.example.daffodil_43.learningproject.create.model.CreateUserResponse;
import com.example.daffodil_43.learningproject.create.presenter.CreateUserPresenter;
import com.example.daffodil_43.learningproject.create.presenter.ICreateUserPresenter;
import com.example.daffodil_43.learningproject.create.view.ICreateUserView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateUserActivity extends AppCompatActivity implements ICreateUserView {

    @BindView(R.id.edtName)
    EditText edtName;
    @BindView(R.id.edtJob)
    EditText edtJob;
    @BindView(R.id.progressBar)
     ProgressBar progressBar;

    private ICreateUserPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        ButterKnife.bind(this);
        presenter=new CreateUserPresenter(new CreateUserManager(),this,this);
    }


    @Override
    public void onSuccessFulCreation(CreateUserResponse data) {
        progressBar.setVisibility(View.GONE);

        Toast.makeText(this,data.getName()+" Id: "+data.getId()+" created",Toast.LENGTH_LONG).show();
        edtName.setText("");
        edtJob.setText("");

    }

    @Override
    public void onError(String msg) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();

    }

    @OnClick(R.id.btnSubmit)
    public void onClickSubmit()
    {
        progressBar.setVisibility(View.VISIBLE);
        presenter.createUser(edtName.getText().toString(),edtJob.getText().toString());
    }



}
