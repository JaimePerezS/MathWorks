package com.example.jaime.tfg.ui.student;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.local.StudentSessionManager;
import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.ui.base.BaseActivity;

import static com.example.jaime.tfg.utils.AvatarResources.avatarResourcesList;
import static com.example.jaime.tfg.utils.AvatarResources.avatarStrings;

public class MainStudentActivity extends BaseActivity implements MainStudentView{

    private StudentSessionManager session;
    private Student student;

    private Button btnHacerOperaciones;
    private Button btnHacerProblemas;
    private Button btnProgresos;
    private Button btnTienda;
    private Button btnCambiarAvatar;
    private Button btnSalir;

    private TextView txtViewNameSurname;
    private TextView txtViewPoints;

    private ImageView imgAvatar;

    private ImageView imgBubble;
    private TextView txtViewBubble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main_student);

        session = new StudentSessionManager(getApplicationContext());

        btnHacerOperaciones = findViewById(R.id.btnHacerOperaciones);
        btnHacerProblemas = findViewById(R.id.btnHacerProblemas);
        btnCambiarAvatar = findViewById(R.id.btnCambiarAvatar);
        btnProgresos = findViewById(R.id.btnProgresos);
        btnTienda = findViewById(R.id.btnTienda);
        btnSalir = findViewById(R.id.btnSalir);

        txtViewNameSurname = findViewById(R.id.txtViewNombreApellidosAlumno);
        txtViewPoints = findViewById(R.id.txtViewPuntuacion);

        imgAvatar = findViewById(R.id.imgAvatar);

        imgBubble = findViewById(R.id.imgBocadillo);
        txtViewBubble = findViewById(R.id.txtViewBocadillo);

        student = session.getStudentDetails();

        txtViewNameSurname.setText(student.getName() + " " + student.getSurname());
        txtViewPoints.setText(String.valueOf(session.getStudentDetails().getPoints()));

        btnHacerOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateToSelectOperationsGroups(getApplicationContext(), String.valueOf(student.getId()), student.getToken());
            }
        });

        btnHacerProblemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateToSelectProblemsGroups(getApplicationContext(), String.valueOf(student.getId()), student.getToken());
            }
        });

        btnCambiarAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateToChangeAvatar(getApplicationContext());
            }
        });

        btnProgresos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateToChooseRecord(getApplicationContext(), String.valueOf(student.getId()), student.getToken());
            }
        });

        btnTienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateToShop(getApplicationContext());
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogOutDialoge();
            }
        });

        getSupportActionBar().hide();

        int random = (int) (Math.random() * 1);

        if(student.getPoints() <= 200) {
            txtViewBubble.setText(avatarStrings.get(random));
        }
        else {
            txtViewBubble.setText(avatarStrings.get(2));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtViewPoints.setText(String.valueOf(session.getStudentDetails().getPoints()));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        txtViewPoints.setText(String.valueOf(session.getStudentDetails().getPoints()));
    }

    @Override
    public void onResume() {
        super.onResume();
        checkStudentAvatar();

        txtViewPoints.setText(String.valueOf(session.getStudentDetails().getPoints()));

        int random = (int) (Math.random() * 1);

        if(student.getPoints() <= 200) {
            txtViewBubble.setText(avatarStrings.get(random));
        }
        else {
            txtViewBubble.setText(avatarStrings.get(2));
        }
    }

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainStudentActivity.class);
    }

    private void showLogOutDialoge() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainStudentActivity.this);

        alertDialog.setTitle("");
        alertDialog.setMessage("¿Estás seguro de que quieres salir?");

        alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
            session.logOut();
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();

    }

    private void checkStudentAvatar() {
        student = session.getStudentDetails();
        if(student.getIdAvatar().equals("0")) {
            navigator.navigateToSelectAvatar(getApplicationContext());
        }
        else {
            imgAvatar.setImageResource(avatarResourcesList.get(Integer.parseInt(student.getIdAvatar())));
        }
    }
}
