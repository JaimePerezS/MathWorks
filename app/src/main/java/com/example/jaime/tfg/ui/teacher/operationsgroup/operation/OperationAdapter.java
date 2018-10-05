package com.example.jaime.tfg.ui.teacher.operationsgroup.operation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaime on 21/10/2017.
 */

public class OperationAdapter extends RecyclerView.Adapter<OperationAdapter.OperacionViewHolder> implements Filterable{

    private List<Operation> operations;
    private List<Operation> operationsFiltrered;
    private Context context;
    public OperacionCallBack callBack;

    public interface OperacionCallBack {
        void onBtnEditarOperacion(Operation operation);
        void onBtnEliminarOperacion(Context context, Operation operation);
    }

    public OperationAdapter(List<Operation> operations, Context context, OperacionCallBack operacionCallBack) {
        this.operations = operations;
        this.operationsFiltrered = operations;
        this.context = context;
        this.callBack = operacionCallBack;
    }

    @Override
    public OperacionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_operaciones_item, parent, false);
        return new OperacionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OperacionViewHolder holder, int position) {

        holder.setOperation(operationsFiltrered.get(position));

        holder.enunciado.setText(operationsFiltrered.get(position).getStatement());
        holder.solucion.setText(operationsFiltrered.get(position).getSolution());
        holder.puntos.setText(String.valueOf(operationsFiltrered.get(position).getPuntos()));
    }

    @Override
    public int getItemCount() {
        return operationsFiltrered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    operationsFiltrered = operations;

                } else {

                    List<Operation> filteredList = new ArrayList<>();

                    for (Operation operation : operations) {
                        if (operation.getStatement().contains(charSequence)) {
                            filteredList.add(operation);
                        }
                    }
                    operationsFiltrered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = operationsFiltrered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                operationsFiltrered = (List<Operation>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class OperacionViewHolder extends RecyclerView.ViewHolder {

        public TextView enunciado;
        public TextView solucion;
        public TextView puntos;
        public Button btnEditarOperacion;
        public Button btnEliminarOperacion;

        public Operation operation;

        public OperacionViewHolder(View v) {
            super(v);

            enunciado = v.findViewById(R.id.txtViewMostrarEnunciado);
            solucion = v.findViewById(R.id.txtViewMostrarOperacion);
            puntos = v.findViewById(R.id.txtViewPuntos);
            btnEditarOperacion = v.findViewById(R.id.btnEditarOperacion);
            btnEliminarOperacion = v.findViewById(R.id.btnEliminarOperacion);

            btnEditarOperacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.onBtnEditarOperacion(operation);
                }
            });

            btnEliminarOperacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.onBtnEliminarOperacion(context, operation);
                }
            });

        }

        public void setOperation(Operation operation) {
            this.operation = operation;
        }

    }
}
