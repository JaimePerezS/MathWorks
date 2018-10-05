package com.example.jaime.tfg.data.interactor.student.shop;

import com.example.jaime.tfg.data.model.Avatar;
import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.InsertAvatarBougthRequestBody;
import com.example.jaime.tfg.data.remote.request.UpdateStudentPointsRequestBody;
import com.example.jaime.tfg.ui.student.shop.AvatarShopPresenter;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvatarShopInteractorImp {
    private AvatarShopPresenter presenter;
    private ApiService apiService;

    public AvatarShopInteractorImp(AvatarShopPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void getAvatar(String idStudent, String token) {

        apiService.getAvatarToBuy(idStudent, token).enqueue(new Callback<List<Avatar>>() {
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

    public void buyAvatar(final Student student, final Avatar avatar, final String token) {
        if(student.getPoints() >= avatar.getCost()) {

            InsertAvatarBougthRequestBody bougthRequestBody = new InsertAvatarBougthRequestBody(String.valueOf(student.getId()), String.valueOf(avatar.getIdAvatar()));

            apiService.insertAvatarBougth(bougthRequestBody, String.valueOf(student.getId()), token).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.isSuccessful()) {
                        final int newPoints = student.getPoints() - avatar.getCost();

                        UpdateStudentPointsRequestBody requestBody = new UpdateStudentPointsRequestBody(String.valueOf(student.getId()), newPoints);

                        apiService.updatePoints(String.valueOf(student.getId()), requestBody, token).enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                if(response.isSuccessful()) {
                                    presenter.onSuccessBuyAvatar(newPoints, response.body());
                                }
                                else {
                                    try {
                                        presenter.onFailureBuyAvatar(response.errorBody().string().toString());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                presenter.onFailureBuyAvatar("Error al conectar al servidor, intentalo mas tarde");
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    presenter.onFailureBuyAvatar("Error al conectar al servidor, intentalo mas tarde");
                }
            });

        }
        else {
            presenter.onFailureBuyAvatar("No tienes suficientes puntos para comprar el avatar");
        }
    }
}
