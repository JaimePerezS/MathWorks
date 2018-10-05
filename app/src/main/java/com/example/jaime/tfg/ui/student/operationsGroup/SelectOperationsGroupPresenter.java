package com.example.jaime.tfg.ui.student.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsGroup;

import java.util.List;

/**
 * Created by Jaime on 12/01/2018.
 */

public interface SelectOperationsGroupPresenter {
    void getOperationsGroups(String idStudent, String token);

    void onSuccessGetOperationsGroups(List<OperationsGroup> operationsGroupList);
    void onFailureGetOperationsGroups(String message);
}
