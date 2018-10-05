package com.example.jaime.tfg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 22/10/2017.
 */

public class Operation {
    @Expose
    private int id;
    @SerializedName("enunciado")
    @Expose
    private String statement;
    @SerializedName("solucion")
    @Expose
    private String solution;
    @SerializedName("puntos")
    @Expose
    private int puntos;
    @SerializedName("idGrupoOperaciones")
    @Expose
    private String idOperationsGroup;

    public Operation(int id, String statement, int puntos, String idOperationsGroup) {
        this.id = id;
        this.statement = statement;
        this.puntos = puntos;
        this.idOperationsGroup = idOperationsGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getIdGrupoOperaciones() {
        return idOperationsGroup;
    }

    public void setIdGrupoOperaciones(String idOperationsGroup) {
        this.idOperationsGroup = idOperationsGroup;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
