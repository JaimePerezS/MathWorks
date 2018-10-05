package com.example.jaime.tfg.ui.teacher.operationsgroup.operation.edit;

/**
 * Created by Jaime on 06/12/2017.
 */

public interface EditOperationView {
    void showSuccessToast(String message);
    void showErrorToast(String message);

    void finish();

    void showProgress(String title, String message);
    void hideProgress();
}
