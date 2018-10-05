package com.example.jaime.tfg.data.interactor.teacher.profile.edit;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.UpdateTeacherRequestBody;
import com.example.jaime.tfg.ui.teacher.profile.edit.EditTeacherProfilePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditTeacherProfileInteractorImp {
    private EditTeacherProfilePresenter presenter;
    private ApiService apiService;

    public EditTeacherProfileInteractorImp(EditTeacherProfilePresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void updateTeacher(String newName, String newSurname, String idTeacher, String token) {
        final UpdateTeacherRequestBody requestBody = new UpdateTeacherRequestBody(newName, newSurname);

        apiService.updateTeacher(requestBody, idTeacher, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    presenter.onSuccessUpdateTeacher(response.body());
                } else {
                    presenter.onFailureUpdateTeacher(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureUpdateTeacher("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
