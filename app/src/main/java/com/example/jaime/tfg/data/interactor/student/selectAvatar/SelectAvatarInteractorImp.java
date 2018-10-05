package com.example.jaime.tfg.data.interactor.student.selectAvatar;

import com.example.jaime.tfg.data.model.Avatar;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.UpdateStudentAvatarRequestBody;
import com.example.jaime.tfg.ui.student.selectAvatar.SelectAvatarPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectAvatarInteractorImp {
    private SelectAvatarPresenter presenter;
    private ApiService apiService;

    public SelectAvatarInteractorImp(SelectAvatarPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getAvatar(String idStudent, String token) {

        apiService.getAvatarBougth(idStudent, token).enqueue(new Callback<List<Avatar>>() {
            @Override
            public void onResponse(Call<List<Avatar>> call, Response<List<Avatar>> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessGetAvatar(response.body());
                } else {
                    try {
                        presenter.onFailureGetAvatar(response.errorBody().string().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Avatar>> call, Throwable t) {
                presenter.onFailureGetAvatar("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }

    public void updateAvatar(String idStudent, String idAvatar, String token) {

        UpdateStudentAvatarRequestBody requestBody = new UpdateStudentAvatarRequestBody(idAvatar);

        apiService.updateAvatar(requestBody, idAvatar, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessUpdateAvatar(response.body());
                } else {
                    presenter.onFailureUpdateAvatar(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureUpdateAvatar("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
