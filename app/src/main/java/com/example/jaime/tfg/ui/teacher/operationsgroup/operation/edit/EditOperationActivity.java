package com.example.jaime.tfg.ui.teacher.operationsgroup.operation.edit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.ui.base.BaseActivity;

public class EditOperationActivity extends BaseActivity implements EditOperationView{

    private static final String TAG = EditOperationActivity.class.getSimpleName();

    private static final String ID_OPERATIONS_GROUP = "idOperationsGroup";
    private static final String ID_OPERATION = "idOperation";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";
    private static final String STATEMENT = "statement";
    private static final String POINTS = "points";

    private EditText edTxtEditarEnunciadoOperacion;
    private EditText edTxtEditarPuntosOperacion;
    private Button btnGuardarCambiosEditarOperacion;

    private String idOperationsGroup;
    private String idOperation;
    private String idTeacher;
    private String idUuid;
    private String statement;
    private int points;

    private EditOperationPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idOperationsGroup, String idOperation, String idTeacher, String idUuid, String statement, int points) {
        Intent intent = new Intent(context, EditOperationActivity.class);

        intent.putExtra(ID_OPERATIONS_GROUP, idOperationsGroup);
        intent.putExtra(ID_OPERATION, idOperation);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);
        intent.putExtra(STATEMENT, statement);
        intent.putExtra(POINTS, points);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_operation);

        edTxtEditarEnunciadoOperacion = findViewById(R.id.edTxtEditarOperacionEnunciado);
        edTxtEditarPuntosOperacion = findViewById(R.id.edTxtEditarOperacionPuntuacion);

        btnGuardarCambiosEditarOperacion = findViewById(R.id.btnEditarOperacionGuardarCambios);

        Bundle bundle = getIntent().getExtras();

        idOperationsGroup = bundle.getString(ID_OPERATIONS_GROUP);
        idOperation = bundle.getString(ID_OPERATION);
        idTeacher = bundle.getString(ID_TEACHER);
        idUuid = bundle.getString(ID_UUID);
        statement = bundle.getString(STATEMENT);
        points = bundle.getInt(POINTS);

        edTxtEditarEnunciadoOperacion.setText(statement);
        edTxtEditarPuntosOperacion.setText(String.valueOf(points));

        presenter = new EditOperationPresenterImp(this);

        btnGuardarCambiosEditarOperacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String statement = edTxtEditarEnunciadoOperacion.getText().toString();
                final int points = Integer.valueOf(edTxtEditarPuntosOperacion.getText().toString());

                saveChanges(statement, points);
            }
        });

        getSupportActionBar().setTitle("Editar Operacion");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void saveChanges(final String statement, final int points) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(EditOperationActivity.this);
        alertDialog.setTitle("Confirmar guardar cambios");
        alertDialog.setMessage("¿Está seguro de que quiere guardar los cambios en esta operación?");

        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {

                presenter.OnClickUpdateOperation(statement, points, idTeacher, idOperationsGroup, idOperation, idUuid);
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
