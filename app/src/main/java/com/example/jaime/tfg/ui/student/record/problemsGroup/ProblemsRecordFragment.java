package com.example.jaime.tfg.ui.student.record.problemsGroup;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.ProblemsRecord;
import com.example.jaime.tfg.ui.base.BaseFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProblemsRecordFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProblemsRecordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProblemsRecordFragment extends BaseFragment implements ProblemsRecordView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ID_STUDENT = "idStudent";
    private static final String ID_PROBLEMS_GROUP = "idProblemsGroup";
    private static final String ID_RECORD = "idRecord";
    private static final String ID_UUID = "token";

    // TODO: Rename and change types of parameters
    private String idStudent;
    private String idProblemsGroup;
    private String idRecord;
    private String token;

    private RecyclerView listProblemsRecord;
    private RecyclerView.LayoutManager lManager;
    private ProblemsRecordAdapter listProblemsRecordAdapater;

    private OnFragmentInteractionListener mListener;

    private ProblemsRecordPresenterImp presenter;

    public ProblemsRecordFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProblemsRecordFragment newInstance(String idStudent, String idProblemsGroup, String idRecord, String token) {
        ProblemsRecordFragment fragment = new ProblemsRecordFragment();
        Bundle args = new Bundle();
        args.putString(ID_STUDENT, idStudent);
        args.putString(ID_PROBLEMS_GROUP, idProblemsGroup);
        args.putString(ID_RECORD, idRecord);
        args.putString(ID_UUID, token);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idStudent = getArguments().getString(ID_STUDENT);
            idProblemsGroup = getArguments().getString(ID_PROBLEMS_GROUP);
            idRecord = getArguments().getString(ID_RECORD);
            token = getArguments().getString(ID_UUID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_problems_record_student, container, false);

        listProblemsRecord = rootView.findViewById(R.id.listRegistroProblemas);
        listProblemsRecord.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getActivity());
        listProblemsRecord.setLayoutManager(lManager);

        presenter = new ProblemsRecordPresenterImp(this);

        presenter.getProblemsRecord(idStudent, idProblemsGroup, idRecord, token);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) activity;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProblemsRecord(List<ProblemsRecord> problemsRecordList) {
        listProblemsRecordAdapater = new ProblemsRecordAdapter(problemsRecordList, getActivity());
        listProblemsRecord.setAdapter(listProblemsRecordAdapater);
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
