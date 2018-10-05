package com.example.jaime.tfg.data.interactor.teacher.classroom;

import com.example.jaime.tfg.data.model.Classroom;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.classroom.ShowClassroomPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowClassroomInteractorImp {
    private ShowClassroomPresenter presenter;
    private ApiService apiService;

    public ShowClassroomInteractorImp(ShowClassroomPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getClassrooms(String idTeacher, String token) {
        apiService.getClassrooms(idTeacher, token).enqueue(new Callback<List<Classroom>>() {
            @Override
            public void onResponse(Call<List<Classroom>> call, Response<List<Classroom>> response) {
                if(response.isSuccessful()){
                    presenter.onSuccessGetClassrooms(response.body());
                }
                else {
                    try {
                        presenter.onFailureGetClassrooms(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Classroom>> call, Throwable t) {
                presenter.onFailureGetClassrooms("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void deleteClassroom(String idTeacher, String idClassroom, String token) {
        apiService.deleteClassroom(idTeacher, idClassroom, token).enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    presenter.onSuccessDeleteClassroom(response.body());
                }
                else {
                    try {
                        presenter.onFailureDeleteClassroom(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureDeleteClassroom("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
