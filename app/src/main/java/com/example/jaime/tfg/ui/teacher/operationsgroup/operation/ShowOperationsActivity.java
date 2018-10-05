package com.example.jaime.tfg.ui.teacher.operationsgroup.operation;

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
import com.example.jaime.tfg.data.model.Operation;
import com.example.jaime.tfg.ui.base.BaseActivity;

import java.util.List;

public class ShowOperationsActivity extends BaseActivity implements ShowOperationsView {

    private static final String TAG = ShowOperationsActivity.class.getSimpleName();

    private static final String ID_TEACHER = "idTeacher";
    private static final String ID_OPERATIONS_GROUP = "idOperationsGroup";
    private static final String ID_UUID = "idUuid";
    private static final String NAME = "operationsGroupName";

    private RecyclerView listOperaciones;
    private RecyclerView.LayoutManager lManager;
    private OperationAdapter listOperacionesAdaptador;

    private FloatingActionButton btnAñadirOperacion;

    private String idTeacher;
    private String idOperationsGroup;
    private String idUuid;
    private String name;

    private ShowOperationsPresenterImp presenter;

    public static Intent getCallingIntent(Context context, String idGroup, String idTeacher, String idUuid, String name) {
        Intent intent = new Intent(context, ShowOperationsActivity.class);

        intent.putExtra(ID_OPERATIONS_GROUP, idGroup);
        intent.putExtra(ID_TEACHER, idTeacher);
        intent.putExtra(ID_UUID, idUuid);
        intent.putExtra(NAME, name);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_operaciones);

        Bundle bundle = getIntent().getExtras();

        idTeacher = bundle.getString(ID_TEACHER);
        idOperationsGroup = bundle.getString(ID_OPERATIONS_GROUP);
        idUuid = bundle.getString(ID_UUID);
        name = bundle.getString(NAME);

        presenter = new ShowOperationsPresenterImp(this);
        presenter.getOperations(idTeacher, idOperationsGroup, idUuid);

        listOperaciones = findViewById(R.id.listOperaciones);
        listOperaciones.setHasFixedSize(true);
        lManager = new LinearLayoutManager(this);
        listOperaciones.setLayoutManager(lManager);

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        listOperaciones.addItemDecoration(decoration);

        btnAñadirOperacion = findViewById(R.id.btnAñadirOperacion);

        btnAñadirOperacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.navigateToInsertOperation(getApplicationContext(), idOperationsGroup, idTeacher, idUuid);
            }
        });

        getSupportActionBar().setTitle("Grupo de Operaciones " + name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.getOperations(idTeacher, idOperationsGroup, idUuid);
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
    public void showOperations(List<Operation> operations) {
        listOperacionesAdaptador = new OperationAdapter(operations, this, new OperationAdapter.OperacionCallBack() {
            @Override
            public void onBtnEditarOperacion(Operation operation) {
                navigator.navigateToEditOperation(getApplicationContext(), idOperationsGroup, String.valueOf(operation.getId()), idTeacher, idUuid, operation.getStatement(), operation.getPuntos());
            }

            @Override
            public void onBtnEliminarOperacion(Context context, final Operation operation) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Confirmar eliminación");
                alertDialog.setMessage("¿Está seguro de que desea eliminar la operación " + operation.getStatement() + "?");

                alertDialog.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        presenter.onClickDeleteOperation(idTeacher, idOperationsGroup, String.valueOf(operation.getId()), idUuid);
                        presenter.getOperations(idTeacher, idOperationsGroup, idUuid);
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
        listOperaciones.setAdapter(listOperacionesAdaptador);
    }

    @Override
    public void clearRecycler() {
        listOperaciones.setAdapter(null);
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
                listOperacionesAdaptador.getFilter().filter(newText);
                return true;
            }
        });
    }
}
