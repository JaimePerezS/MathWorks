package com.example.jaime.tfg.ui.teacher.problemsgroup.problem.edit;

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

public class EditProblemActivity extends BaseActivity implements EditProblemView {

    private static final String TAG = EditProblemActivity.class.getSimpleName();

    private static final String ID_PROBLEMS_GROUP = "idProblemsGroup";
    private static final String ID_PROBLEM = "idProblem";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";
    private static final String STATEMENT = "statement";
    private static final String OPERATION = "operation";
    private static final String POINTS = "points";
    private static final String HELP = "help";
    private static final String OPERATION_TYPE = "operationType";

    private EditText edTxtEditarEnunciadoProblema;
    private EditText edTxtEditarOperacionProblema;
    private EditText edTxtEditarPuntosProblema;
    private EditText edTxtEditarAyudaOperacionProblema;
    private Spinner spEditarTipoOperacion;
    private Button btnGuardarCambiosEditarProblema;

    private String idProblemsGroup;
    private String idProblem;
    private String idTeacher;
    private String idUuid;
    private String statement;
    private String operation;
    private int points;
    private String help;
    private String operationType;

    private EditProblemPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idProblemsGroup, String idProblem, String idTeacher, String idUuid, String statement, String operation, int points, String help, String operationType) {
        Intent intent = new Intent(context, EditProblemActivity.class);

        intent.putExtra(ID_PROBLEMS_GROUP, idProblemsGroup);
        intent.putExtra(ID_PROBLEM, idProblem);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);
        intent.putExtra(STATEMENT, statement);
        intent.putExtra(OPERATION, operation);
        intent.putExtra(POINTS, points);
        intent.putExtra(HELP, help);
        intent.putExtra(OPERATION_TYPE, operationType);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_problem);

        edTxtEditarEnunciadoProblema = findViewById(R.id.edTxtEditarProblemaEnunciado);
        edTxtEditarOperacionProblema = findViewById(R.id.edTxtEditarProblemaOperacion);
        edTxtEditarPuntosProblema = findViewById(R.id.edTxtEditarProblemaPuntuacion);
        edTxtEditarAyudaOperacionProblema = findViewById(R.id.edTxtEditarProblemaAyuda);
        spEditarTipoOperacion = findViewById(R.id.spEditarTipoOperacion);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sp_tipoOperacion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEditarTipoOperacion.setAdapter(adapter);

        btnGuardarCambiosEditarProblema = findViewById(R.id.btnEditarProblemaGuardarCambios);

        presenter = new EditProblemPresenterImp(this);

        Bundle bundle = getIntent().getExtras();

        idProblemsGroup = bundle.getString(ID_PROBLEMS_GROUP);
        idProblem = bundle.getString(ID_PROBLEM);
        idTeacher = bundle.getString(ID_TEACHER);
        idUuid = bundle.getString(ID_UUID);
        statement = bundle.getString(STATEMENT);
        operation = bundle.getString(OPERATION);
        points = bundle.getInt(POINTS);
        help = bundle.getString(HELP);
        operationType = bundle.getString(OPERATION_TYPE);

        edTxtEditarEnunciadoProblema.setText(statement);
        edTxtEditarOperacionProblema.setText(operation);
        edTxtEditarPuntosProblema.setText(String.valueOf(points));
        edTxtEditarAyudaOperacionProblema.setText(help);
        spEditarTipoOperacion.setSelection(adapter.getPosition(operationType));

        btnGuardarCambiosEditarProblema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String newStatement = edTxtEditarEnunciadoProblema.getText().toString();
                final String newOperation = edTxtEditarOperacionProblema.getText().toString();
                final int newPoints = Integer.valueOf(edTxtEditarPuntosProblema.getText().toString());
                final String newHelp = edTxtEditarAyudaOperacionProblema.getText().toString();
                final String newOperationType = spEditarTipoOperacion.getSelectedItem().toString();

                saveChanges(newStatement, newPoints, newOperation, newHelp, newOperationType);
            }
        });

        getSupportActionBar().setTitle("Editar Problema");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void saveChanges(final String newStatement, final int newPoints, final String newOperation, final String newHelp, final String newOperationType) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(EditProblemActivity.this);
        alertDialog.setTitle("Confirmar guardar cambios");
        alertDialog.setMessage("¿Está seguro de que quiere guardar los cambios en este problema?");

        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                presenter.onClickUpdateProblem(newStatement, newPoints, newOperation, newHelp, newOperationType, idTeacher, idProblemsGroup, idProblem, idUuid);
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
