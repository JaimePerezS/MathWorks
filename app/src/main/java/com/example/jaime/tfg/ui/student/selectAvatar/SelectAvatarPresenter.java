package com.example.jaime.tfg.ui.student.selectAvatar;

import com.example.jaime.tfg.data.model.Avatar;

import java.util.List;

/**
 * Created by Jaime on 04/02/2018.
 */

public interface SelectAvatarPresenter {
    void getAvatar(String idStudent, String token);
    void onSuccessGetAvatar(List<Avatar> avatarList);
    void onFailureGetAvatar(String message);

    void updateAvatar(String idStudent, String idAvatar, String token);
    void onSuccessUpdateAvatar(String message);
    void onFailureUpdateAvatar(String message);
}
