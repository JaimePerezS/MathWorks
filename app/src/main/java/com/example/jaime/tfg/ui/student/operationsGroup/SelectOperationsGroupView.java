package com.example.jaime.tfg.ui.student.operationsGroup;

import com.example.jaime.tfg.data.model.OperationsGroup;

import java.util.List;

/**
 * Created by Jaime on 11/01/2018.
 */

public interface SelectOperationsGroupView {
    void showOperationsGroup(List<OperationsGroup> operationsGroupList);
    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();
}
