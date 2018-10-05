package com.example.jaime.tfg.data.interactor.student.problemsGroup.resolveProblems;

import com.example.jaime.tfg.data.model.Problem;
import com.example.jaime.tfg.data.model.ProblemsRecord;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertProblemsGroupRecordRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertProblemsRecordRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateStudentPointsRequestBody;
import com.example.jaime.tfg.data.remote.response.InsertProblemsGroupRecordResponse;
import com.example.jaime.tfg.ui.student.problemsGroup.resolveProblems.ResolveProblemsPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResolveProblemsInteractorImp {
    private ResolveProblemsPresenter presenter;
    private ApiService apiService;

    public ResolveProblemsInteractorImp(ResolveProblemsPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getProblems(String idStudent, String idProblemsGroup, String token) {
        apiService.getProblemsStudent(idStudent, idProblemsGroup, token).enqueue(new Callback<List<Problem>>() {
            @Override
            public void onResponse(Call<List<Problem>> call, Response<List<Problem>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetProblems(response.body());
                } else {
                    try {
                        presenter.onFailureGetProblems(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Problem>> call, Throwable t) {
                presenter.onFailureGetProblems("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void updatePoints(String idStudent, int points, String token) {
        UpdateStudentPointsRequestBody requestBody = new UpdateStudentPointsRequestBody(idStudent, points);

        apiService.updatePoints(idStudent, requestBody, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(!response.isSuccessful()) {
                    presenter.onFailureUpdatePoints(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureUpdatePoints("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void insertProblemsGroupRecord(String date, int points, final List<ProblemsRecord> problemsRecordList, final String student, final String idProblemsGroup, final String token) {
        final InsertProblemsGroupRecordRequestBody requestBody = new InsertProblemsGroupRecordRequestBody(idProblemsGroup, date, points);

        apiService.insertProblemsGroupRecord(student,idProblemsGroup, requestBody, token).enqueue(new Callback<InsertProblemsGroupRecordResponse>() {
            @Override
            public void onResponse(Call<InsertProblemsGroupRecordResponse> call, Response<InsertProblemsGroupRecordResponse> response) {
                if(response.isSuccessful()) {
                    for (int i = 0; i < problemsRecordList.size(); i++) {
                        final InsertProblemsRecordRequestBody requestBody = new InsertProblemsRecordRequestBody(problemsRecordList.get(i).getMistakesIdent(),problemsRecordList.get(i).getMistakesOper(), problemsRecordList.get(i).getPointsObtained(), problemsRecordList.get(i).getIdOperation());

                        apiService.insertProblemsRecord(student, idProblemsGroup, response.body().getIdRecord(), requestBody, token).enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {

                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
                    }
                    presenter.onSuccessInsertProblemsGroupRecord("Progresos guardados correctamente");
                } else {
                    try {
                        presenter.onFailureInsertProblemsGroupRecord(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<InsertProblemsGroupRecordResponse> call, Throwable t) {
                presenter.onFailureInsertProblemsGroupRecord("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
