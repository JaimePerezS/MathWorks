package com.example.jaime.tfg.data.interactor.teacher.problemsgroup.availability;

import com.example.jaime.tfg.data.model.Classroom;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.problemsgroup.availability.SelectClassroomPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectClassroomInteractorImp {
    private SelectClassroomPresenter presenter;
    private ApiService apiService;

    public SelectClassroomInteractorImp(SelectClassroomPresenter presenter) {
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
}
