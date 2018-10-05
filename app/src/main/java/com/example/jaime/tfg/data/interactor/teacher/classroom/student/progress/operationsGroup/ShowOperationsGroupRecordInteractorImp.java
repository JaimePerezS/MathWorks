package com.example.jaime.tfg.data.interactor.teacher.classroom.student.progress.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsGroupRecord;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup.ShowOperationsGroupRecordPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowOperationsGroupRecordInteractorImp {
    private ShowOperationsGroupRecordPresenter presenter;
    private ApiService apiService;

    public ShowOperationsGroupRecordInteractorImp(ShowOperationsGroupRecordPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getOperationsGroupRecord(String idTeacher, String idClassroom, String idStudent, String token) {

        apiService.getOperationsGroupRecordByStudentId(idTeacher, idClassroom, idStudent, token).enqueue(new Callback<List<OperationsGroupRecord>>() {
            @Override
            public void onResponse(Call<List<OperationsGroupRecord>> call, Response<List<OperationsGroupRecord>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetOperationsGroupRecord(response.body());
                } else {
                    try {
                        presenter.onFailureGetOperationsGroupRecord(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<OperationsGroupRecord>> call, Throwable t) {
                presenter.onFailureGetOperationsGroupRecord("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
