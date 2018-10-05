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

/**
 * Created by Jaime on 28/02/2018.
 */

public class HelpFragmentDialog extends DialogFragment{

    private static final String HELP = "HELP";

    private TextView txtViewMessage;
    private ImageView imgAvatar;

    private Button btnBack;

    private StudentSessionManager session;

    private String help;

    public HelpFragmentDialog() {

    }

    public static HelpFragmentDialog newInstance(String help) {
        HelpFragmentDialog dialog = new HelpFragmentDialog();

        Bundle bundle = new Bundle();
        bundle.putString(HELP, help);

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

        return inflater.inflate(R.layout.fragment_dialog_comprobar_tipo_operacion, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgAvatar = view.findViewById(R.id.imgAvatar);
        txtViewMessage = view.findViewById(R.id.txtViewBocadillo);

        btnBack = view.findViewById(R.id.btnVolver);

        session = new StudentSessionManager(getActivity().getApplicationContext());

        imgAvatar.setImageResource(avatarResourcesList.get(Integer.parseInt(session.getStudentDetails().getIdAvatar())));

        Bundle bundle = getArguments();

        help = bundle.getString(HELP);

        txtViewMessage.setText(help);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }
}
