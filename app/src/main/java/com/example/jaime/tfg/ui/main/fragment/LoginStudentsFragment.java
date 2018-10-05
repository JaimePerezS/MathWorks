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
 * {@link LoginStudentsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginStudentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginStudentsFragment extends BaseFragment implements LoginStudentsView {

    private static final String TAG = LoginStudentsFragment.class.getSimpleName();

    private TextInputLayout inputID;
    private Button btnEnter;

    private LoginStudentsPresenterImp presenter;

    private OnFragmentInteractionListener mListener;

    public LoginStudentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LoginStudentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginStudentsFragment newInstance() {
        LoginStudentsFragment fragment = new LoginStudentsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginStudentsPresenterImp(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login_alumnos, container, false);

        inputID = rootView.findViewById(R.id.inputIdentificador);
        btnEnter = rootView.findViewById(R.id.btnEntrar);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDataValid()){
                    final String idStudent = inputID.getEditText().getText().toString();

                    presenter.validateCredentials(idStudent);
                }
            }
        });

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

    private boolean isDataValid() {
        boolean dataValid = true;

        if(inputID.getEditText().getText().length() == 0) {
            inputID.setError("Introduce tu identificador");
            dataValid = false;
        }

        return dataValid;
    }

    @Override
    public void navigateToMainStudent() {
        navigator.navigateToMainStudent(getActivity());
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
