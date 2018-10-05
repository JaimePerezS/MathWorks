package com.example.jaime.tfg.ui.teacher.problemsgroup;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.ProblemsGroup;

import java.util.List;

/**
 * Created by Jaime on 14/10/2017.
 */

public class ProblemsGroupAdapter extends RecyclerView.Adapter<ProblemsGroupAdapter.GrupoProblemasViewHolder> {

    public interface GrupoProblemasCallBack {
        void onBtnVerProblemasClick(ProblemsGroup problemsGroup);
        void onBtnVerDisponibilidadClick(ProblemsGroup problemsGroup);
        void onBtnEditarGrupoProblemas(ProblemsGroup problemsGroup);
        void onBtnEliminarGrupoProblemas(Context context, ProblemsGroup problemsGroup);
    }

    public GrupoProblemasCallBack callBack;
    private List<ProblemsGroup> problemaGroups;
    private Context context;

    public ProblemsGroupAdapter(List<ProblemsGroup> problemaGroups, Context context, GrupoProblemasCallBack grupoProblemasCallBack) {
        this.problemaGroups = problemaGroups;
        this.context = context;
        this.callBack = grupoProblemasCallBack;
    }

    @Override
    public GrupoProblemasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_grupo_problemas_item, parent, false);
        return new GrupoProblemasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GrupoProblemasViewHolder holder, int position) {

        holder.setProblemsGroup(problemaGroups.get(position));

        holder.nombre.setText(problemaGroups.get(position).getName());
        holder.dificultad.setText(problemaGroups.get(position).getDifficulty());

        if(holder.dificultad.getText().equals("Fácil")) {
            holder.dificultad.setTextColor(Color.parseColor("#ff669900"));
        } else if (holder.dificultad.getText().equals("Medio")) {
            holder.dificultad.setTextColor(Color.parseColor("#ffff8800"));
        } else {
            holder.dificultad.setTextColor(Color.parseColor("#ffcc0000"));
        }
    }

    @Override
    public int getItemCount() {
        return problemaGroups.size();
    }

    public class GrupoProblemasViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public TextView dificultad;
        public Button btnVerProblemas;
        public Button btnVerDisponibilidad;
        public Button btnEditarGrupoProblemas;
        public Button btnEliminarGrupoProblemas;

        public ProblemsGroup problemsGroup;

        public GrupoProblemasViewHolder(View v) {
            super(v);

            nombre = v.findViewById(R.id.txtViewNombreGrupoProblemas);
            dificultad = v.findViewById(R.id.txtViewDificultadGrupoProblemas);
            btnVerProblemas = v.findViewById(R.id.btnVerProblemas);
            btnVerDisponibilidad = v.findViewById(R.id.btnDisponibilidadGrupoProblemas);
            btnEditarGrupoProblemas = v.findViewById(R.id.btnEditarGrupoProblemas);
            btnEliminarGrupoProblemas = v.findViewById(R.id.btnEliminarGrupoProblemas);

            btnVerProblemas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.onBtnVerProblemasClick(problemsGroup);
                }
            });

            btnVerDisponibilidad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.onBtnVerDisponibilidadClick(problemsGroup);
                }
            });

            btnEditarGrupoProblemas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.onBtnEditarGrupoProblemas(problemsGroup);
                }
            });

            btnEliminarGrupoProblemas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.onBtnEliminarGrupoProblemas(context, problemsGroup);
                }
            });

        }

        public void setProblemsGroup(ProblemsGroup problemsGroup) {
            this.problemsGroup = problemsGroup;
        }

    }
}
