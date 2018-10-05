package com.example.jaime.tfg.ui.student.operationsGroup.resolveOperations;

import com.example.jaime.tfg.data.model.Operation;

import java.util.List;

/**
 * Created by Jaime on 06/02/2018.
 */

public interface ResolveOperationsView {
   void loadOperations(List<Operation> operationList);

   void showErrorToast(String message);
   void showSuccessToast(String message);

   void showProgress(String title, String message);
   void hideProgress();

   void finish();
}
