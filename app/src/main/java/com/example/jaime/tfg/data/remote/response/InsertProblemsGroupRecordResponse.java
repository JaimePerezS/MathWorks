package com.example.jaime.tfg.data.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaime on 21/03/2018.
 */

public class InsertProblemsGroupRecordResponse {
    @SerializedName("LAST_INSERT_ID()")
    @Expose
    String idRecord;

    public InsertProblemsGroupRecordResponse(String idRecord) {
        this.idRecord = idRecord;
    }

    public String getIdRecord() {
        return idRecord;
    }
}
