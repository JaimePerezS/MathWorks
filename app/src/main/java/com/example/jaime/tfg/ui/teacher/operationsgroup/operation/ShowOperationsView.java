package com.example.jaime.tfg.ui.teacher.operationsgroup.operation;

import com.example.jaime.tfg.data.model.Operation;

import java.util.List;

/**
 * Created by Jaime on 06/12/2017.
 */

public interface ShowOperationsView {
    void showOperations(List<Operation> operations);

    void showSuccessToast(String message);
    void showErrorToast(String message);

    void showProgress(String title, String message);
    void hideProgress();

    void clearRecycler();
}
