package com.example.jaime.tfg.ui.base;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.example.jaime.tfg.ui.navigation.Navigator;

import es.dmoral.toasty.Toasty;

/**
 * Created by Jaime on 16/11/2017.
 */

public class BaseFragment extends Fragment {

    protected Navigator navigator = Navigator.getInstance();
    protected ProgressDialog progressDialog;

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    public void showSuccessToast(String message) {
        Toasty.success(getActivity(), message, Toast.LENGTH_LONG, true).show();
    }

    public void showErrorToast(String message) {
        Toasty.error(getActivity(), message, Toast.LENGTH_LONG, true).show();
    }

    public void showInfoToast(String message) {
        Toasty.info(getActivity(), message, Toast.LENGTH_LONG, true).show();
    }

    public void showWarningToast(String message) {
        Toasty.warning(getActivity(), message, Toast.LENGTH_LONG, true).show();
    }

    public void showProgress(String title, String message) {
        if(progressDialog != null && progressDialog.isShowing()) {
            hideProgress();
        }
        progressDialog = ProgressDialog.show(getActivity(), title, message, true);
    }

    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
