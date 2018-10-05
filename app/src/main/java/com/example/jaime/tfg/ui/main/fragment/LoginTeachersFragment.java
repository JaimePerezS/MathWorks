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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginTeachersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginTeachersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginTeachersFragment extends BaseFragment implements View.OnClickListener, LoginTeachersView{

    private static final String TAG = LoginTeachersFragment.class.getSimpleName();

    private TextInputLayout inputEmail;
    private TextInputLayout inputPass;
    private Button btnEnter;

    private OnFragmentInteractionListener mListener;

    private LoginTeachersPresenterImp presenter;

    public LoginTeachersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LoginTeachersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginTeachersFragment newInstance() {
        LoginTeachersFragment fragment = new LoginTeachersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new LoginTeachersPresenterImp(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login_profesores, container, false);

        inputEmail = rootView.findViewById(R.id.inputCorreo);
        inputPass = rootView.findViewById(R.id.inputContraseña);
        btnEnter = rootView.findViewById(R.id.btnEntrar);

        btnEnter.setOnClickListener(this);

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

        if(isDataValid()) {
            final String email = inputEmail.getEditText().getText().toString();
            final String password = inputPass.getEditText().getText().toString();

            presenter.validateCredentials(email, password);
        }
    }

    private boolean isDataValid() {

        boolean dataValid = true;

        if(inputEmail.getEditText().getText().length() == 0) {
            inputEmail.setError("Introduce tu correo electrónico");
            dataValid = false;
        } else {
            inputPass.setError(null);
        }

        if(inputPass.getEditText().getText().length() == 0) {
            inputPass.setError("Introduce tu contraseña");
            dataValid = false;
        } else {
            inputPass.setError(null);
        }

        return dataValid;
    }

    @Override
    public void navigateToMainTeacher() {
        navigator.navigateToMainTeachers(getActivity());
    }

    @Override
    public Context getContext() {
        return getActivity();
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
