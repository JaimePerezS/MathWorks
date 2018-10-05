package com.example.jaime.tfg.ui.main.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.ui.base.BaseFragment;

import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SignInFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SignInFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignInFragment extends BaseFragment implements View.OnClickListener, SignInView {

    private static final String TAG = SignInFragment.class.getSimpleName();

    private View rootView;

    private TextInputLayout inputName;
    private TextInputLayout inputSurname;
    private TextInputLayout inputEmail;
    private TextInputLayout inputPass1;
    private TextInputLayout inputPass2;
    private Button btnRegistrar;

    private OnFragmentInteractionListener mListener;

    private SignInPresenterImp presenter;

    public SignInFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SignInFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignInFragment newInstance() {
        SignInFragment fragment = new SignInFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_registro, container, false);

        inputName = rootView.findViewById(R.id.inputNombre);
        inputSurname = rootView.findViewById(R.id.inputApellido);
        inputEmail = rootView.findViewById(R.id.inputCorreo);
        inputPass1 = rootView.findViewById(R.id.inputContraseña1);
        inputPass2 = rootView.findViewById(R.id.inputContraseña2);

        btnRegistrar = rootView.findViewById(R.id.btnRegistrar);

        presenter = new SignInPresenterImp(this);

        btnRegistrar.setOnClickListener(this);
        // Inflate the layout for this fragment
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        final String name = inputName.getEditText().getText().toString();
        final String surname = inputSurname.getEditText().getText().toString();
        final String email = inputEmail.getEditText().getText().toString();
        final String password = inputPass1.getEditText().getText().toString();

        if(isDataValid() && arePassEquals()) {
            presenter.sigIn(name, surname, email, password);
        }
    }

    private boolean isDataValid(){

        boolean dataValid = true;

        if(inputName.getEditText().getText().length() == 0) {
            inputName.setError("Introduce tu nombre");
            dataValid = false;
        } else if (!(Pattern.matches("^[\\p{L} .'-]+$", inputName.getEditText().getText()))) {
            inputName.setError("Introduce un nombre válido.");
            dataValid = false;
        } else {
            inputName.setError(null);
        }

        if(inputSurname.getEditText().getText().length() == 0) {
            inputSurname.setError("Introduce tus apellidos");
            dataValid = false;
        } else if (!(Pattern.matches("^[\\p{L} .'-]+$", inputSurname.getEditText().getText()))) {
            inputSurname.setError("Introduce unos apellidos válidos.");
            dataValid = true;
        } else {
            inputSurname.setError(null);
        }

        if(inputEmail.getEditText().getText().length() == 0) {
            inputEmail.setError("Introduce un correo electrónico");
            dataValid = false;
        } else {
            inputEmail.setError(null);
        }

        if(inputPass1.getEditText().getText().length() == 0) {
            inputPass1.setError("Introduce una contraseña");
            dataValid = false;
        } else {
            inputPass1.setError(null);
        }

        if(inputPass2.getEditText().getText().length() == 0) {
            inputPass2.setError("Repite la contraseña");
            dataValid = false;
        } else {
            inputPass2.setError(null);
        }

        return dataValid;
    }

    private boolean arePassEquals() {
        boolean passEquals = true;

        if(!inputPass1.getEditText().getText().toString().equals(inputPass2.getEditText().getText().toString())) {
            inputPass1.setError("Las contraseñas no coinciden");
            passEquals = false;
        }

        return passEquals;
    }

    @Override
    public void navigateToMainTeacher() {
        navigator.navigateToMainTeachers(getActivity().getApplicationContext());
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
