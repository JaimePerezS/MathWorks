package com.example.jaime.tfg.ui.teacher.operationsgroup.operation.insert;

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

public class InsertOperationActivity extends BaseActivity implements InsertOperationView {

    private static final String TAG = InsertOperationActivity.class.getSimpleName();

    private static final String ID_OPERATIONS_GROUP = "idOperationsGroup";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private EditText edTxtEnunciadoOperacion;
    private EditText edTxtPuntosOperacion;
    private Button btnInsertarOperacion;

    private String idTeacher;
    private String idOperationsGroup;
    private String idUuid;

    private InsertOperationPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idOperationsGroup, String idTeacher, String idUuid) {
        Intent intent = new Intent(context, InsertOperationActivity.class);

        intent.putExtra(ID_OPERATIONS_GROUP, idOperationsGroup);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_operacion);

        presenter = new InsertOperationPresenterImp(this);

        Bundle bundle = getIntent().getExtras();

        idTeacher = bundle.getString(ID_TEACHER);
        idOperationsGroup = bundle.getString(ID_OPERATIONS_GROUP);
        idUuid = bundle.getString(ID_UUID);

        edTxtEnunciadoOperacion = findViewById(R.id.edTxtEnunciadoOperacion);
        edTxtPuntosOperacion = findViewById(R.id.edTxtPuntosOperacion);
        btnInsertarOperacion = findViewById(R.id.btnInsertarOperacion);

        btnInsertarOperacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String statement = edTxtEnunciadoOperacion.getText().toString();
                final int points = Integer.valueOf(edTxtPuntosOperacion.getText().toString());
                insertOperation(statement, points);
            }
        });

        getSupportActionBar().setTitle("Insertar Operación");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void insertOperation(final String statement, final int points) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(InsertOperationActivity.this);
        alertDialog.setTitle("Confirmar añadir operación");
        alertDialog.setMessage("¿Está seguro de que quiere añadir esta nueva operación?");
        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {

                presenter.onClickInsertOperation(statement, points, idTeacher, idOperationsGroup, idUuid);
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
