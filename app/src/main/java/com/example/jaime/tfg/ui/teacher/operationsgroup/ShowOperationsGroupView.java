package com.example.jaime.tfg.ui.teacher.operationsgroup;

import com.example.jaime.tfg.data.model.OperationsGroup;

import java.util.List;

/**
 * Created by Jaime on 06/12/2017.
 */

public interface ShowOperationsGroupView {
    void showOperationsGroup(List<OperationsGroup> operationsGroup);

    void showSuccessToast(String message);
    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();

    void clearRecycler();
}
