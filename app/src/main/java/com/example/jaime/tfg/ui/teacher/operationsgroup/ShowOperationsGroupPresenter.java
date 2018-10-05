package com.example.jaime.tfg.ui.teacher.operationsgroup;

import com.example.jaime.tfg.data.model.OperationsGroup;

import java.util.List;

/**
 * Created by Jaime on 06/12/2017.
 */

public interface ShowOperationsGroupPresenter {
    void getOperationsGroup(String idTeacher, String token);
    void onSuccessGetOperationsGroup(List<OperationsGroup> operationsGroups);
    void onFailureGetOperationsGroup(String message);

    void onClickDeleteOperationsGroup(String idTeacher, String idOperationsGroup, String token);
    void onSuccessDeleteOperationsGroup(String message);
    void onFailureDeleteOperationsGroup(String message);
}
