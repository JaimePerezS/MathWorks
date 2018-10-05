package com.example.jaime.tfg.ui.teacher.profile.edit;

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
import com.example.jaime.tfg.data.local.TeacherSessionManager;
import com.example.jaime.tfg.data.model.Teacher;
import com.example.jaime.tfg.ui.base.BaseActivity;

public class EditTeacherProfileActivity extends BaseActivity implements EditTeacherProfileView {

    private final String TAG = EditTeacherProfileActivity.class.getSimpleName();

    private TeacherSessionManager sesion;
    private Teacher teacher;

    private EditText edTxtEditarPerfilNombre;
    private EditText edTxtEditarPerfilApellidos;
    private Button btnGuardarCambios;

    private EditTeacherProfilePresenterImp presenter;

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, EditTeacherProfileActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        sesion = new TeacherSessionManager(getApplicationContext());
        teacher = sesion.getTeacherDetails();

        presenter = new EditTeacherProfilePresenterImp(this);

        edTxtEditarPerfilNombre = findViewById(R.id.edTxtEditarPerfilNombre);
        edTxtEditarPerfilApellidos = findViewById(R.id.edTxtEditarPerfilApellidos);
        btnGuardarCambios = findViewById(R.id.btnGuardarCambiosPerfil);

        edTxtEditarPerfilNombre.setText(teacher.getName());
        edTxtEditarPerfilApellidos.setText(teacher.getSurname());

        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = edTxtEditarPerfilNombre.getText().toString();
                final String surname = edTxtEditarPerfilApellidos.getText().toString();

                saveChanges(name, surname);
            }
        });

        getSupportActionBar().setTitle("Editar Perfil");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void saveChanges(final String name, final String surname) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(EditTeacherProfileActivity.this);

        alertDialog.setTitle("Confirmar guardar cambios");
        alertDialog.setMessage("¿Está seguro de que quiere guardar los cambios de su perfil?");
        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {

                sesion.updateTeacherDetails(name, surname);
                presenter.onClickUpdateTeacher(name, surname, String.valueOf(teacher.getId()), teacher.getUuid());

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
