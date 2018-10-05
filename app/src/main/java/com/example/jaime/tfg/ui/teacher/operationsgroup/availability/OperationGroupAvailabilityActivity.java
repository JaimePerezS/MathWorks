package com.example.jaime.tfg.ui.teacher.operationsgroup.availability;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Classroom;
import com.example.jaime.tfg.ui.base.BaseActivity;

public class OperationGroupAvailabilityActivity extends BaseActivity implements SelectClassroomFragment.OnClassroomClickListener {

    private static final String TAG = OperationGroupAvailabilityActivity.class.getSimpleName();

    private static final String ID_OPERATIONS_GROUP = "idOperationsGroup";
    private static final String OPERATIONS_GROUP_NAME = "name";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private String idTeacher;
    private String name;
    private String idUuid;
    private String idOperationsGroup;

    public static Intent getCallingIntent(Context context, String idOperationsGroup, String name, String idTeacher, String idUuid) {
        Intent callingIntent = new Intent(context, OperationGroupAvailabilityActivity.class);

        callingIntent.putExtra(ID_OPERATIONS_GROUP, idOperationsGroup);
        callingIntent.putExtra(OPERATIONS_GROUP_NAME, name);
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
        name = bundle.getString(OPERATIONS_GROUP_NAME);
        idOperationsGroup = bundle.getString(ID_OPERATIONS_GROUP);

        addFragment(R.id.leftFrameLayout, SelectClassroomFragment.newInstance(idTeacher, idUuid));

        getSupportActionBar().setTitle("Selecciona una clase");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClassroomClick(Classroom classroom) {
        getSupportActionBar().setTitle("Alumnos de la clase" + " " + classroom.getName() + " " + "que pueden acceder a" + " " + name);
        addFragment(R.id.rightFrameLayout, StudentsFragment.newInstance(idTeacher, idOperationsGroup, String.valueOf(classroom.getId()), classroom.getName(), name, idUuid));
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
