package com.example.jaime.tfg.data.interactor.teacher.classroom.student.progress.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsRecord;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup.ShowOperationsRecordTeacherPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowOperationsRecordTeacherInteractorImp {
    private ShowOperationsRecordTeacherPresenter presenter;
    private ApiService apiService;

    public ShowOperationsRecordTeacherInteractorImp(ShowOperationsRecordTeacherPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getOperationsRecord(String idTeacher, String idClassroom, String idStudent, String idOperationsGroup, String idRecord, String token) {
        apiService.getOperationsRecordByStudentId(idTeacher, idClassroom, idStudent, idOperationsGroup, idRecord, token).enqueue(new Callback<List<OperationsRecord>>() {
            @Override
            public void onResponse(Call<List<OperationsRecord>> call, Response<List<OperationsRecord>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetOperationsRecord(response.body());
                } else {
                    try {
                        presenter.onFailureGetOperationsRecord(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<OperationsRecord>> call, Throwable t) {
                presenter.onFailureGetOperationsRecord("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
