package com.example.jaime.tfg.ui.teacher.operationsgroup.availability;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Student;
import com.example.jaime.tfg.ui.base.BaseFragment;

import java.util.List;


public class StudentsFragment extends BaseFragment implements StudentsView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String TAG = StudentsFragment.class.getSimpleName();

    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_OPERATIONS_GROUP = "idOperationsGroup";
    private static final String ID_CLASSROOM = "idClassroom";
    private static final String CLASSROOM_NAME = "classroomName";
    private static final String OPERATIONS_GROUP_NAME = "operationsGroupName";
    private static final String ID_UUID = "idUuid";

    // TODO: Rename and change types of parameters
    private String idTeacher;
    private String idOperationsGroup;
    private String idClassroom;
    private String classroomName;
    private String operationsGroupName;
    private String token;

    private OnFragmentInteractionListener mListener;

    private View rootView;
    private RecyclerView listStudents;
    private RecyclerView.LayoutManager lManager;
    private StudentAdapter listStudentsAdapter;

    private FloatingActionButton btnAddStudent;

    private StudentsPresenterImp presenter;

    public StudentsFragment() {
        // Required empty public constructor
    }

    public static StudentsFragment newInstance(String idTeacher, String idOperationsGroup, String idClassroom, String classroomName, String operationsGroupName, String token) {
        StudentsFragment fragment = new StudentsFragment();
        Bundle args = new Bundle();
        args.putString(ID_TEACHER, idTeacher);
        args.putString(ID_OPERATIONS_GROUP, idOperationsGroup);
        args.putString(ID_CLASSROOM, idClassroom);
        args.putString(CLASSROOM_NAME, classroomName);
        args.putString(OPERATIONS_GROUP_NAME, operationsGroupName);
        args.putString(ID_UUID, token);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idTeacher = getArguments().getString(ID_TEACHER);
            idOperationsGroup = getArguments().getString(ID_OPERATIONS_GROUP);
            idClassroom = getArguments().getString(ID_CLASSROOM);
            classroomName = getArguments().getString(CLASSROOM_NAME);
            operationsGroupName = getArguments().getString(OPERATIONS_GROUP_NAME);
            token = getArguments().getString(ID_UUID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_students, container, false);

        listStudents = rootView.findViewById(R.id.listAlumnos);
        listStudents.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getActivity());
        listStudents.setLayoutManager(lManager);

        DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        listStudents.addItemDecoration(decoration);

        presenter = new StudentsPresenterImp(this);

        btnAddStudent = rootView.findViewById(R.id.btnAñadirDisponibilidadAlumno);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigator.navigateToAttachStudentOperationGroup(getActivity().getApplicationContext(), idTeacher, idClassroom, idOperationsGroup, classroomName, operationsGroupName, token);
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

    @Override
    public void showStudents(List<Student> studentList) {
        listStudentsAdapter = new StudentAdapter(studentList, getActivity(), new StudentAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(final Student student) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

                alertDialog.setTitle("");
                alertDialog.setMessage("¿Estás seguro de que quieres ocultar el grupo de operaciones " + operationsGroupName + " al alumno " + student.getName() + " " + student.getSurname() + "?");

                alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        presenter.hideAvailability(idTeacher, idOperationsGroup, idClassroom, String.valueOf(student.getId()), token);
                        presenter.getStudentsAttached(idTeacher, idClassroom, idOperationsGroup, token);
                    }
                });
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });

        listStudents.setAdapter(listStudentsAdapter);
    }

    @Override
    public void clearRecycler() {
        listStudents.setAdapter(null);
    }

    @Override
    public void onResume(){
        super.onResume();

        presenter.getStudentsAttached(idTeacher, idClassroom, idOperationsGroup, token);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
