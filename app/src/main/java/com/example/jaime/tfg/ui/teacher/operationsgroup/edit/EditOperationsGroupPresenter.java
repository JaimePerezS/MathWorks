package com.example.jaime.tfg.ui.teacher.operationsgroup.edit;

/**
 * Created by Jaime on 04/12/2017.
 */

public interface EditOperationsGroupPresenter {
    void onClickUpdateOperationsGroup(String newName, String newDifficulty, String idTeacher, String idOperationsGroup, String token);

    void onSuccessUpdateOperationsGroup(String message);
    void onFailureUpdateOperationsGroup(String message);
}
