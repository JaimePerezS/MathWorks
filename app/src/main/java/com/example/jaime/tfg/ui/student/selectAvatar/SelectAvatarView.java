package com.example.jaime.tfg.ui.student.selectAvatar;

import com.example.jaime.tfg.data.model.Avatar;

import java.util.List;

/**
 * Created by Jaime on 04/02/2018.
 */

public interface SelectAvatarView {
    void loadAvatar(List<Avatar> avatarList);

    void showErrorToast(String message);
    void showSuccessToast(String message);

    void finish();

    void showProgress(String title, String message);
    void hideProgress();
}
