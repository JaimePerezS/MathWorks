package com.example.jaime.tfg.ui.student.firstAvatarSelection;

import com.example.jaime.tfg.data.interactor.student.firstAvatarSelecion.FirstSelectAvatarInteractorImp;

/**
 * Created by Jaime on 19/01/2018.
 */

public class FirstSelectAvatarPresenterImp implements FirstSelectAvatarPresenter {

    private FirstSelectAvatarView view;
    private FirstSelectAvatarInteractorImp interactor;

    public FirstSelectAvatarPresenterImp(FirstSelectAvatarView view) {
        this.view = view;
        this.interactor = new FirstSelectAvatarInteractorImp(this);
    }

    @Override
    public void updateAvatar(String idAvatar, String idStudent, String token) {
        view.showProgress("Cambiando avatar", "Cambiando...");
        interactor.updateAvatar(idAvatar, idStudent, token);
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

    @Override
    public void buyAvatar(String idStudent, String idAvatar, String token) {
        view.showProgress("Comprando avatar", "Comprando");
        interactor.buyAvatar(idStudent, idAvatar, token);
    }

    @Override
    public void onSuccessBuyAvatar(String message) {
        view.hideProgress();
        view.showSuccessToast(message);
    }

    @Override
    public void onFailureBuyAvatar(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
