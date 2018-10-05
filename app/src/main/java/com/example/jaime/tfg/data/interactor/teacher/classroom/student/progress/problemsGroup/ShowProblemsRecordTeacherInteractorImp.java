package com.example.jaime.tfg.data.interactor.teacher.classroom.student.progress.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsRecord;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup.ShowProblemsRecordTeacherPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowProblemsRecordTeacherInteractorImp {
    private ShowProblemsRecordTeacherPresenter presenter;
    private ApiService apiService;

    public ShowProblemsRecordTeacherInteractorImp(ShowProblemsRecordTeacherPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getProblemsRecord(String idTeacher, String idClassroom, String idStudent, String idProblemsGroup, String idRecord, String token) {

        apiService.getProblemsRecordByStudentId(idTeacher, idClassroom, idStudent, idProblemsGroup, idRecord, token).enqueue(new Callback<List<ProblemsRecord>>() {
            @Override
            public void onResponse(Call<List<ProblemsRecord>> call, Response<List<ProblemsRecord>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetProblemsRecord(response.body());
                } else {
                    try {
                        presenter.onFailureGetProblemsRecord(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ProblemsRecord>> call, Throwable t) {
                presenter.onFailureGetProblemsRecord("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
