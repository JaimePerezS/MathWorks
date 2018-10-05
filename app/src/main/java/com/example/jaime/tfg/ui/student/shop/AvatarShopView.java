package com.example.jaime.tfg.ui.student.shop;

import com.example.jaime.tfg.data.model.Avatar;

import java.util.List;

/**
 * Created by Jaime on 01/02/2018.
 */

public interface AvatarShopView {
    void loadAvatar(List<Avatar> avatarList);

    void showErrorToast(String message);
    void showSuccessToast(String message);

    void updateAvatarPoints(int points);

    void finish();

    void showProgress(String title, String message);
    void hideProgress();
}
