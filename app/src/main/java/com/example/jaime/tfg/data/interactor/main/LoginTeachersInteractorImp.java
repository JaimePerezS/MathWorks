package com.example.jaime.tfg.data.interactor.main;

import android.content.Context;

import com.example.jaime.tfg.data.local.TeacherSessionManager;
import com.example.jaime.tfg.data.model.Teacher;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.LoginTeacherRequestBody;
import com.example.jaime.tfg.ui.main.fragment.LoginTeachersPresenter;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginTeachersInteractorImp {
    private LoginTeachersPresenter presenter;
    private ApiService apiService;

    public LoginTeachersInteractorImp(LoginTeachersPresenter presenter) {
        this.presenter = presenter;
        apiService = ApiUtils.getAPIService();
    }

    public void loginTeacher(String email, String password) {
        final LoginTeacherRequestBody requestBody = new LoginTeacherRequestBody(email, password);

        apiService.teacherLogin(requestBody).enqueue(new Callback<Teacher>() {
            @Override
            public void onResponse(Call<Teacher> call, Response<Teacher> response) {
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
            public void onFailure(Call<Teacher> call, Throwable t) {
                presenter.onFailureLogin("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void createTeacherSession(Teacher teacher, Context context) {
        TeacherSessionManager session = new TeacherSessionManager(context);
        session.login(teacher);
    }
}
