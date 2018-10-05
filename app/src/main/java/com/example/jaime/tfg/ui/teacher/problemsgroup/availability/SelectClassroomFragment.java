package com.example.jaime.tfg.ui.teacher.problemsgroup.availability;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Classroom;
import com.example.jaime.tfg.ui.base.BaseFragment;

import java.util.List;


public class SelectClassroomFragment extends BaseFragment implements SelectClassroomView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = SelectClassroomFragment.class.getSimpleName();

    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private View rootView;
    private RecyclerView listClassrooms;
    private RecyclerView.LayoutManager lManager;
    private ClassroomAdapter listClassroomsAdapater;

    // TODO: Rename and change types of parameters
    private String idTeacher;
    private String token;

    private SelectClassroomPresenterImp presenter;

    String classroomSelected;

    private OnClassroomClickListener mListener;

    public SelectClassroomFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SelectClassroomFragment newInstance(String idTeacher, String token) {
        SelectClassroomFragment fragment = new SelectClassroomFragment();
        Bundle args = new Bundle();
        args.putString(ID_TEACHER, idTeacher);
        args.putString(ID_UUID, token);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idTeacher = getArguments().getString(ID_TEACHER);
            token = getArguments().getString(ID_UUID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_select_classroom, container, false);

        listClassrooms = rootView.findViewById(R.id.listClases);
        listClassrooms.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getActivity());
        listClassrooms.setLayoutManager(lManager);

        DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        listClassrooms.addItemDecoration(decoration);

        presenter = new SelectClassroomPresenterImp(this);

        presenter.getClassrooms(idTeacher, token);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnClassroomClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showClassrooms(List<Classroom> classrooms) {
        listClassroomsAdapater = new ClassroomAdapter(classrooms, getActivity(), new ClassroomAdapter.OnItemClick() {
            @Override
            public void onClick(Classroom classroom) {
                mListener.onClassroomClick(classroom);
            }
        });
        listClassrooms.setAdapter(listClassroomsAdapater);
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    public interface OnClassroomClickListener {
        // TODO: Update argument type and name
        void onClassroomClick(Classroom classroom);
    }
}
