package com.example.jaime.tfg.ui.teacher.operationsgroup.edit;

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

public class EditOperationsGroupActivity extends BaseActivity implements EditOperationsGroupView {

    private static final String TAG = EditOperationsGroupActivity.class.getSimpleName();

    private static final String ID_OPERATIONS_GROUP = "idOperationsGroup";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";
    private static final String NAME = "name";
    private static final String DIFFICULTY = "difficulty";

    private Spinner spEditarDificultadGrupoOperaciones;
    private EditText edTxtEditarNombreGrupoOperaciones;
    private Button btnGuardarCambiosEditarGrupoOperaciones;

    private String idTeacher;
    private String idOperationsGroup;
    private String idUuid;

    private EditOperationsGroupPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idGroup, String name, String difficulty, String idTeacher, String idUuid) {
        Intent intent = new Intent(context, EditOperationsGroupActivity.class);

        intent.putExtra(ID_OPERATIONS_GROUP, idGroup);
        intent.putExtra(NAME, name);
        intent.putExtra(DIFFICULTY, difficulty);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_grupo_operaciones);

        edTxtEditarNombreGrupoOperaciones = findViewById(R.id.edTxtEditarNombreGrupoOperaciones);
        btnGuardarCambiosEditarGrupoOperaciones = findViewById(R.id.btnGuardarCambiosEditarGrupoOperaciones);

        presenter = new EditOperationsGroupPresenterImp(this);

        Bundle bundle = getIntent().getExtras();

        edTxtEditarNombreGrupoOperaciones.setText(bundle.getString(NAME));

        spEditarDificultadGrupoOperaciones = findViewById(R.id.spEditarDificultadGrupoOperaciones);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sp_dificultad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEditarDificultadGrupoOperaciones.setAdapter(adapter);

        spEditarDificultadGrupoOperaciones.setSelection(adapter.getPosition(bundle.getString(DIFFICULTY)));

        idTeacher = bundle.getString(ID_TEACHER);
        idOperationsGroup = bundle.getString(ID_OPERATIONS_GROUP);
        idUuid = bundle.getString(ID_UUID);

        btnGuardarCambiosEditarGrupoOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String newName = edTxtEditarNombreGrupoOperaciones.getText().toString();
                final String newDifficulty = spEditarDificultadGrupoOperaciones.getSelectedItem().toString();
                saveChanges(newName, newDifficulty, idTeacher, idOperationsGroup, idUuid);

            }
        });

        getSupportActionBar().setTitle("Editar Grupo Operaciones");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void saveChanges(final String newName, final String newDifficulty, final String idTeacher, final String idOperationsGroup, final String idUuid) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(EditOperationsGroupActivity.this);
        alertDialog.setTitle("Confirmar guardar cambios");
        alertDialog.setMessage("¿Está seguro de que quiere guardar los cambios en este grupo de operaciones?");

        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                presenter.onClickUpdateOperationsGroup(newName, newDifficulty, idTeacher, idOperationsGroup, idUuid);
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
