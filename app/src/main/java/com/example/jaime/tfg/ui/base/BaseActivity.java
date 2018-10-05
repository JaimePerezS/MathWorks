package com.example.jaime.tfg.ui.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.jaime.tfg.ui.navigation.Navigator;

import es.dmoral.toasty.Toasty;

/**
 * Created by Jaime on 16/11/2017.
 */

public class BaseActivity extends AppCompatActivity {

    protected Navigator navigator = Navigator.getInstance();
    private ProgressDialog progressDialog;

    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    public void showSuccessToast(String message) {
        Toasty.success(this, message, Toast.LENGTH_LONG, true).show();
    }

    public void showErrorToast(String message) {
        Toasty.error(this, message, Toast.LENGTH_LONG, true).show();
    }

    public void showInfoToast(String message) {
        Toasty.info(this, message, Toast.LENGTH_LONG, true).show();
    }

    public void showWarningToast(String message) {
        Toasty.warning(this, message, Toast.LENGTH_LONG, true).show();
    }

    public void showProgress(String title, String message) {
        if(progressDialog != null && progressDialog.isShowing()) {
            hideProgress();
        }
        progressDialog = ProgressDialog.show(BaseActivity.this, title, message, true);
    }

    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
