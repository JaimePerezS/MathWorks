package com.example.jaime.tfg.ui.student.firstAvatarSelection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.local.StudentSessionManager;
import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.ui.base.BaseActivity;

import static com.example.jaime.tfg.utils.AvatarResources.avatarResourcesList;


public class FirstSelectAvatarActivity extends BaseActivity implements FirstSelectAvatarView {
    ImageView imgBtnNext;
    ImageView imgBtnBack;
    ImageView imgAvatar;

    Button btnSaveAvatar;
    Button btnBack;

    int i = 0;

    int [] avatares_iniciales = {1,8,10};

    FirstSelectAvatarPresenterImp presenter;

    StudentSessionManager session;
    Student student;

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, FirstSelectAvatarActivity.class);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_select_avatar);

        presenter = new FirstSelectAvatarPresenterImp(this);
        session = new StudentSessionManager(getApplicationContext());

        student = session.getStudentDetails();

        imgBtnNext = findViewById(R.id.imgBtnNext);
        imgBtnBack = findViewById(R.id.imgBtnBack);

        imgAvatar = findViewById(R.id.imgAvatar);

        btnSaveAvatar = findViewById(R.id.btnGuardarAvatar);
        btnBack = findViewById(R.id.btnAtras);

        btnBack.setVisibility(View.INVISIBLE);

        imgAvatar.setImageResource(avatarResourcesList.get(avatares_iniciales[i]));

        imgBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                i = i % avatares_iniciales.length;

                imgAvatar.setImageResource(avatarResourcesList.get(avatares_iniciales[i]));
            }
        });

        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                i = i % avatares_iniciales.length;

                if(i < 0) {
                    i = avatares_iniciales.length - 1;
                }

                imgAvatar.setImageResource(avatarResourcesList.get(avatares_iniciales[i]));
            }
        });

        btnSaveAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.updateAvatar(String.valueOf(avatares_iniciales[i]));
                presenter.updateAvatar(String.valueOf(avatares_iniciales[i]), String.valueOf(student.getId()), student.getToken());
                presenter.buyAvatar(String.valueOf(student.getId()), String.valueOf(avatares_iniciales[i]), student.getToken());
                finish();
            }
        });

        getSupportActionBar().hide();
    }
}
