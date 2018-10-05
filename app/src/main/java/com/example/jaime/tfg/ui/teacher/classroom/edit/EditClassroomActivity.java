package com.example.jaime.tfg.ui.teacher.classroom.edit;

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

public class EditClassroomActivity extends BaseActivity implements EditClasroomView {

    private static final String TAG = EditClassroomActivity.class.getSimpleName();

    private static final String ID_CLASSROOM = "idClassroom";
    private static final String NAME = "name";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private EditText edTxtNombreEditarClase;
    private Button btnGuardarCambiosEditarClase;

    private EditClassroomPresenter presenter;

    public static Intent getCallingIntent(Context context, String idClassroom, String name, String idTeacher, String idUuid) {
        Intent intent = new Intent(context, EditClassroomActivity.class);

        intent.putExtra(ID_CLASSROOM, idClassroom);
        intent.putExtra(NAME, name);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_clase);

        presenter = new EditClassroomPresenterImp(this);

        edTxtNombreEditarClase = findViewById(R.id.edTxtEditarClase);
        btnGuardarCambiosEditarClase = findViewById(R.id.btnGuardarCambiosEditarClase);

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString(NAME);
        setParameters(name);

        final String idClassroom = bundle.getString(ID_CLASSROOM);
        final String idTeacher = bundle.getString(ID_TEACHER);
        final String idUuid = bundle.getString(ID_UUID);

        btnGuardarCambiosEditarClase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = edTxtNombreEditarClase.getText().toString();
                saveChanges(newName, idClassroom, idTeacher, idUuid);
            }
        });

        getSupportActionBar().setTitle(R.string.alertDialog_editar_clase);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setParameters(String name){
        edTxtNombreEditarClase.setText(name);
    }

    private void saveChanges(final String newName, final String idClassroom, final String idTeacher, final String idUuid) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(EditClassroomActivity.this);
        alertDialog.setTitle(R.string.alertDialog_confirmar_cambios_clase);
        alertDialog.setMessage(R.string.alertDialog_guardar_cambios_clase);
        alertDialog.setPositiveButton(R.string.alertDialog_si, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {

                presenter.onUpdateClassroomClick(newName, idTeacher, idClassroom, idUuid);
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
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
