package com.example.jaime.tfg.ui.teacher;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.local.TeacherSessionManager;
import com.example.jaime.tfg.data.model.Teacher;
import com.example.jaime.tfg.ui.base.BaseActivity;
import com.example.jaime.tfg.ui.teacher.classroom.ShowClassroomsFragment;
import com.example.jaime.tfg.ui.teacher.operationsgroup.ShowOperationsGroupsFragment;
import com.example.jaime.tfg.ui.teacher.problemsgroup.ShowProblemsGroupsFragment;
import com.example.jaime.tfg.ui.teacher.profile.ShowTeacherProfileFragment;

public class MainTeacherActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TeacherSessionManager session;
    private Teacher teacher;

    private TextView name;
    private TextView email;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainTeacherActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header=navigationView.getHeaderView(0);

        session = new TeacherSessionManager(getApplicationContext());
        teacher = session.getTeacherDetails();

        name = header.findViewById(R.id.txtViewNombre);
        email = header.findViewById(R.id.txtViewCorreo);

        name.setText(teacher.getName() + " " + teacher.getSurname());
        email.setText(teacher.getEmail());


        if(savedInstanceState == null) {
            navigationView.getMenu().getItem(0).setChecked(true);

            ShowClassroomsFragment fClases = ShowClassroomsFragment.newInstance(String.valueOf(teacher.getId()), teacher.getUuid());
            addFragment(R.id.contentProfesor, fClases);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profesor_principal, menu);
        return true;
    }
    */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_clases) {

            ShowClassroomsFragment fClases = ShowClassroomsFragment.newInstance(String.valueOf(teacher.getId()), teacher.getUuid());
            addFragment(R.id.contentProfesor, fClases);

        } else if (id == R.id.nav_operaciones) {

            ShowOperationsGroupsFragment fOperaciones = new ShowOperationsGroupsFragment().newInstance(String.valueOf(teacher.getId()), teacher.getUuid());
            addFragment(R.id.contentProfesor, fOperaciones);

        } else if (id == R.id.nav_problemas) {

            ShowProblemsGroupsFragment fGruposProblemas = ShowProblemsGroupsFragment.newInstance(String.valueOf(teacher.getId()), teacher.getUuid());
            addFragment(R.id.contentProfesor, fGruposProblemas);

        } else if (id == R.id.nav_perfil) {

            ShowTeacherProfileFragment fPerfil = new ShowTeacherProfileFragment().newInstance();
            addFragment(R.id.contentProfesor, fPerfil);

        } else if (id == R.id.nav_cerrar) {

            showLogOutDialoge();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showLogOutDialoge() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainTeacherActivity.this);

        alertDialog.setTitle("Confirmar cierre de sesion");
        alertDialog.setMessage("¿Está seguro de que quiere cerrar la sesión?");

        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                // Write your code here to invoke YES event
                session.logOut();
                finish();
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event
                dialog.cancel();
            }
        });
        alertDialog.show();

    }

    @Override
    public void onResume() {
        super.onResume();

        teacher = session.getTeacherDetails();

        name.setText(teacher.getName() + " " + teacher.getSurname());
        email.setText(teacher.getEmail());
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

}
