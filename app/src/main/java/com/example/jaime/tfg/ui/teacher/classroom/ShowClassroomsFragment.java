package com.example.jaime.tfg.ui.teacher.classroom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Classroom;
import com.example.jaime.tfg.ui.base.BaseFragment;
import com.example.jaime.tfg.ui.teacher.MainTeacherActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowClassroomsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowClassroomsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowClassroomsFragment extends BaseFragment implements ShowClassroomView {

    private static final String TAG = ShowClassroomsFragment.class.getSimpleName();

    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private String idTeacher;
    private String idUuid;

    private View rootView;
    private RecyclerView listaClases;
    private RecyclerView.LayoutManager lManager;
    private ClassroomAdapter listaClasesAdapter;

    private FloatingActionButton btnAñadirClase;

    private OnFragmentInteractionListener mListener;

    private ShowClassroomPresenterImp presenter;

    public ShowClassroomsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment ShowClassroomsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowClassroomsFragment newInstance(String idTeacher, String idUuid) {
        ShowClassroomsFragment fragment = new ShowClassroomsFragment();
        Bundle args = new Bundle();
        args.putString(ID_TEACHER, idTeacher);
        args.putString(ID_UUID, idUuid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idTeacher = getArguments().getString(ID_TEACHER);
            idUuid = getArguments().getString(ID_UUID);
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_mostrar_clases, container, false);

        listaClases = rootView.findViewById(R.id.listClases);

        listaClases.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getActivity());
        listaClases.setLayoutManager(lManager);

        DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        listaClases.addItemDecoration(decoration);

        presenter = new ShowClassroomPresenterImp(this);

        btnAñadirClase = rootView.findViewById(R.id.btnAnadirClase);

        btnAñadirClase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigateToInsertClassroom(getActivity(), idTeacher, idUuid);
            }
        });

        ((MainTeacherActivity) getActivity())
                .setActionBarTitle(getString(R.string.btn_clases));

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
        presenter.getClassrooms(idTeacher, idUuid);
    }

    @Override
    public void showClassrooms(List<Classroom> classrooms) {

        listaClasesAdapter = new ClassroomAdapter(classrooms, getActivity(), new ClassroomAdapter.ClaseAdapterCallBack() {
            @Override
            public void onBtnVerAlumnosClick(Classroom classroom) {
                navigator.navigateToShowStudents(getActivity().getApplicationContext(), String.valueOf(classroom.getId()), classroom.getName(), idTeacher, idUuid);
            }

            @Override
            public void onBtnEditarClick(Classroom classroom) {
                navigator.navigateToEditClassRoom(getActivity().getApplicationContext(), String.valueOf(classroom.getId()), classroom.getName(), idTeacher, idUuid);
            }

            @Override
            public void onBtnEliminarClick(final Classroom classroom) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle( getResources().getString(R.string.alertDialog_confirmar_eliminar_clase));
                alertDialog.setMessage(getResources().getString(R.string.alertDialog_eliminar_clase) + " " + classroom.getName() + "?");

                alertDialog.setPositiveButton(R.string.alertDialog_si, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        presenter.onClickDeleteClassroom(idTeacher, String.valueOf(classroom.getId()), idUuid);
                        presenter.getClassrooms(idTeacher, idUuid);
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
        listaClases.setAdapter(listaClasesAdapter);
    }

    @Override
    public void clearRecycler() {
        listaClases.setAdapter(null);
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
