package com.example.jaime.tfg.ui.student.shop;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.local.StudentSessionManager;
import com.example.jaime.tfg.data.model.Avatar;
import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.ui.base.BaseActivity;

import java.util.List;

import static com.example.jaime.tfg.utils.AvatarResources.avatarResourcesList;

public class AvatarShopActivity extends BaseActivity implements AvatarShopView{
    private ImageView imgBtnNext;
    private ImageView imgBtnBack;
    private ImageView imgAvatar;

    private Button btnBuyAvatar;
    private Button btnBack;

    private TextView txtViewPoints;
    private TextView txtViewCost;

    private StudentSessionManager session;
    private Student student;

    private int i = 0;

    private List<Avatar> avatarList;

    private AvatarShopPresenterImp presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_avatar_shop);

        session = new StudentSessionManager(getApplicationContext());

        student = session.getStudentDetails();

        imgBtnNext = findViewById(R.id.imgBtnNext);
        imgBtnBack = findViewById(R.id.imgBtnBack);

        imgAvatar = findViewById(R.id.imgAvatar);

        txtViewPoints = findViewById(R.id.txtViewPuntuacion);
        txtViewCost = findViewById(R.id.txtViewCoste);

        btnBuyAvatar = findViewById(R.id.btnComprarAvatar);
        btnBack = findViewById(R.id.btnAtras);

        btnBuyAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(AvatarShopActivity.this);

                alertDialog.setTitle("Comprar avatar");
                alertDialog.setMessage("¿Estás seguro de que quieres comprar el avatar?");
                alertDialog.setPositiveButton(R.string.alertDialog_si, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        presenter.buyAvatar(student, avatarList.get(i), student.getToken());
                    }
                });

                alertDialog.setNegativeButton(R.string.alertDialog_no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alertDialog.show();

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        presenter = new AvatarShopPresenterImp(this);

        getSupportActionBar().hide();
    }

    @Override
    public void onResume() {

        super.onResume();
        presenter.getAvatar(String.valueOf(student.getId()), student.getToken());

        txtViewPoints.setText(String.valueOf(student.getPoints()));

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

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, AvatarShopActivity.class);

        return intent;
    }

    private void displayAvatar() {
        imgAvatar.setImageResource(avatarResourcesList.get(this.avatarList.get(i).getIdAvatar()));
        txtViewCost.setText(String.valueOf(avatarList.get(i).getCost()));
    }

    @Override
    public void loadAvatar(final List<Avatar> avatarList) {
        this.avatarList = avatarList;
        displayAvatar();
    }

    @Override
    public void updateAvatarPoints(int points) {
        session.updatePoints(points);
    }
}
