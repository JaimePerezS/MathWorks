package com.example.jaime.tfg.data.interactor.main;

import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.LoginStudentRequestBody;
import com.example.jaime.tfg.ui.main.fragment.LoginStudentsPresenter;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginStudentsInteractorImp {

    private LoginStudentsPresenter presenter;
    private ApiService apiService;

    public LoginStudentsInteractorImp(LoginStudentsPresenter presenter) {
        this.presenter = presenter;
    }

    public void loginStudent(String idStudent) {
        apiService = ApiUtils.getAPIService();

        final LoginStudentRequestBody requestBody = new LoginStudentRequestBody(idStudent);

        apiService.studentLogin(requestBody).enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessLogin(response.body());
                }
                else {
                    try {
                        presenter.onFailureLogin(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                presenter.onFailureLogin("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
