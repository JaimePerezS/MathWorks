package com.example.jaime.tfg.ui.teacher.operationsgroup.insert;

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

public class InsertOperationsGroupActivity extends BaseActivity implements InsertOperationsGroupView {

    private static final String TAG = InsertOperationsGroupActivity.class.getSimpleName();

    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private EditText edTxtNombreGrupoOperaciones;
    private Spinner spinnerNivel;
    private Button btnInsertarGrupoOperaciones;

    private String idTeacher;
    private String idUuid;

    private InsertOperationsGroupPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idTeacher, String idUuid) {
        Intent intent = new Intent(context, InsertOperationsGroupActivity.class);

        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_grupo_operaciones);

        Bundle bundle =  getIntent().getExtras();

        idTeacher = bundle.getString(ID_TEACHER);
        idUuid = bundle.getString(ID_UUID);

        presenter = new InsertOperationsGroupPresenterImp(this);

        spinnerNivel = findViewById(R.id.spNivel);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sp_dificultad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNivel.setAdapter(adapter);

        edTxtNombreGrupoOperaciones = findViewById(R.id.edTxtNombreGrupoOperaciones);

        btnInsertarGrupoOperaciones = findViewById(R.id.btnInsertarGrupoOperaciones);

        btnInsertarGrupoOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = edTxtNombreGrupoOperaciones.getText().toString();
                final String difficulty = spinnerNivel.getSelectedItem().toString();

                insertOperationsGroup(name, difficulty, idTeacher, idUuid);

            }
        });

        getSupportActionBar().setTitle("Añadir Grupo de Operaciones");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void insertOperationsGroup(final String name, final String difficulty, final String idTeacher, final String idUuid){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(InsertOperationsGroupActivity.this);
        alertDialog.setTitle("Confirmar creación del grupo de operaciones " + name);
        alertDialog.setMessage("¿Está seguro de que quiere crear el grupo de operaciones " + name + "?");
        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                presenter.onClickInsertOperationsGroup(name, difficulty, idTeacher, idUuid);
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
