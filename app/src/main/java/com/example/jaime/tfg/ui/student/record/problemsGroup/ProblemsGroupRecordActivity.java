package com.example.jaime.tfg.ui.student.record.problemsGroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.ProblemsGroupRecord;
import com.example.jaime.tfg.ui.base.BaseActivity;

public class ProblemsGroupRecordActivity extends BaseActivity implements ProblemsGroupRecordFragment.OnFragmentInteractionListener {

    private static final String ID_STUDENT = "idStudent";
    private static final String ID_UUID = "token";

    private Button btnBack;

    private TextView txtViewProgress;

    private String idStudent, token;

    public static Intent getCallingIntent(Context context, String idStudent, String token) {
        Intent intent = new Intent(context, ProblemsGroupRecordActivity.class);

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

        setContentView(R.layout.activity_problems_group_record);

        btnBack = findViewById(R.id.btnAtras);
        txtViewProgress = findViewById(R.id.txtViewProgresos);

        Bundle bundle = getIntent().getExtras();

        idStudent = bundle.getString(ID_STUDENT);
        token = bundle.getString(ID_UUID);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getSupportActionBar().hide();

        addFragment(R.id.leftFrameLayout, ProblemsGroupRecordFragment.newInstance(idStudent, token));
        txtViewProgress.setText("Progresos grupos de problemas");
    }

    @Override
    public void onProblemsGroupClick(ProblemsGroupRecord problemsGroupRecord) {
        addFragment(R.id.rigthFrameLayout, ProblemsRecordFragment.newInstance(idStudent, problemsGroupRecord.getIdProblemsGroup(), String.valueOf(problemsGroupRecord.getId()), token));
        txtViewProgress.setText("Progresos del grupo de problemas " + problemsGroupRecord.getName());
    }
}
