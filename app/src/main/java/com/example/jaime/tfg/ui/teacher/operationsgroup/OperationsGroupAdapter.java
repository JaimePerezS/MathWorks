package com.example.jaime.tfg.ui.teacher.operationsgroup;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.OperationsGroup;

import java.util.List;

/**
 * Created by Jaime on 16/10/2017.
 */

public class OperationsGroupAdapter extends RecyclerView.Adapter<OperationsGroupAdapter.GrupoOperacionesViewHolder>{

    private List<OperationsGroup> gruposOperaciones;
    private Context context;
    public GrupoOperacionesCallBack callBack;

    public interface GrupoOperacionesCallBack {
        void onBtnVerOperaciones(OperationsGroup operationsGroup);
        void onBtnDisponibilidadGrupoOperaciones(OperationsGroup operationsGroup);
        void onBtnEliminarGrupoOperacionesClick(Context context, OperationsGroup operationsGroup);
        void onBtnEditarGrupoOperacionesClick(OperationsGroup operationsGroup);
    }

    public OperationsGroupAdapter(List<OperationsGroup> gruposOperaciones, Context context, GrupoOperacionesCallBack callBack) {
        this.gruposOperaciones = gruposOperaciones;
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public GrupoOperacionesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_grupo_operaciones_item, parent, false);
        return new GrupoOperacionesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GrupoOperacionesViewHolder holder, final int position) {


        final OperationsGroup operationsGroup = gruposOperaciones.get(position);

        holder.nombre.setText(gruposOperaciones.get(position).getName());
        holder.dificultad.setText(gruposOperaciones.get(position).getDifficulty());

        if(holder.dificultad.getText().equals("Fácil")) {
            holder.dificultad.setTextColor(Color.parseColor("#ff669900"));
        } else if (holder.dificultad.getText().equals("Medio")) {
            holder.dificultad.setTextColor(Color.parseColor("#ffff8800"));
        } else {
            holder.dificultad.setTextColor(Color.parseColor("#ffcc0000"));
        }

        holder.btnVerGrupoOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onBtnVerOperaciones(operationsGroup);
            }
        });

        holder.btnDisponibilidadGrupoOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onBtnDisponibilidadGrupoOperaciones(operationsGroup);
            }
        });

        holder.btnEditarGrupoOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onBtnEditarGrupoOperacionesClick(operationsGroup);
            }
        });

        holder.btnEliminarGrupoOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onBtnEliminarGrupoOperacionesClick(context, operationsGroup);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gruposOperaciones.size();
    }

    public class GrupoOperacionesViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public TextView dificultad;
        public Button btnVerGrupoOperaciones;
        public Button btnDisponibilidadGrupoOperaciones;
        public Button btnEditarGrupoOperaciones;
        public Button btnEliminarGrupoOperaciones;

        public OperationsGroup operationsGroup;

        public GrupoOperacionesViewHolder(View v) {
            super(v);

            nombre = v.findViewById(R.id.txtViewNombreGrupoProblemas);
            dificultad = v.findViewById(R.id.txtViewDificultadGrupoOperaciones);
            btnVerGrupoOperaciones = v.findViewById(R.id.btnVerOperaciones);
            btnDisponibilidadGrupoOperaciones = v.findViewById(R.id.btnDisponibilidadGrupoOperaciones);
            btnEditarGrupoOperaciones = v.findViewById(R.id.btnEditarGrupoOperaciones);
            btnEliminarGrupoOperaciones = v.findViewById(R.id.btnEliminarGrupoOperaciones);

        }

        public void setOperationsGroup(OperationsGroup operationsGroup) {
            this.operationsGroup = operationsGroup;
        }

    }
}

