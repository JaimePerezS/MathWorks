package com.example.jaime.tfg.data.interactor.teacher.classroom.insert;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertClassroomRequestBody;
import com.example.jaime.tfg.ui.teacher.classroom.insert.InsertClassroomPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertClassroomInteractorImp {
    private InsertClassroomPresenter presenter;
    private ApiService apiService;

    public InsertClassroomInteractorImp(InsertClassroomPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void insertClassroom(String name, String idTeacher, String idUuid) {
        final InsertClassroomRequestBody requestBody = new InsertClassroomRequestBody(name);

        apiService.insertClassroom(requestBody, idTeacher, idUuid).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    presenter.onSuccessInsertClassroom(response.body());
                }
                else {
                    presenter.onFailureInsertClassroom(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureInsertClassroom("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
