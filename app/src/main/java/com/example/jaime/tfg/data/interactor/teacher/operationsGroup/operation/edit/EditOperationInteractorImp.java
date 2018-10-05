package com.example.jaime.tfg.data.interactor.teacher.operationsGroup.operation.edit;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.UpdateOperationRequestBody;
import com.example.jaime.tfg.ui.teacher.operationsgroup.operation.edit.EditOperationPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditOperationInteractorImp {
    private EditOperationPresenter presenter;
    private ApiService apiService;

    public EditOperationInteractorImp(EditOperationPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void updateOperation(String newStatement, int newPoins, String idTeacher, String idOperationsGroup, String idOperation, String token) {

        final UpdateOperationRequestBody requestBody = new UpdateOperationRequestBody(newStatement, newPoins);

        apiService.updateOperation(requestBody, idTeacher, idOperationsGroup, idOperation, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessUpdateOperation(response.body());
                }
                else {
                    presenter.onFailureUpdateOperation(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureUpdateOperation("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
