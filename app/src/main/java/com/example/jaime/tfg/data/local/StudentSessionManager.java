package com.example.jaime.tfg.data.local;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.ui.main.activity.MainActivity;
import com.example.jaime.tfg.ui.student.MainStudentActivity;

/**
 * Created by Jaime on 09/01/2018.
 */

public class StudentSessionManager implements SessionConstants{

    private static String TAG = StudentSessionManager.class.getSimpleName();

    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context context;

    public StudentSessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(NAME, PRIVACY_MODE);
        editor = pref.edit();
    }

    public void login(Student student) {
        editor.putBoolean(IS_STUDENT_LOGGED, true);

        editor.putString(KEY_ID_STUDENT, String.valueOf(student.getId()));
        editor.putString(KEY_NOMBRE, student.getName());
        editor.putString(KEY_APELLIDOS, student.getSurname());
        editor.putString(KEY_ID_CLASE, String.valueOf(student.getIdClassroom()));
        editor.putString(KEY_UUID, student.getIdPublic());
        editor.putString(KEY_ID_AVATAR, student.getIdAvatar());
        editor.putString(KEY_PUNTUACION, String.valueOf(student.getPoints()));
        editor.putString(KEY_ID_TOKEN, student.getToken());

        editor.commit();

    }

    public void checkLogin() {
        if(this.isLogged()) {

            Intent intent = new Intent(context, MainStudentActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);

        }
    }

    public boolean isLogged() {
        return pref.getBoolean(IS_STUDENT_LOGGED, false);
    }

    public Student getStudentDetails() {

        int id = Integer.parseInt(pref.getString(KEY_ID_STUDENT, null));
        String name = pref.getString(KEY_NOMBRE, null);
        String apellidos = pref.getString(KEY_APELLIDOS, null);
        int idClase = Integer.parseInt(pref.getString(KEY_ID_CLASE, null));
        String idPublic = pref.getString(KEY_UUID, null);
        String idAvatar = pref.getString(KEY_ID_AVATAR, null);
        int points = Integer.parseInt(pref.getString(KEY_PUNTUACION, null));
        String token = pref.getString(KEY_ID_TOKEN, null);

        Student student = new Student(id, name, apellidos, idClase, idPublic, idAvatar, points, token);

        return student;
    }

    public void updateAvatar(String idAvatar) {
        editor.putString(KEY_ID_AVATAR, idAvatar);
        editor.commit();
    }

    public void updatePoints(int points) {
        editor.putString(KEY_PUNTUACION, String.valueOf(points));
        editor.commit();
    }

    public void logOut() {

        editor.clear();
        editor.commit();

        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
