package com.example.jaime.tfg.data.interactor.student.firstAvatarSelecion;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertAvatarBougthRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateStudentAvatarRequestBody;
import com.example.jaime.tfg.ui.student.firstAvatarSelection.FirstSelectAvatarPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstSelectAvatarInteractorImp {

    private FirstSelectAvatarPresenter presenter;
    private ApiService apiService;

    public FirstSelectAvatarInteractorImp(FirstSelectAvatarPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void updateAvatar(String idAvatar, String idStudent, String token) {

        UpdateStudentAvatarRequestBody requestBody = new UpdateStudentAvatarRequestBody(idAvatar);

        apiService.updateAvatar(requestBody, idStudent, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()) {
                    presenter.onSuccessUpdateAvatar(response.body());
                }
                else {
                    presenter.onFailureUpdateAvatar(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureUpdateAvatar("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void buyAvatar(String idStudent, String idAvatar, String token) {
        InsertAvatarBougthRequestBody bougthRequestBody = new InsertAvatarBougthRequestBody(idStudent, idAvatar);

        apiService.insertAvatarBougth(bougthRequestBody, idStudent, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    presenter.onSuccessBuyAvatar(response.body());
                } else {
                    presenter.onFailureBuyAvatar(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureBuyAvatar("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
