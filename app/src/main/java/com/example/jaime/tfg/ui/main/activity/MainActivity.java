package com.example.jaime.tfg.ui.main.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.local.StudentSessionManager;
import com.example.jaime.tfg.data.local.TeacherSessionManager;
import com.example.jaime.tfg.ui.base.BaseActivity;
import com.example.jaime.tfg.ui.main.fragment.LoginStudentsFragment;
import com.example.jaime.tfg.ui.main.fragment.LoginTeachersFragment;
import com.example.jaime.tfg.ui.main.fragment.SignInFragment;

public class MainActivity extends BaseActivity {

    private TeacherSessionManager sessionTeacher;
    private StudentSessionManager sessionStudent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_alumnos:
                    addFragment(R.id.content, LoginStudentsFragment.newInstance());
                    return true;
                case R.id.navigation_profesores:
                    addFragment(R.id.content, LoginTeachersFragment.newInstance());
                    return true;
                case R.id.navigation_registro:
                    addFragment(R.id.content, SignInFragment.newInstance());
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            addFragment(R.id.content, LoginStudentsFragment.newInstance());
        }

        sessionTeacher = new TeacherSessionManager(getApplicationContext());
        sessionStudent = new StudentSessionManager(getApplicationContext());

        if(sessionTeacher.isLogged()) {
            sessionTeacher.checkLogin();
        }
        else if(sessionStudent.isLogged()){
            sessionStudent.checkLogin();
        }
    }

}
