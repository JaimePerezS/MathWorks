package com.example.jaime.tfg.ui.student.selectAvatar;

import com.example.jaime.tfg.data.interactor.student.selectAvatar.SelectAvatarInteractorImp;
import com.example.jaime.tfg.data.model.Avatar;

import java.util.List;

/**
 * Created by Jaime on 04/02/2018.
 */

public class SelectAvatarPresenterImp implements SelectAvatarPresenter {
    private SelectAvatarView view;
    private SelectAvatarInteractorImp interactor;

    public SelectAvatarPresenterImp(SelectAvatarView view) {
        this.view = view;
        this.interactor = new SelectAvatarInteractorImp(this);
    }

    @Override
    public void getAvatar(String idStudent, String token) {
        view.showProgress("Cargando avatares", "Cargando...");
        interactor.getAvatar(idStudent, token);
    }

    @Override
    public void onSuccessGetAvatar(List<Avatar> avatarList) {
        view.hideProgress();
        view.loadAvatar(avatarList);
    }

    @Override
    public void onFailureGetAvatar(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }

    @Override
    public void updateAvatar(String idStudent, String idAvatar, String token) {
        view.showProgress("Cambiando avatar", "Cambiando...");
        interactor.updateAvatar(idStudent, idAvatar, token);
    }

    @Override
    public void onSuccessUpdateAvatar(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureUpdateAvatar(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
