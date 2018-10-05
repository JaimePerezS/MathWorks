package com.example.jaime.tfg.ui.teacher.profile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.local.TeacherSessionManager;
import com.example.jaime.tfg.data.model.Teacher;
import com.example.jaime.tfg.ui.base.BaseFragment;
import com.example.jaime.tfg.ui.teacher.MainTeacherActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowTeacherProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowTeacherProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowTeacherProfileFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private TeacherSessionManager sesion;
    private Teacher teacher;

    // TODO: Rename and change types of parameters

    private TextView txtViewnombre;
    private TextView txtViewapellidos;
    private TextView txtViewcorreoElectronico;

    private FloatingActionButton btnEditarPerfil;

    private OnFragmentInteractionListener mListener;

    public ShowTeacherProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.

     * @return A new instance of fragment ShowTeacherProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowTeacherProfileFragment newInstance() {
        ShowTeacherProfileFragment fragment = new ShowTeacherProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        sesion = new TeacherSessionManager(getActivity().getApplicationContext());
        teacher = sesion.getTeacherDetails();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_mostrar_perfil_profesor, container, false);

        txtViewnombre = rootView.findViewById(R.id.txtViewPerfilNombre2);
        txtViewapellidos = rootView.findViewById(R.id.txtViewPerfilApellidos2);
        txtViewcorreoElectronico = rootView.findViewById(R.id.txtViewPerfilCorreo2);
        btnEditarPerfil = rootView.findViewById(R.id.fActionButtonEditar);

        txtViewnombre.setText(" " + teacher.getName());
        txtViewapellidos.setText(" " + teacher.getSurname());
        txtViewcorreoElectronico.setText(" " + teacher.getEmail());

        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigateToEditProfile(getActivity().getApplicationContext());
            }
        });


        ((MainTeacherActivity) getActivity())
                .setActionBarTitle("Mi Perfil");

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
    public void onResume() {
        super.onResume();

        teacher = sesion.getTeacherDetails();
        txtViewnombre.setText(" " + teacher.getName());
        txtViewapellidos.setText(" " + teacher.getSurname());
        txtViewcorreoElectronico.setText(" " + teacher.getEmail());
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
