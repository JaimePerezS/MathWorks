package com.example.jaime.tfg.ui.teacher.problemsgroup.availability;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Classroom;
import com.example.jaime.tfg.ui.base.BaseActivity;

public class ProblemsGroupAvailabilityActivity extends BaseActivity implements SelectClassroomFragment.OnClassroomClickListener {

    private static final String TAG = ProblemsGroupAvailabilityActivity.class.getSimpleName();

    private static final String ID_PROBLEMS_GROUP = "idProblemsGroup";
    private static final String PROBLEMS_GROUP_NAME = "name";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private String idTeacher;
    private String name;
    private String idUuid;
    private String idProblemsGroup;

    public static Intent getCallingIntent(Context context, String idProblemsGroup, String name, String idTeacher, String idUuid) {
        Intent callingIntent = new Intent(context, ProblemsGroupAvailabilityActivity.class);

        callingIntent.putExtra(ID_PROBLEMS_GROUP, idProblemsGroup);
        callingIntent.putExtra(PROBLEMS_GROUP_NAME, name);
        callingIntent.putExtra(ID_TEACHER, idTeacher);
        callingIntent.putExtra(ID_UUID, idUuid);

        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_group_availability);

        Bundle bundle = getIntent().getExtras();

        idTeacher = bundle.getString(ID_TEACHER);
        idUuid = bundle.getString(ID_UUID);
        name = bundle.getString(PROBLEMS_GROUP_NAME);
        idProblemsGroup = bundle.getString(ID_PROBLEMS_GROUP);

        addFragment(R.id.leftFrameLayout, SelectClassroomFragment.newInstance(idTeacher, idUuid));

        getSupportActionBar().setTitle("Selecciona una clase");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClassroomClick(Classroom classroom) {
        getSupportActionBar().setTitle("Alumnos de la clase" + " " + classroom.getName() + " " + "que pueden acceder a" + " " + name);
        addFragment(R.id.rightFrameLayout, StudentsFragment.newInstance(idTeacher, idProblemsGroup, String.valueOf(classroom.getId()), classroom.getName(), name, idUuid));
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
