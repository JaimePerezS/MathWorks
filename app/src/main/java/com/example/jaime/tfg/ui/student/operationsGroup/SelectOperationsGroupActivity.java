package com.example.jaime.tfg.ui.student.operationsGroup;

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
import com.example.jaime.tfg.data.model.OperationsGroup;
import com.example.jaime.tfg.ui.base.BaseActivity;

import java.util.List;

public class SelectOperationsGroupActivity extends BaseActivity implements SelectOperationsGroupView{

    private static final String TAG = SelectOperationsGroupActivity.class.getSimpleName();

    private static final String ID_STUDENT = "idStudent";
    private static final String ID_TOKEN = "token";

    private String idStudent;
    private String token;

    private RecyclerView listaGrupoOperaciones;
    private RecyclerView.LayoutManager lManager;
    private OperationsGroupAdapter listaProblemsGroupAdapter;

    private Button btnBack;

    private SelectOperationsGroupPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idStudent, String token) {
        Intent intent = new Intent(context, SelectOperationsGroupActivity.class);

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

        setContentView(R.layout.activity_select_operations_group);

        listaGrupoOperaciones = findViewById(R.id.rVGruposOperaciones);
        listaGrupoOperaciones.setHasFixedSize(true);
        btnBack = findViewById(R.id.btnAtras);

        Bundle bundle = getIntent().getExtras();

        idStudent = bundle.getString(ID_STUDENT);
        token = bundle.getString(ID_TOKEN);

        lManager = new LinearLayoutManager(this);
        listaGrupoOperaciones.setLayoutManager(lManager);

        presenter = new SelectOperationsGroupPresenterImp(this);

        presenter.getOperationsGroups(idStudent, token);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getSupportActionBar().hide();
    }

    @Override
    public void showOperationsGroup(final List<OperationsGroup> operationsGroupList) {
        listaProblemsGroupAdapter = new OperationsGroupAdapter(operationsGroupList, this, new OperationsGroupAdapter.OperationsGroupCallBack() {
            @Override
            public void onClick(OperationsGroup operationsGroup) {
                navigator.navigateToResolveOperations(getApplicationContext(), idStudent, String.valueOf(operationsGroup.getId()), operationsGroup.getDifficulty(), token);
            }
        });

        listaGrupoOperaciones.setAdapter(listaProblemsGroupAdapter);
    }
}
