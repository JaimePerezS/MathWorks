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
import com.example.jaime.tfg.data.model.OperationsGroupRecord;
import com.example.jaime.tfg.ui.base.BaseFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowOperationsGroupRecordFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowOperationsGroupRecordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowOperationsGroupRecordFragment extends BaseFragment implements ShowOperationsGroupRecordView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_CLASSROOM = "idClassroom";
    private static final String ID_STUDENT = "idStudent";
    private static final String ID_UUID = "token";

    // TODO: Rename and change types of parameters
    private String idTeacher;
    private String idClassroom;
    private String idStudent;
    private String token;

    private RecyclerView listOperationsGroupRecordList;
    private RecyclerView.LayoutManager lManager;
    private ShowOperationsGroupRecordAdapter listOperationsGroupRecordAdapter;

    private ShowOperationsGroupRecordPresenterImp presenter;

    private OnFragmentInteractionListener mListener;

    public ShowOperationsGroupRecordFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ShowOperationsGroupRecordFragment newInstance(String idTeacher, String idClassroom, String idStudent, String token) {
        ShowOperationsGroupRecordFragment fragment = new ShowOperationsGroupRecordFragment();
        Bundle args = new Bundle();
        args.putString(ID_TEACHER, idTeacher);
        args.putString(ID_CLASSROOM, idClassroom);
        args.putString(ID_STUDENT, idStudent);
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
            token = getArguments().getString(ID_UUID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_show_operations_group, container, false);

        listOperationsGroupRecordList = rootView.findViewById(R.id.listOperationsGroup);
        listOperationsGroupRecordList.setHasFixedSize(true);

        DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        listOperationsGroupRecordList.addItemDecoration(decoration);

        lManager = new LinearLayoutManager(getActivity());
        listOperationsGroupRecordList.setLayoutManager(lManager);

        presenter = new ShowOperationsGroupRecordPresenterImp(this);

        presenter.getOperationsGroupRecord(idTeacher, idClassroom, idStudent, token);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showOperationsGroupRecord(List<OperationsGroupRecord> operationsGroupRecordList) {
        listOperationsGroupRecordAdapter = new ShowOperationsGroupRecordAdapter(operationsGroupRecordList, getActivity(), new ShowOperationsGroupRecordAdapter.OnItemClick() {
            @Override
            public void onClick(OperationsGroupRecord operationsGroupRecord) {
                mListener.onOperationsGroupClick(operationsGroupRecord);
            }
        });

        listOperationsGroupRecordList.setAdapter(listOperationsGroupRecordAdapter);
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
        void onOperationsGroupClick(OperationsGroupRecord operationsGroupRecord);
    }
}
