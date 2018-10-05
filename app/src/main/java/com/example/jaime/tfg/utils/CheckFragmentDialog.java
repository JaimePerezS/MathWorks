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
 * Created by Jaime on 27/02/2018.
 */

public class CheckFragmentDialog extends DialogFragment{

    private static final String RESULT = "result";

    private TextView txtViewMessage;
    private ImageView imgAvatar;

    private Button btnBack;
    private Button btnNext;

    private boolean result;

    private StudentSessionManager session;

    public interface CallBackCheckFragmentDialog {
        void onClickBtnNext();
    }

    public CheckFragmentDialog() {

    }

    public static CheckFragmentDialog newInstance(boolean result) {
        CheckFragmentDialog dialog = new CheckFragmentDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean(RESULT, result);

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

        return inflater.inflate(R.layout.fragment_dialog_comprobar, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgAvatar = view.findViewById(R.id.imgAvatar);
        txtViewMessage = view.findViewById(R.id.txtViewBocadillo);

        btnBack = view.findViewById(R.id.btnVolver);
        btnNext = view.findViewById(R.id.btnSiguiente);

        Bundle bundle = getArguments();

        result = bundle.getBoolean(RESULT);

        session = new StudentSessionManager(getActivity().getApplicationContext());

        imgAvatar.setImageResource(avatarResourcesList.get(Integer.parseInt(session.getStudentDetails().getIdAvatar())));

        if(result) {
                txtViewMessage.setText("¡Respuesta correcta!" + "\n\n" + "¡Sigue así!");
                btnNext.setVisibility(View.VISIBLE);
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dismiss();
                        CallBackCheckFragmentDialog callback = (CallBackCheckFragmentDialog) getActivity();
                        callback.onClickBtnNext();
                    }
                });
        } else {
                txtViewMessage.setText("Parece que te has equivocado." + "\n" + "¡Vuelve a intentarlo!");
                btnBack.setVisibility(View.VISIBLE);
                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dismiss();
                    }
                });
            }
    }
}
