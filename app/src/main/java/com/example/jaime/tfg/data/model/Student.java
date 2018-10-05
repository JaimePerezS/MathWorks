package com.example.jaime.tfg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 06/10/2017.
 */

public class Student {

    @Expose
    private int id;
    @SerializedName("nombre")
    @Expose
    private String name;
    @SerializedName("apellidos")
    @Expose
    private String surname;
    @SerializedName("idClase")
    @Expose
    private int idClassroom;
    @SerializedName("idPublico")
    @Expose
    private String idPublic;
    @SerializedName("idAvatar")
    @Expose
    private String idAvatar;
    @SerializedName("puntuacion")
    @Expose
    private int points;
    @SerializedName("token")
    @Expose
    private String token;

    public Student(int id, String name, String surname, int idClassroom, String idPublic, String idAvatar, int points, String token) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.idClassroom = idClassroom;
        this.idPublic = idPublic;
        this.idAvatar = idAvatar;
        this.points = points;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }

    public String getIdPublic() {
        return idPublic;
    }

    public void setIdPublic(String idPublic) {
        this.idPublic = idPublic;
    }

    public String getIdAvatar() {
        return idAvatar;
    }

    public void setIdAvatar(String idAvatar) {
        this.idAvatar = idAvatar;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
