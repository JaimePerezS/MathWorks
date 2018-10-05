package com.example.jaime.tfg.ui.student.record.operationsGroup;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * {@link OperationsRecordFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OperationsRecordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OperationsRecordFragment extends BaseFragment implements OperationsRecordView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ID_STUDENT = "idStudent";
    private static final String ID_OPERATIONS_GROUP = "idOperationsGroup";
    private static final String ID_RECORD = "idRecord";
    private static final String ID_UUID = "token";

    // TODO: Rename and change types of parameters
    private String idStudent;
    private String idOperationsGroup;
    private String idRecord;
    private String token;

    private RecyclerView listOperationsRecordList;
    private RecyclerView.LayoutManager lManager;
    private OperationsRecordAdapter listOperationsRecordAdapater;

    private OnFragmentInteractionListener mListener;

    private OperationsRecordPresenter presenter;

    public OperationsRecordFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static OperationsRecordFragment newInstance(String idStudent, String idOperationsGroup, String idRecord, String token) {
        OperationsRecordFragment fragment = new OperationsRecordFragment();
        Bundle args = new Bundle();
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
        View rootView = inflater.inflate(R.layout.fragment_operations_record_student, container, false);

        listOperationsRecordList = rootView.findViewById(R.id.listRegistroOperaciones);
        listOperationsRecordList.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getActivity());
        listOperationsRecordList.setLayoutManager(lManager);

        presenter = new OperationsRecordPresenterImp(this);

        presenter.getOperationsRecord(idStudent, idOperationsGroup, idRecord, token);

        return rootView;
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
    public void showOperationsRecord(List<OperationsRecord> operationsRecordList) {
        listOperationsRecordAdapater = new OperationsRecordAdapter(operationsRecordList, getActivity());
        listOperationsRecordList.setAdapter(listOperationsRecordAdapater);
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
