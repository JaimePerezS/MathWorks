package com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.OperationsRecord;
import com.example.jaime.tfg.ui.base.BaseFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ShowOperationsRecordTeacherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowOperationsRecordTeacherFragment extends BaseFragment implements ShowOperationsRecordTeacherView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_CLASSROOM = "idClassroom";
    private static final String ID_STUDENT = "idStudent";
    private static final String ID_OPERATIONS_GROUP = "idOperationsGroup";
    private static final String ID_RECORD = "idRecord";
    private static final String ID_UUID = "token";

    // TODO: Rename and change types of parameters
    private String idTeacher, idClassroom, idStudent, idOperationsGroup, idRecord, token;

    private RecyclerView listOperationsRecordList;
    private RecyclerView.LayoutManager lManager;
    private ShowOperationsRecordTeacherAdapter adapter;

    private ShowOperationsRecordTeacherPresenter presenter;

    public ShowOperationsRecordTeacherFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ShowOperationsRecordTeacherFragment newInstance(String idTeacher, String idClassroom, String idStudent, String idOperationsGroup, String idRecord, String token) {
        ShowOperationsRecordTeacherFragment fragment = new ShowOperationsRecordTeacherFragment();
        Bundle args = new Bundle();
        args.putString(ID_TEACHER, idTeacher);
        args.putString(ID_CLASSROOM, idClassroom);
        args.putString(ID_STUDENT, idStudent);
        args.putString(ID_OPERATIONS_GROUP, idOperationsGroup);
        args.putString(ID_RECORD, idRecord);
        args.putString(ID_UUID, token);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idTeacher = getArguments().getString(ID_TEACHER);
            idClassroom = getArguments().getString(ID_CLASSROOM);
            idStudent = getArguments().getString(ID_STUDENT);
            idOperationsGroup = getArguments().getString(ID_OPERATIONS_GROUP);
            idRecord = getArguments().getString(ID_RECORD);
            token = getArguments().getString(ID_UUID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_show_operations_record_teacher, container, false);

        listOperationsRecordList = rootView.findViewById(R.id.listOperationsRecord);
        listOperationsRecordList.setHasFixedSize(true);

        DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        listOperationsRecordList.addItemDecoration(decoration);

        lManager = new LinearLayoutManager(getActivity());
        listOperationsRecordList.setLayoutManager(lManager);

        presenter = new ShowOperationsRecordTeacherPresenterImp(this);

        presenter.getOperationsRecord(idTeacher, idClassroom, idStudent, idOperationsGroup, idRecord, token);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showOperationsRecord(List<OperationsRecord> operationsRecordList) {
        adapter = new ShowOperationsRecordTeacherAdapter(operationsRecordList, getActivity());
        listOperationsRecordList.setAdapter(adapter);
    }
}
