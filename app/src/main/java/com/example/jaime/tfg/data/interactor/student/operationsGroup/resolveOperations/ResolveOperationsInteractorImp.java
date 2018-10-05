package com.example.jaime.tfg.data.interactor.student.operationsGroup.resolveOperations;

import com.example.jaime.tfg.data.model.Operation;
import com.example.jaime.tfg.data.model.OperationsRecord;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertOperationsGroupRecordRequestBody;
import com.example.jaime.tfg.data.remote.request.InsertOperationsRecordRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateStudentPointsRequestBody;
import com.example.jaime.tfg.data.remote.response.InsertOperationsGroupRecordResponse;
import com.example.jaime.tfg.ui.student.operationsGroup.resolveOperations.ResolveOperationsPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResolveOperationsInteractorImp {
    private ResolveOperationsPresenter presenter;
    private ApiService apiService;

    public ResolveOperationsInteractorImp(ResolveOperationsPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getOperations(String idStudent, String idOperationsGroup, String token) {

        apiService.getOperationsStudent(idStudent, idOperationsGroup, token).enqueue(new Callback<List<Operation>>() {
            @Override
            public void onResponse(Call<List<Operation>> call, Response<List<Operation>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetOperations(response.body());
                } else {
                    try {
                        presenter.onFailureGetOperations(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Operation>> call, Throwable t) {
                presenter.onFailureGetOperations("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void updatePoints(String idStudent, final int points, String token) {

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

    public void insertOperationsGroupRecord(String date, int points, final List<OperationsRecord> operationsRecordList, final String idStudent, final String idOperationsGroup, final String token) {

        final InsertOperationsGroupRecordRequestBody requestBody = new InsertOperationsGroupRecordRequestBody(idOperationsGroup, date, points);

        apiService.insertOperationsGroupRecord(idStudent, idOperationsGroup, requestBody, token).enqueue(new Callback<InsertOperationsGroupRecordResponse>() {
            @Override
            public void onResponse(Call<InsertOperationsGroupRecordResponse> call, Response<InsertOperationsGroupRecordResponse> response) {
                if(response.isSuccessful()) {
                    for(int i = 0; i < operationsRecordList.size(); i++) {
                        final InsertOperationsRecordRequestBody recordRequestBody = new InsertOperationsRecordRequestBody(operationsRecordList.get(i).getMistakes(), operationsRecordList.get(i).getPointsObtained(), operationsRecordList.get(i).getIdOperation());

                        apiService.insertOperationsRecord(idStudent, idOperationsGroup, response.body().getIdRecord(), recordRequestBody, token).enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {

                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
                    }

                    presenter.onSuccessInsertOperationsGroupRecord("Progresos guardados correctamente");
                } else {
                    try {
                        presenter.onFailureInsertOperationsGroupRecord(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<InsertOperationsGroupRecordResponse> call, Throwable t) {
                presenter.onSuccessInsertOperationsGroupRecord("Error al conectar al servidor, intentalo mas tarde");
            }
        });

    }
}
