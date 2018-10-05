package com.example.jaime.tfg.data.interactor.teacher.classroom.student.edit;

import com.example.jaime.tfg.data.remote.ApiService;
import com.example.jaime.tfg.data.remote.ApiUtils;
import com.example.jaime.tfg.data.remote.request.UpdateStudentRequestBody;
import com.example.jaime.tfg.ui.teacher.classroom.student.edit.EditStudentPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditStudentInteractorImp {
    private EditStudentPresenter presenter;
    private ApiService apiService;

    public EditStudentInteractorImp(EditStudentPresenter presenter) {
        this.presenter = presenter;
        this.apiService = ApiUtils.getAPIService();
    }

    public void updateStudent(String name, String surname, String idTeacher, String idClassroom, String idStudent, String token) {
        final UpdateStudentRequestBody requestBody = new UpdateStudentRequestBody(name, surname);

        apiService.updateStudent(requestBody, idTeacher, idClassroom, idStudent, token).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    presenter.onSuccessEditStudent(response.body());
                }
                else {
                    presenter.onFailureEditStudent(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                presenter.onFailureEditStudent("Error al conectar al servidor, intentalo mas tarde");
            }
        });
    }
}
