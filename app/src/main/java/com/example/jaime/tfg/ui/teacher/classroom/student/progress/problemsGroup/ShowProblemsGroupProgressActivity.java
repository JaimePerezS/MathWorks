package com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.ProblemsGroupRecord;
import com.example.jaime.tfg.ui.base.BaseActivity;

public class ShowProblemsGroupProgressActivity extends BaseActivity implements ShowProblemsGroupRecordTeacherFragment.OnFragmentInteractionListener{

    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_CLASSROOM = "idClassroom";
    private static final String ID_STUDENT = "idStudent";
    private static final String NAME = "studentName";
    private static final String ID_UUID = "token";

    private String idTeacher, idClassroom, idStudent, studentName, token;

    public static Intent getCallingIntent(Context context, String idTeacher, String idClassroom, String idStudent, String studentName, String token) {
        Intent intent = new Intent(context, ShowProblemsGroupProgressActivity.class);

        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_CLASSROOM, idClassroom);
        intent.putExtra(ID_STUDENT, idStudent);
        intent.putExtra(NAME, studentName);
        intent.putExtra(ID_UUID, token);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_problems_group_progress);

        Bundle bundle = getIntent().getExtras();

        idTeacher = bundle.getString(ID_TEACHER);
        idClassroom = bundle.getString(ID_CLASSROOM);
        idStudent = bundle.getString(ID_STUDENT);
        studentName = bundle.getString(NAME);
        token = bundle.getString(ID_UUID);

        addFragment(R.id.leftFrameLayout, ShowProblemsGroupRecordTeacherFragment.newInstance(idTeacher, idClassroom, idStudent, token));

        getSupportActionBar().setTitle("Progresos de " + studentName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    public void onProblemsGroupRecordClick(ProblemsGroupRecord problemsGroupRecord) {
        addFragment(R.id.rigthFrameLayout, ShowProblemsRecordTeacherFragment.newInstance(idTeacher, idClassroom, idStudent, problemsGroupRecord.getIdProblemsGroup(), String.valueOf(problemsGroupRecord.getId()), token));
    }
}
