package com.example.jaime.tfg.ui.student.shop;

import com.example.jaime.tfg.data.model.Avatar;
import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 01/02/2018.
 */

public interface AvatarShopPresenter {
    void getAvatar(String idStudent, String token);
    void onSuccessGetAvatar(List<Avatar> avatarList);
    void onFailureGetAvatar(String message);

    void buyAvatar(Student student, Avatar avatar, String token);
    void onSuccessBuyAvatar(int newPoints, String message);
    void onFailureBuyAvatar(String message);
}
