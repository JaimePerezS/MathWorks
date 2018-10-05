package com.example.jaime.tfg.ui.teacher.problemsgroup.problem.insert;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.ui.base.BaseActivity;

public class InsertProblemActivity extends BaseActivity implements InsertProblemView {

    private static final String TAG = InsertProblemActivity.class.getSimpleName();

    private static final String ID_PROBLEMS_GROUP = "idProblemsGroup";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private EditText edTxtEnunciadoProblema;
    private EditText edTxtOperacionProblema;
    private EditText edTxtPuntosProblema;
    private EditText edTxtAyudaProblema;
    private Spinner spTipoOperacion;

    private Button btnInsertarProblema;

    private String idTeacher;
    private String idProblemsGroup;
    private String idUuid;

    private InsertProblemPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idProblemsGroup, String idTeacher, String idUuid) {
        Intent intent = new Intent(context, InsertProblemActivity.class);

        intent.putExtra(ID_PROBLEMS_GROUP, idProblemsGroup);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_problema);

        Bundle bundle = getIntent().getExtras();

        idTeacher = bundle.getString(ID_TEACHER);
        idProblemsGroup = bundle.getString(ID_PROBLEMS_GROUP);
        idUuid = bundle.getString(ID_UUID);

        presenter = new InsertProblemPresenterImp(this);

        edTxtEnunciadoProblema = findViewById(R.id.edTxtEnunciadoProblema);
        edTxtOperacionProblema = findViewById(R.id.edTxtInsertarProblemaOperacion);
        edTxtPuntosProblema = findViewById(R.id.edTxtInsertarProblemaPuntos);
        edTxtAyudaProblema = findViewById(R.id.edTxtInsertarProblemaAyuda);
        spTipoOperacion = findViewById(R.id.spInsertarTipoOperacion);
        btnInsertarProblema = findViewById(R.id.btnInsertarProblema);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sp_tipoOperacion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoOperacion.setAdapter(adapter);


        btnInsertarProblema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String statement = edTxtEnunciadoProblema.getText().toString();
                final String operation = edTxtOperacionProblema.getText().toString();
                final int points = Integer.valueOf(edTxtPuntosProblema.getText().toString());
                final String help = edTxtAyudaProblema.getText().toString();
                final String operationType = spTipoOperacion.getSelectedItem().toString();

                insertProblem(statement, operation, points, help, operationType);
            }
        });

        getSupportActionBar().setTitle("Insertar Problema");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void insertProblem(final String statement, final String operation, final int points, final String help, final String operationType) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(InsertProblemActivity.this);
        alertDialog.setTitle("Confirmar añadir problema");
        alertDialog.setMessage("¿Está seguro de que quiere añadir este nuevo problema?");
        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {

                presenter.onClickInsertProblem(statement, operation, points, help, operationType, idTeacher, idProblemsGroup, idUuid);
            }
        });

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
