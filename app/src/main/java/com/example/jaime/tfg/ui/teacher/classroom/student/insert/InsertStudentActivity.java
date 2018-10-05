package com.example.jaime.tfg.ui.teacher.classroom.student.insert;

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

public class InsertStudentActivity extends BaseActivity implements InsertStudentView {

    private static final String TAG = InsertStudentActivity.class.getSimpleName();

    private static final String ID_CLASSROOM = "idClassroom";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private EditText edTxtNombreAlumno;
    private EditText edTxtApellidos;

    private Button btnInsertarAlumno;

    private InsertStudentPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idClassroom, String idTeacher, String idUuid) {
        Intent intent = new Intent(context, InsertStudentActivity.class);

        intent.putExtra(ID_CLASSROOM, idClassroom);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_alumno);

        edTxtNombreAlumno = findViewById(R.id.edTxtNombreAlumno);
        edTxtApellidos = findViewById(R.id.edTxtApellidosAlumno);

        Bundle bundle = getIntent().getExtras();

        final String idTeacher = bundle.getString(ID_TEACHER);
        final String idClassroom = bundle.getString(ID_CLASSROOM);
        final String token = bundle.getString(ID_UUID);

        presenter = new InsertStudentPresenterImp(this);

        btnInsertarAlumno = findViewById(R.id.btnInsertarAlumno);

        btnInsertarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edTxtNombreAlumno.getText().toString();
                String surname = edTxtApellidos.getText().toString();
                insertStudent(name, surname, idTeacher, idClassroom, token);
            }
        });

        getSupportActionBar().setTitle("Añadir Alumno");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void insertStudent(final String name, final String surname, final String idTeacher, final String idClassroom, final String token) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(InsertStudentActivity.this);
        alertDialog.setTitle("Confirmar creación del estudiante " + name + " " + surname);
        alertDialog.setMessage("¿Está seguro de que quiere añadir el estudiante " + name + " " + surname + "?");
        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                presenter.onClickInsertStudent(name, surname, idTeacher, idClassroom, token);
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
