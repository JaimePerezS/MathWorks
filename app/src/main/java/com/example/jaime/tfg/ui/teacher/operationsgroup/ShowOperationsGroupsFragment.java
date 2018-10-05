package com.example.jaime.tfg.ui.teacher.operationsgroup;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.OperationsGroup;
import com.example.jaime.tfg.ui.base.BaseFragment;
import com.example.jaime.tfg.ui.teacher.MainTeacherActivity;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowOperationsGroupsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowOperationsGroupsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowOperationsGroupsFragment extends BaseFragment implements ShowOperationsGroupView {

    private static final String TAG = ShowOperationsGroupsFragment.class.getSimpleName();

    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private String idTeacher;
    private String idUuid;

    private View rootView;
    private RecyclerView listaGrupoOperaciones;
    private RecyclerView.LayoutManager lManager;
    private OperationsGroupAdapter listaOperationsGroupAdapter;

    private FloatingActionButton btnAñadirGrupoOperaciones;

    private ShowOperationsGroupPresenterImp presenter;

    private OnFragmentInteractionListener mListener;

    public ShowOperationsGroupsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ShowOperationsGroupsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowOperationsGroupsFragment newInstance(String idProfesor, String idUnico) {
        ShowOperationsGroupsFragment fragment = new ShowOperationsGroupsFragment();
        Bundle args = new Bundle();
        args.putString(ID_TEACHER, idProfesor);
        args.putString(ID_UUID, idUnico);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_mostrar_grupo_operaciones, container, false);

        listaGrupoOperaciones = rootView.findViewById(R.id.listGrupoOperaciones);
        listaGrupoOperaciones.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getActivity());
        listaGrupoOperaciones.setLayoutManager(lManager);

        DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        listaGrupoOperaciones.addItemDecoration(decoration);

        presenter = new ShowOperationsGroupPresenterImp(this);

        btnAñadirGrupoOperaciones = rootView.findViewById(R.id.btnAñadirGrupoOperaciones);

        btnAñadirGrupoOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigateToInsertOperationsGroup(getActivity().getApplicationContext(), idTeacher, idUuid);
            }
        });

        ((MainTeacherActivity) getActivity())
                .setActionBarTitle("Grupos de Operaciones");

        return rootView;
    }

    @Override
    public void showOperationsGroup(List<OperationsGroup> operationsGroup) {
        listaOperationsGroupAdapter = new OperationsGroupAdapter(operationsGroup, getActivity(), new OperationsGroupAdapter.GrupoOperacionesCallBack() {
            @Override
            public void onBtnVerOperaciones(OperationsGroup operationsGroup) {
                navigator.navigateToShowOperations(getActivity().getApplicationContext(), String.valueOf(operationsGroup.getId()), idTeacher, idUuid, operationsGroup.getName());
            }

            @Override
            public void onBtnDisponibilidadGrupoOperaciones(OperationsGroup operationsGroup) {
                navigator.navigateToSelectClassroom(getActivity().getApplicationContext(), String.valueOf(operationsGroup.getId()), operationsGroup.getName(), idTeacher, idUuid);
            }

            @Override
            public void onBtnEliminarGrupoOperacionesClick(Context context, final OperationsGroup operationsGroup) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Confirmar eliminación");
                alertDialog.setMessage("¿Está seguro de que desea eliminar el grupo de operaciones " + operationsGroup.getName() + "?");

                alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        presenter.onClickDeleteOperationsGroup(idTeacher, String.valueOf(operationsGroup.getId()), idUuid);
                        presenter.getOperationsGroup(idTeacher, idUuid);
                    }
                });

                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alertDialog.show();
            }

            @Override
            public void onBtnEditarGrupoOperacionesClick(OperationsGroup operationsGroup) {
                navigator.navigateToEditOperationsGroup(getActivity().getApplicationContext(), String.valueOf(operationsGroup.getId()), operationsGroup.getName(), operationsGroup.getDifficulty(), idTeacher, idUuid);
            }
        });

        listaGrupoOperaciones.setAdapter(listaOperationsGroupAdapter);
    }

    @Override
    public void clearRecycler() {
        listaGrupoOperaciones.setAdapter(null);
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
        presenter.getOperationsGroup(idTeacher, idUuid);
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
