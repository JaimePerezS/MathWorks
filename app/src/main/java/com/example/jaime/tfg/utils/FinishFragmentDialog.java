package com.example.jaime.tfg.utils;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.local.StudentSessionManager;

import static com.example.jaime.tfg.utils.AvatarResources.avatarResourcesList;

public class FinishFragmentDialog extends DialogFragment {

    private static final String POINTS = "points";

    private TextView txtViewMessage;
    private ImageView imgAvatar;

    private Button btnExit;

    private StudentSessionManager session;

    private int points;

    public interface CallBackCheckFragmentDialog {
        void onClickBtnExit();
    }

    public FinishFragmentDialog() {

    }

    public static FinishFragmentDialog newInstance(int points) {
        FinishFragmentDialog dialog = new FinishFragmentDialog();

        Bundle bundle = new Bundle();
        bundle.putInt(POINTS, points);

        dialog.setArguments(bundle);

        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setCancelable(false);

        return inflater.inflate(R.layout.fragment_dialog_finish, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgAvatar = view.findViewById(R.id.imgAvatar);
        txtViewMessage = view.findViewById(R.id.txtViewBocadillo);

        btnExit = view.findViewById(R.id.btnSalir);

        Bundle bundle = getArguments();

        points = bundle.getInt(POINTS);

        session = new StudentSessionManager(getActivity().getApplicationContext());

        imgAvatar.setImageResource(avatarResourcesList.get(Integer.parseInt(session.getStudentDetails().getIdAvatar())));
        txtViewMessage.setText("Has conseguido " + String.valueOf(points) + " puntos.");

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                CallBackCheckFragmentDialog callback = (CallBackCheckFragmentDialog) getActivity();
                callback.onClickBtnExit();
            }
        });
    }
}
