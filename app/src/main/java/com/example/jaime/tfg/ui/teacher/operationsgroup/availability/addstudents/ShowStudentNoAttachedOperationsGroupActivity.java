package com.example.jaime.tfg.ui.teacher.operationsgroup.availability.addstudents;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.ui.base.BaseActivity;

import java.util.List;

public class ShowStudentNoAttachedOperationsGroupActivity extends BaseActivity implements ShowStudentNoAttachedOperationsGroupView {

    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_CLASSROOM = "idClassroom";
    private static final String ID_OPERATIONS_GROUP = "idOperationsGroup";
    private static final String CLASSROOM_NAME = "classroomName";
    private static final String OPERATIONS_GROUP_NAME = "operationsGroupName";
    private static final String TOKEN = "idUuid";

    private RecyclerView listStudents;
    private RecyclerView.LayoutManager lManager;
    private StudentNoAttachedAdapter listStudentsAdapter;

    private ShowStudentNoAttachedOperationsGroupPresenterImp presenter;

    private String idTeacher;
    private String idClassroom;
    private String idOperationsGroup;
    private String classroomName;
    private String operationsGroupName;
    private String token;

    public static Intent getCallingIntent(Context context, String idTeacher, String idClasroom, String idOperationsGroup, String classroomName, String operationsGroupName, String token) {
        Intent callingIntent = new Intent(context, ShowStudentNoAttachedOperationsGroupActivity.class);

        callingIntent.putExtra(ID_TEACHER, idTeacher);
        callingIntent.putExtra(ID_CLASSROOM, idClasroom);
        callingIntent.putExtra(ID_OPERATIONS_GROUP, idOperationsGroup);
        callingIntent.putExtra(CLASSROOM_NAME, classroomName);
        callingIntent.putExtra(OPERATIONS_GROUP_NAME, operationsGroupName);
        callingIntent.putExtra(TOKEN, token);

        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student_no_attached_operations_group);

        listStudents = findViewById(R.id.listAlumnosNoAsignados);
        listStudents.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        listStudents.setLayoutManager(lManager);

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        listStudents.addItemDecoration(decoration);

        presenter = new ShowStudentNoAttachedOperationsGroupPresenterImp(this);

        Bundle bundle = getIntent().getExtras();

        idTeacher = bundle.getString(ID_TEACHER);
        idClassroom = bundle.getString(ID_CLASSROOM);
        idOperationsGroup = bundle.getString(ID_OPERATIONS_GROUP);
        classroomName = bundle.getString(CLASSROOM_NAME);
        operationsGroupName = bundle.getString(OPERATIONS_GROUP_NAME);
        token = bundle.getString(TOKEN);

        presenter.getStudentsNoAttachedOperationsGroup(idTeacher, idClassroom, idOperationsGroup, token);

        getSupportActionBar().setTitle("Hacer visible " + operationsGroupName + " a los alumnos de " + classroomName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void onResume() {
        super.onResume();
    }


    @Override
    public void showStudentsNoAttached(List<Student> students) {
        listStudentsAdapter = new StudentNoAttachedAdapter(students, this, new StudentNoAttachedAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(final Student student) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ShowStudentNoAttachedOperationsGroupActivity.this);

                alertDialog.setTitle("");
                alertDialog.setMessage("¿Estás seguro de que quieres hacer visible el grupo de operaciones " + operationsGroupName + " al alumno " + student.getName() + " "+ student.getSurname() + "?");

                alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        presenter.addVisibility(idTeacher, idOperationsGroup, idClassroom, String.valueOf(student.getId()), token);
                        presenter.getStudentsNoAttachedOperationsGroup(idTeacher, idClassroom, idOperationsGroup, token);
                    }
                });
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });

        listStudents.hasFixedSize();

        listStudents.setAdapter(listStudentsAdapter);
    }

    @Override
    public void clearRecycler() {
        listStudents.setAdapter(null);
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
