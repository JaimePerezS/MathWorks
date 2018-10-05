package com.example.jaime.tfg.data.interactor.teacher.classroom.student.progress.problemsGroup;

import com.example.jaime.tfg.data.model.ProblemsGroupRecord;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup.ShowProblemsGroupRecordTeacherPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowProblemsGroupRecordTeacherInteractorImp {
    private ShowProblemsGroupRecordTeacherPresenter presenter;
    private ApiService apiService;

    public ShowProblemsGroupRecordTeacherInteractorImp(ShowProblemsGroupRecordTeacherPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getOperationsGroupRecord(String idTeacher, String idClassroom, String idStudent, String token) {

        apiService.getProblemsGroupRecordByStudentId(idTeacher, idClassroom, idStudent, token).enqueue(new Callback<List<ProblemsGroupRecord>>() {
            @Override
            public void onResponse(Call<List<ProblemsGroupRecord>> call, Response<List<ProblemsGroupRecord>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetProblemsGroupRecord(response.body());
                } else {
                    try {
                        presenter.onFailureGetProblemsGroupRecord(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ProblemsGroupRecord>> call, Throwable t) {
                presenter.onFailureGetProblemsGroupRecord("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
