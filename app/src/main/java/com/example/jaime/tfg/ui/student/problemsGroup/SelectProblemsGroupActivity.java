package com.example.jaime.tfg.ui.student.problemsGroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.ProblemsGroup;
import com.example.jaime.tfg.ui.base.BaseActivity;

import java.util.List;

public class SelectProblemsGroupActivity extends BaseActivity implements SelectProblemsGroupView{

    private static final String TAG = SelectProblemsGroupActivity.class.getSimpleName();

    private static final String ID_STUDENT = "idStudent";
    private static final String ID_TOKEN = "token";

    private String idStudent;
    private String token;

    private RecyclerView listaGrupoProblemas;
    private RecyclerView.LayoutManager lManager;
    private ProblemsGroupAdapter listaProblemsGroupAdapter;

    private SelectProblemsGroupPresenterImp presenter;

    private Button btnBack;

    public static Intent getCallingIntent(Context context, String idStudent, String token) {
        Intent intent = new Intent(context, SelectProblemsGroupActivity.class);

        intent.putExtra(ID_STUDENT, idStudent);
        intent.putExtra(ID_TOKEN, token);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_select_problems_group);

        listaGrupoProblemas = findViewById(R.id.rVGruposProblemas);
        listaGrupoProblemas.setHasFixedSize(true);
        btnBack = findViewById(R.id.btnAtras);

        Bundle bundle = getIntent().getExtras();

        idStudent = bundle.getString(ID_STUDENT);
        token = bundle.getString(ID_TOKEN);

        lManager = new LinearLayoutManager(this);
        listaGrupoProblemas.setLayoutManager(lManager);

        presenter = new SelectProblemsGroupPresenterImp(this);

        presenter.getProblemsGroups(idStudent, token);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getSupportActionBar().hide();

    }

    @Override
    public void showProblemsGroup(List<ProblemsGroup> problemsGroupList) {
        listaProblemsGroupAdapter = new ProblemsGroupAdapter(problemsGroupList, this, new ProblemsGroupAdapter.ProblemsGroupCallBack() {
            @Override
            public void onClick(ProblemsGroup problemsGroup) {
                navigator.navigateToResolveProblems(getApplicationContext(), idStudent, String.valueOf(problemsGroup.getId()), problemsGroup.getDifficulty(), token);
            }
        });

        listaGrupoProblemas.setAdapter(listaProblemsGroupAdapter);
    }
}
