package com.example.jaime.tfg.data.interactor.teacher.problemsgroup.problem.edit;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.UpdateProblemRequestBody;
import com.example.jaime.tfg.ui.teacher.problemsgroup.problem.edit.EditProblemPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProblemInteractorImp {
    private EditProblemPresenter presenter;
    private ApiService apiService;

    public EditProblemInteractorImp(EditProblemPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void updateProblem(String newStatement, String newOperation, int newPoints, String newHelp, String newOperationType, String idTeacher, String idProblemsGroup, String idProblem, String token) {

        final UpdateProblemRequestBody requestBody = new UpdateProblemRequestBody(newStatement, newOperation, newPoints, newHelp, newOperationType);

        apiService.updateProblem(requestBody, idTeacher, idProblemsGroup, idProblem, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessUpdateProblem(response.body());
                }
                else {
                    presenter.onFailureUpdateProblem(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureUpdateProblem("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
