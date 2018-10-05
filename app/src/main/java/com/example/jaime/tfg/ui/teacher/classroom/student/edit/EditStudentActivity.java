package com.example.jaime.tfg.ui.teacher.classroom.student.edit;

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

public class EditStudentActivity extends BaseActivity implements EditStudentView {

    private static final String TAG = EditStudentActivity.class.getSimpleName();

    private static final String ID_CLASSROOM = "idClassroom";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";
    private static final String ID_STUDENT = "idStudent";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";

    private EditText edTxtNombreEditarAlumno;
    private EditText edTxtApellidosEditarAlumno;
    private Button btnGuardarCambiosEditarAlumno;

    private EditStudentPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idClassroom, String idTeacher, String idUuid, String idStudent, String name, String surname) {
        Intent intent = new Intent(context, EditStudentActivity.class);

        intent.putExtra(ID_CLASSROOM, idClassroom);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);
        intent.putExtra(ID_STUDENT, idStudent);
        intent.putExtra(NAME, name);
        intent.putExtra(SURNAME, surname);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_alumno);

        edTxtNombreEditarAlumno = findViewById(R.id.edTxtNombreEditarAlumno);
        edTxtApellidosEditarAlumno = findViewById(R.id.edTxtApellidosEditarAlumno);

        presenter = new EditStudentPresenterImp(this);

        Bundle bundle = getIntent().getExtras();

        edTxtNombreEditarAlumno.setText(bundle.getString(NAME));
        edTxtApellidosEditarAlumno.setText(bundle.getString(SURNAME));

        btnGuardarCambiosEditarAlumno = findViewById(R.id.btnGuardarCambiosEditarAlumno);

        final String idTeacher = bundle.getString(ID_TEACHER);
        final String idClassroom = bundle.getString(ID_CLASSROOM);
        final String idStudent = bundle.getString(ID_STUDENT);
        final String token = bundle.getString(ID_UUID);

        btnGuardarCambiosEditarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = edTxtNombreEditarAlumno.getText().toString();
                String newSurname = edTxtApellidosEditarAlumno.getText().toString();
                saveChanges(newName, newSurname, idTeacher, idClassroom, idStudent, token);
            }
        });

        getSupportActionBar().setTitle("Editar Estudiante");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void saveChanges(final String newName, final String newSurname, final String idTeacher, final String idClassroom, final String idStudent, final String token) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(EditStudentActivity.this);
        alertDialog.setTitle("Confirmar guardar cambios");
        alertDialog.setMessage("¿Está seguro de que quiere guardar los cambios en este estudiante?");

        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                presenter.onClickEditStudent(newName, newSurname, idTeacher, idClassroom, idStudent, token);
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
