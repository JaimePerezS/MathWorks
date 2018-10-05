package com.example.jaime.tfg.ui.teacher.problemsgroup.edit;

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

public class EditProblemsGroupActivity extends BaseActivity implements EditProblemsGroupView {

    private static final String TAG = EditProblemsGroupActivity.class.getSimpleName();

    private static final String ID_PROBLEMS_GROUP = "idProblemsGroup";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";
    private static final String NAME = "name";
    private static final String DIFFICULTY = "difficulty";

    private EditText edTxtEditarNombreGrupoProblemas;
    private Spinner spEditarDificultadGrupoProblemas;
    private Button btnGuardarCambiosEditarGrupoProblemas;

    private String idTeacher;
    private String idProblemsGroup;
    private String idUuid;

    private EditProblemsGroupPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idGroup, String name, String difficulty, String idTeacher, String idUuid) {
        Intent intent = new Intent(context, EditProblemsGroupActivity.class);

        intent.putExtra(ID_PROBLEMS_GROUP, idGroup);
        intent.putExtra(NAME, name);
        intent.putExtra(DIFFICULTY, difficulty);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_grupo_problemas);

        edTxtEditarNombreGrupoProblemas = findViewById(R.id.edTxtEditarNombreGrupoProblemas);
        spEditarDificultadGrupoProblemas = findViewById(R.id.spEditarGrupoProblemasDificultad);
        btnGuardarCambiosEditarGrupoProblemas = findViewById(R.id.btnGuardarCambiosEditarGrupoProblemas);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sp_dificultad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEditarDificultadGrupoProblemas.setAdapter(adapter);

        Bundle bundle = getIntent().getExtras();

        idTeacher = bundle.getString(ID_TEACHER);
        idProblemsGroup = bundle.getString(ID_PROBLEMS_GROUP);
        idUuid = bundle.getString(ID_UUID);

        edTxtEditarNombreGrupoProblemas.setText(bundle.getString(NAME));
        spEditarDificultadGrupoProblemas.setSelection(adapter.getPosition(bundle.getString(DIFFICULTY)));

        presenter = new EditProblemsGroupPresenterImp(this);

        btnGuardarCambiosEditarGrupoProblemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String newName = edTxtEditarNombreGrupoProblemas.getText().toString();
                final String newDifficulty = spEditarDificultadGrupoProblemas.getSelectedItem().toString();
                saveChanges(newName, newDifficulty);
            }
        });

        getSupportActionBar().setTitle("Editar Grupo Problemas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void saveChanges(final String newName, final String newDifficulty) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(EditProblemsGroupActivity.this);
        alertDialog.setTitle("Confirmar guardar cambios");
        alertDialog.setMessage("¿Está seguro de que quiere guardar los cambios en este grupo de problemas?");
        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
            presenter.onClickUpdateProblem(newName, newDifficulty, idTeacher, idProblemsGroup, idUuid);
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

