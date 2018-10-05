package com.example.jaime.tfg.data.interactor.teacher.problemsgroup.edit;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.UpdateProblemsGroupRequestBody;
import com.example.jaime.tfg.ui.teacher.problemsgroup.edit.EditProblemsGroupPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProblemsGroupInteractorImp {
    private EditProblemsGroupPresenter presenter;
    private ApiService apiService;

    public EditProblemsGroupInteractorImp(EditProblemsGroupPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void updateProblem(String newName, String newDifficulty, String idTeacher, String idProblemsGroup, String token) {
        final UpdateProblemsGroupRequestBody requestBody = new UpdateProblemsGroupRequestBody(newName, newDifficulty);

        apiService.updateProblemsGroup(requestBody, idTeacher, idProblemsGroup, token).enqueue(new Callback<String>() {
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
