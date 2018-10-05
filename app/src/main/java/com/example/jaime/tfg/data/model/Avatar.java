package com.example.jaime.tfg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 21/01/2018.
 */

public class Avatar {
    @SerializedName("id")
    @Expose
    int idAvatar;
    @SerializedName("nombre")
    @Expose
    String name;
    @SerializedName("coste")
    @Expose
    int cost;

    public Avatar(int idAvatar, String name, int cost) {
        this.idAvatar = idAvatar;
        this.name = name;
        this.cost = cost;
    }

    public int getIdAvatar() {
        return idAvatar;
    }

    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
