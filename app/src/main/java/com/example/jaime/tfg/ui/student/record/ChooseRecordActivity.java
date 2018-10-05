package com.example.jaime.tfg.ui.student.record;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.ui.base.BaseActivity;

public class ChooseRecordActivity extends BaseActivity {

    private static final String ID_STUDENT = "idStudent";
    private static final String ID_UUID = "token";

    Button btnBack;
    Button btnOperationsGroupRecords;
    Button btnProblemsGroupRecords;

    private String idStudent;
    private String token;

    public static Intent getCallingIntent(Context context, String idStudent, String token) {
        Intent intent = new Intent(context, ChooseRecordActivity.class);

        intent.putExtra(ID_STUDENT, idStudent);
        intent.putExtra(ID_UUID, token);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_choose_record);

        Bundle bundle = getIntent().getExtras();

        idStudent = bundle.getString(ID_STUDENT, idStudent);
        token = bundle.getString(ID_UUID, token);

        btnBack = findViewById(R.id.btnAtras);
        btnOperationsGroupRecords = findViewById(R.id.btnVerProgresoGrupoOperaciones);
        btnProblemsGroupRecords = findViewById(R.id.btnVerProgresoGrupoProblemas);

        btnOperationsGroupRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateToOperationsGroupRecord(getApplicationContext(), idStudent, token);
            }
        });

        btnProblemsGroupRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateToProblemsGroupRecord(getApplicationContext(), idStudent, token);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getSupportActionBar().hide();

    }
}
