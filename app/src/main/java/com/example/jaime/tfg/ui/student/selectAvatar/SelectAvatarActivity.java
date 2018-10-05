package com.example.jaime.tfg.ui.student.selectAvatar;

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
import com.example.jaime.tfg.data.model.Avatar;
import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.ui.base.BaseActivity;

import java.util.List;

import static com.example.jaime.tfg.utils.AvatarResources.avatarResourcesList;

public class SelectAvatarActivity extends BaseActivity implements SelectAvatarView{
    ImageView imgBtnNext;
    ImageView imgBtnBack;
    ImageView imgAvatar;

    StudentSessionManager session;
    Student student;

    SelectAvatarPresenterImp presenter;

    Button btnSaveAvatar;
    Button btnBack;

    int i = 0;

    List<Avatar> avatarList;

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, SelectAvatarActivity.class);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_select_avatar);

        session = new StudentSessionManager(getApplicationContext());
        student = session.getStudentDetails();

        imgBtnNext = findViewById(R.id.imgBtnNext);
        imgBtnBack = findViewById(R.id.imgBtnBack);

        imgAvatar = findViewById(R.id.imgAvatar);

        btnSaveAvatar = findViewById(R.id.btnGuardarAvatar);
        btnBack = findViewById(R.id.btnAtras);

        btnSaveAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.updateAvatar(String.valueOf(avatarList.get(i).getIdAvatar()));
                presenter.updateAvatar(String.valueOf(student.getId()), String.valueOf(avatarList.get(i).getIdAvatar()), student.getToken());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        presenter = new SelectAvatarPresenterImp(this);

        getSupportActionBar().hide();
    }

    @Override
    protected void onResume() {

        super.onResume();

        presenter.getAvatar(String.valueOf(student.getId()), student.getToken());

        imgBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                i = i % avatarList.size();
                displayAvatar();
            }
        });

        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                i = i % avatarList.size();

                if(i < 0) {
                    i = avatarList.size() - 1;
                }

                displayAvatar();
            }
        });
    }

    private void displayAvatar() {
        imgAvatar.setImageResource(avatarResourcesList.get(this.avatarList.get(i).getIdAvatar()));
    }

    @Override
    public void loadAvatar(List<Avatar> avatarList) {
        this.avatarList = avatarList;

        displayAvatar();
    }
}
