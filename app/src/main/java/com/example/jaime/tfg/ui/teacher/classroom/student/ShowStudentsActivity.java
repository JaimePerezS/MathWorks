package com.example.jaime.tfg.ui.teacher.classroom.student;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.ui.base.BaseActivity;

import java.util.List;

public class ShowStudentsActivity extends BaseActivity implements ShowStudentsView{

    private static final String TAG = ShowStudentsActivity.class.getSimpleName();

    private static final String ID_CLASSROOM = "idClassroom";
    private static final String NAME = "name";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private RecyclerView listAlumnos;
    private RecyclerView.LayoutManager lManager;
    private StudentAdapter listAlumnosAdapater;

    private FloatingActionButton btnAñadirAlumnos;

    private String idTeacher;
    private String idClassroom;
    private String token;

    private ShowStudentsPresenterImp presenter;

    public static Intent getCallingIntent (Context context, String idClassroom, String name, String idTeacher, String idUuid) {
        Intent intent = new Intent(context, ShowStudentsActivity.class);

        intent.putExtra(ID_CLASSROOM, idClassroom);
        intent.putExtra(NAME, name);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_alumnos);

        Bundle bundle;
        bundle = getIntent().getExtras();

        idClassroom = bundle.getString(ID_CLASSROOM);
        idTeacher = bundle.getString(ID_TEACHER);
        token = bundle.getString(ID_UUID);

        presenter = new ShowStudentsPresenterImp(this);
        presenter.getStudents(idTeacher, idClassroom, token);

        listAlumnos = findViewById(R.id.listAlumnos);
        listAlumnos.setHasFixedSize(true);
        lManager = new LinearLayoutManager(this);
        listAlumnos.setLayoutManager(lManager);

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        listAlumnos.addItemDecoration(decoration);

        btnAñadirAlumnos = findViewById(R.id.btnAñadirAlumno);

        btnAñadirAlumnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigateToInsertStudent(getApplicationContext(), idClassroom, idTeacher, token);
            }
        });

        getSupportActionBar().setTitle("Alumnos de la clase " + bundle.getString(NAME));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.getStudents(idTeacher, idClassroom, token);
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

    @Override
    public void showStudents(List<Student> students) {
        listAlumnosAdapater = new StudentAdapter(students, this, new StudentAdapter.AlumnoAdapterCallBack() {

            @Override
            public void onBtnVerProgresosOperacionesClick(Student student) {
                navigator.navigateToShowOperationsProgress(getApplicationContext(), idTeacher, idClassroom, String.valueOf(student.getId()), student.getName() + " " + student.getSurname(), token);
            }

            @Override
            public void onBtnVerProgresosProblemasClick(Student student) {
                navigator.navigateToShowProblemsProgress(getApplicationContext(), idTeacher, idClassroom, String.valueOf(student.getId()), student.getName() + " " + student.getSurname(), token);
            }

            @Override
            public void onBtnEliminarClick(Context context, final Student student) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Confirmar eliminación");
                alertDialog.setMessage("¿Está seguro de que desea borrar al estudiante " + student.getName() + " " + student.getSurname() + "?");

                alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        presenter.deleteStudent(idTeacher, idClassroom, String.valueOf(student.getId()), token);
                        presenter.getStudents(idTeacher, idClassroom, token);
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
            public void onBtnEditarClick(Student student) {
                navigator.navigateToEditStudent(getApplicationContext(),idClassroom, idTeacher, token, String.valueOf(student.getId()), student.getName(), student.getSurname());
            }
        });

        listAlumnos.setAdapter(listAlumnosAdapater);
    }

    @Override
    public void clearRecycler() {
        listAlumnos.setAdapter(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycler_menu, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listAlumnosAdapater.getFilter().filter(newText);
                return true;
            }
        });
    }
}
