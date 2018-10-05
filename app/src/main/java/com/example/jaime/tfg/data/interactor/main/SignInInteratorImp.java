package com.example.jaime.tfg.data.interactor.main;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertTeacherRequestBody;
import com.example.jaime.tfg.ui.main.fragment.SignInPresenter;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInInteratorImp {
    private SignInPresenter presenter;
    private ApiService apiService;

    public SignInInteratorImp(SignInPresenter presenter) {
        this.presenter = presenter;
        apiService = ApiUtils.getAPIService();
    }

    public void insertTeacher(String name, String surname, String email, String password) {
        final InsertTeacherRequestBody requestBody = new InsertTeacherRequestBody(name, surname, email, password);

        apiService.newTeacher(requestBody).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessSignIn(response.body().toString());
                } else {
                    try {
                        presenter.onFailureSignIn(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureSignIn("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
