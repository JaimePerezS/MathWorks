package com.example.jaime.tfg.ui.student.shop;

import com.example.jaime.tfg.data.interactor.student.shop.AvatarShopInteractorImp;
import com.example.jaime.tfg.data.model.Avatar;
import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 01/02/2018.
 */

public class AvatarShopPresenterImp implements AvatarShopPresenter {
    private AvatarShopView view;
    private AvatarShopInteractorImp interactor;

    public AvatarShopPresenterImp(AvatarShopView view) {
        this.view = view;
        this.interactor = new AvatarShopInteractorImp(this);
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
        view.finish();
    }

    @Override
    public void buyAvatar(Student student, Avatar avatar, String token) {
        view.showProgress("Comprando avatar", "Comprando...");
        interactor.buyAvatar(student, avatar, token);
    }

    @Override
    public void onSuccessBuyAvatar(int newPoints, String message) {
        view.hideProgress();
        view.updateAvatarPoints(newPoints);
        view.showSuccessToast(message);
        view.finish();
    }

    @Override
    public void onFailureBuyAvatar(String message) {
        view.hideProgress();
        view.showErrorToast(message);
    }
}
