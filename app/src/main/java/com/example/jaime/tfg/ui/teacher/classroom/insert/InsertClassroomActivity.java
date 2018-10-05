package com.example.jaime.tfg.ui.teacher.classroom.insert;

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

public class InsertClassroomActivity extends BaseActivity implements InsertClassroomView {

    private static final String TAG = InsertClassroomActivity.class.getSimpleName();

    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private EditText edTxtNombreClase;
    private Button btnCrearClase;

    private InsertClassroomPresenter presenter;

    public static Intent getCallingIntent(Context context, String idTeacher, String idUuid) {
        Intent callingIntent = new Intent(context, InsertClassroomActivity.class);

        callingIntent.putExtra(ID_TEACHER, idTeacher);
        callingIntent.putExtra(ID_UUID, idUuid);

        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_clase);

        edTxtNombreClase = findViewById(R.id.edTxtInsertarNombreClase);
        btnCrearClase = findViewById(R.id.btnCrearClase);

        presenter = new InsertClassroomPresenterImp(this);

        Bundle bundle = getIntent().getExtras();

        final String idTeacher = bundle.getString(ID_TEACHER);
        final String idUuid = bundle.getString(ID_UUID);

        btnCrearClase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edTxtNombreClase.getText().toString();
                insertClassroom(name, idTeacher, idUuid);
            }
        });

        getSupportActionBar().setTitle(R.string.alertDialog_añadir_clase);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void insertClassroom(final String name, final String idTeacher, final String idUuid) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(InsertClassroomActivity.this);

        alertDialog.setTitle("Confirmar creación de" + " " + name);
        alertDialog.setMessage( "¿Estás seguro de que deseas crear la clase" + " " + name + "?");
        alertDialog.setPositiveButton(R.string.alertDialog_si, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                presenter.onClickInsertClassroom(name, idTeacher, idUuid);
            }
        });

        alertDialog.setNegativeButton(R.string.alertDialog_no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
