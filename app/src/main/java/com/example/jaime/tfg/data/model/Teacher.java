package com.example.jaime.tfg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 06/10/2017.
 */

public class Teacher {

    @Expose
    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    @Expose
    private String name;
    @SerializedName("apellidos")
    @Expose
    private String surname;
    @SerializedName("correoElectronico")
    @Expose
    private String email;
    @SerializedName("contrasenaEncriptada")
    @Expose
    private String encryptedPassword;
    @Expose
    private String salt;
    @SerializedName("token")
    @Expose
    private String uuid;

    public Teacher(int id, String name, String surname, String email, String uuid) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.uuid = uuid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
