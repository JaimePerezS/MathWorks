package com.example.jaime.tfg.data.local;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.jaime.tfg.data.model.Teacher;
import com.example.jaime.tfg.ui.main.activity.MainActivity;
import com.example.jaime.tfg.ui.teacher.MainTeacherActivity;

/**
 * Created by Jaime on 06/10/2017.
 */

public class TeacherSessionManager implements SessionConstants {

    private static String TAG = TeacherSessionManager.class.getSimpleName();

    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context context;

    public TeacherSessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(NAME, PRIVACY_MODE);
        editor = pref.edit();
    }

    public void login(Teacher teacher) {
        editor.putBoolean(IS_TEACHER_LOGGED, true);

        editor.putString(KEY_ID, String.valueOf(teacher.getId()));
        editor.putString(KEY_NOMBRE, teacher.getName());
        editor.putString(KEY_APELLIDOS, teacher.getSurname());
        editor.putString(KEY_CORREO, teacher.getEmail());
        editor.putString(KEY_UUID, teacher.getUuid());

        editor.commit();
    }

    public void checkLogin() {
        if(this.isLogged()) {

            Intent intent = new Intent(context, MainTeacherActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);

        }
    }

    public Teacher getTeacherDetails() {

        int id = Integer.parseInt(pref.getString(KEY_ID, null));
        String name = pref.getString(KEY_NOMBRE, null);
        String apellidos = pref.getString(KEY_APELLIDOS, null);
        String correoElectronico = pref.getString(KEY_CORREO, null);
        String uuid = pref.getString(KEY_UUID, null);

        Teacher teacher = new Teacher(id, name, apellidos, correoElectronico, uuid);

        return teacher;
    }

    public void updateTeacherDetails(String nombre, String apellidos) {
        editor.putString(KEY_NOMBRE, nombre);
        editor.putString(KEY_APELLIDOS, apellidos);

        editor.commit();

    }

    public void logOut() {

        editor.clear();
        editor.commit();

        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    public boolean isLogged() {
        return pref.getBoolean(IS_TEACHER_LOGGED, false);
    }


}
