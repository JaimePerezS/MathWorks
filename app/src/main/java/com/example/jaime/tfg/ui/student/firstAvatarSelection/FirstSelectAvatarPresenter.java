package com.example.jaime.tfg.ui.student.firstAvatarSelection;

/**
 * Created by Jaime on 19/01/2018.
 */

public interface FirstSelectAvatarPresenter {
    void updateAvatar(String idAvatar, String idStudent, String token);
    void onSuccessUpdateAvatar(String message);
    void onFailureUpdateAvatar(String message);

    void buyAvatar(String idStudent, String idAvatar, String token);
    void onSuccessBuyAvatar(String message);
    void onFailureBuyAvatar(String message);
}
