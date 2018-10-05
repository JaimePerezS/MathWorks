package com.example.jaime.tfg.ui.teacher.problemsgroup.problem;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Problem;
import com.example.jaime.tfg.ui.base.BaseActivity;

import java.util.List;


public class ShowProblemsActivity extends BaseActivity implements ShowProblemsView{

    private static final String TAG = ShowProblemsActivity.class.getSimpleName();

    private static final String ID_PROBLEMS_GROUP = "idProblemsGroup";
    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_UUID = "idUuid";
    private static final String NAME = "name";

    private RecyclerView listProblemas;
    private RecyclerView.LayoutManager lManager;
    private ProblemAdapter listProblemasAdaptador;

    private FloatingActionButton btnAñadirProblema;

    private String idTeacher;
    private String idProblemsGroup;
    private String idUuid;

    private ShowProblemsPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idProblemsGroup, String idTeacher, String idUuid, String name) {
        Intent intent = new Intent(context, ShowProblemsActivity.class);

        intent.putExtra(ID_PROBLEMS_GROUP, idProblemsGroup);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);
        intent.putExtra(NAME, name);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_problemas);

        Bundle bundle = getIntent().getExtras();

        idProblemsGroup = bundle.getString(ID_PROBLEMS_GROUP);
        idTeacher = bundle.getString(ID_TEACHER);
        idUuid = bundle.getString(ID_UUID);

        presenter = new ShowProblemsPresenterImp(this);
        presenter.getProblems(idTeacher, idProblemsGroup, idUuid);

        listProblemas = findViewById(R.id.listProblemas);
        listProblemas.setHasFixedSize(true);
        lManager = new LinearLayoutManager(this);
        listProblemas.setLayoutManager(lManager);

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        listProblemas.addItemDecoration(decoration);

        btnAñadirProblema = findViewById(R.id.btnAñadirProblema);

        btnAñadirProblema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigateToInsertProblem(getApplicationContext(), idProblemsGroup, idTeacher, idUuid);
            }
        });

        getSupportActionBar().setTitle(bundle.getString(NAME));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.getProblems(idTeacher, idProblemsGroup, idUuid);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProblems(final List<Problem> problems) {
        listProblemasAdaptador = new ProblemAdapter(problems, this, new ProblemAdapter.ProblemaCallBack() {
            @Override
            public void onBtnEditarProblema(Problem problem) {
                navigator.navigateToEditProblem(getApplicationContext(), idProblemsGroup, String.valueOf(problem.getId()), idTeacher, idUuid, problem.getStatement(), problem.getOperation(), problem.getPuntos(), problem.getHelp(), problem.getOperationType());
            }

            @Override
            public void onBtnEliminarProblemas(Context context, final Problem problem) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Confirmar eliminación");
                alertDialog.setMessage("¿Está seguro de que desea eliminar el problema?");

                alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        presenter.onClickDeleteProblem(idTeacher, idProblemsGroup, String.valueOf(problem.getId()), idUuid);
                        presenter.getProblems(idTeacher, idProblemsGroup, idUuid);
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

        listProblemas.setAdapter(listProblemasAdaptador);
    }

    @Override
    public void clearRecycler() {
        listProblemas.setAdapter(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycler_menu, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listProblemasAdaptador.getFilter().filter(newText);
                return true;
            }
        });
    }
}
