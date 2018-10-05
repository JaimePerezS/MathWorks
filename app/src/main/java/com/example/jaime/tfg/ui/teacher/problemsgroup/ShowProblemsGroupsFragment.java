package com.example.jaime.tfg.ui.teacher.problemsgroup;

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
import com.example.jaime.tfg.data.model.ProblemsGroup;
import com.example.jaime.tfg.ui.base.BaseFragment;
import com.example.jaime.tfg.ui.teacher.MainTeacherActivity;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowProblemsGroupsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowProblemsGroupsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowProblemsGroupsFragment extends BaseFragment implements ShowProblemsGroupsView{

    private static final String TAG = ShowProblemsGroupsFragment.class.getSimpleName();

    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";

    private String idTeacher;
    private String idUuid;

    private View rootView;
    private RecyclerView listaGrupoProblemas;
    private RecyclerView.LayoutManager lManager;
    private ProblemsGroupAdapter listaProblemsGroupAdapter;

    private FloatingActionButton btnAñadirGrupoProblemas;

    private ShowProblemsGroupsPresenterImp presenter;

    private OnFragmentInteractionListener mListener;

    public ShowProblemsGroupsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ShowProblemsGroupsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowProblemsGroupsFragment newInstance(String idProfesor, String idUnico) {
        ShowProblemsGroupsFragment fragment = new ShowProblemsGroupsFragment();
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
        rootView = inflater.inflate(R.layout.fragment_mostrar_grupo_problemas, container, false);

        listaGrupoProblemas = rootView.findViewById(R.id.listGrupoProblemas);
        listaGrupoProblemas.setHasFixedSize(true);

        lManager = new LinearLayoutManager(getActivity());
        listaGrupoProblemas.setLayoutManager(lManager);

        DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        listaGrupoProblemas.addItemDecoration(decoration);

        presenter = new ShowProblemsGroupsPresenterImp(this);

        btnAñadirGrupoProblemas = rootView.findViewById(R.id.btnAñadirGrupoProblema);

        btnAñadirGrupoProblemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigateToInsertProblemsGroup(getActivity().getApplicationContext(), idTeacher, idUuid);
            }
        });

        ((MainTeacherActivity) getActivity())
                .setActionBarTitle("Grupos de Problemas");

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
        presenter.getProblemsGroups(idTeacher, idUuid);
    }

    @Override
    public void showProblemsGroup(List<ProblemsGroup> problemsGroup) {
        listaProblemsGroupAdapter = new ProblemsGroupAdapter(problemsGroup, getActivity(), new ProblemsGroupAdapter.GrupoProblemasCallBack() {
            @Override
            public void onBtnVerProblemasClick(ProblemsGroup problemsGroup) {
                navigator.navigateToShowProblems(getActivity().getApplication(), String.valueOf(problemsGroup.getId()), idTeacher, idUuid, problemsGroup.getName());
            }

            @Override
            public void onBtnVerDisponibilidadClick(ProblemsGroup problemsGroup) {
                navigator.navigateToProblemsGroupAvailability(getActivity().getApplicationContext(), String.valueOf(problemsGroup.getId()), problemsGroup.getName(), idTeacher, idUuid);
            }

            @Override
            public void onBtnEditarGrupoProblemas(ProblemsGroup problemsGroup) {
                navigator.navigateToEditProblemsGroup(getActivity().getApplicationContext(), String.valueOf(problemsGroup.getId()), problemsGroup.getName(), problemsGroup.getDifficulty(), idTeacher, idUuid);
            }

            @Override
            public void onBtnEliminarGrupoProblemas(Context context, final ProblemsGroup problemsGroup) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Confirmar eliminación");
                alertDialog.setMessage("¿Está seguro de que desea eliminar el grupo de problemas " + problemsGroup.getName() + "?");

                alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        presenter.deleteProblemsGroup(idTeacher, String.valueOf(problemsGroup.getId()), idUuid);

                        presenter.getProblemsGroups(idTeacher, idUuid);
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

        listaGrupoProblemas.setAdapter(listaProblemsGroupAdapter);
    }

    @Override
    public void clearRecycler() {
        listaGrupoProblemas.setAdapter(null);
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
