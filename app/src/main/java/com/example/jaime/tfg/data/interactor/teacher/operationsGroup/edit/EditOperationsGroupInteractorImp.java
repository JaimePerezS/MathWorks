package com.example.jaime.tfg.data.interactor.teacher.operationsGroup.edit;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.UpdateOperationsGroupRequestBody;
import com.example.jaime.tfg.ui.teacher.operationsgroup.edit.EditOperationsGroupPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditOperationsGroupInteractorImp {
    private EditOperationsGroupPresenter presenter;
    private ApiService apiService;

    public EditOperationsGroupInteractorImp(EditOperationsGroupPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void updateOperationsGroup(final String newName, final String newDifficulty, final String idTeacher, final String idOperationsGroup, final String token) {

        final UpdateOperationsGroupRequestBody requestBody = new UpdateOperationsGroupRequestBody(newName, newDifficulty);

        apiService.updateOperationsGroup(requestBody, idTeacher, idOperationsGroup, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessUpdateOperationsGroup(response.body());
                }
                else {
                    presenter.onFailureUpdateOperationsGroup(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureUpdateOperationsGroup("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
