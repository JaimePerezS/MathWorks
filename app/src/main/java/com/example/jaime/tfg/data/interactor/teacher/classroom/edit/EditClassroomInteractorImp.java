package com.example.jaime.tfg.data.interactor.teacher.classroom.edit;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.UpdateClassroomRequestBody;
import com.example.jaime.tfg.ui.teacher.classroom.edit.EditClassroomPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditClassroomInteractorImp {
    private EditClassroomPresenter presenter;
    private ApiService apiService;

    public EditClassroomInteractorImp(EditClassroomPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void updateClassroom(String newName, String idTeacher, String idClassroom, String idUuid) {
        final UpdateClassroomRequestBody requestBody = new UpdateClassroomRequestBody(newName);

        apiService.updateClassroom(requestBody, idTeacher, idClassroom, idUuid).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onUpdateClassroomSuccess(response.body());
                }
                else {
                    presenter.onUpdateClassroomFailure(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onUpdateClassroomFailure("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
