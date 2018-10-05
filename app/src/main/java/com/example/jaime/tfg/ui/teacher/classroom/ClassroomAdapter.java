package com.example.jaime.tfg.ui.teacher.classroom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Classroom;

import java.util.List;

/**
 * Created by Jaime on 11/10/2017.
 */

public class ClassroomAdapter extends RecyclerView.Adapter<ClassroomAdapter.ClaseViewHolder> {

    private List<Classroom> classrooms;

    private Context context;

    public ClaseAdapterCallBack callback;

    public interface ClaseAdapterCallBack {
        void onBtnVerAlumnosClick(Classroom classroom);
        void onBtnEliminarClick(Classroom classroom);
        void onBtnEditarClick(Classroom classroom);
    }

    public ClassroomAdapter(List<Classroom> classrooms, Context context, ClaseAdapterCallBack callback) {
        this.context = context;
        this.classrooms = classrooms;
        this.callback = callback;
    }

    @Override
    public ClaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_clase_item, parent, false);
        return new ClaseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ClaseViewHolder holder, final int position) {

        final Classroom classroom = classrooms.get(position);
        holder.setClassroom(classroom);
        holder.nombre.setText(classroom.getName());

        holder.btnVerAlumnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onBtnVerAlumnosClick(classroom);
            }
        });

        holder.btnEditarClase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onBtnEditarClick(classroom);
            }
        });

        holder.btnEliminarClase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onBtnEliminarClick(classroom);
            }
        });

    }

    @Override
    public int getItemCount() {
        return classrooms.size();
    }


    public class ClaseViewHolder extends RecyclerView.ViewHolder  {

        public TextView nombre;
        public Button btnVerAlumnos;
        public Button btnEditarClase;
        public Button btnEliminarClase;

        private Classroom classroom;

        public ClaseViewHolder(View v) {
            super(v);

            nombre = v.findViewById(R.id.txtViewNombreClase);
            btnVerAlumnos = v.findViewById(R.id.btnVerAlumnos);
            btnEditarClase = v.findViewById(R.id.btnEditarClase);
            btnEliminarClase = v.findViewById(R.id.btnEliminarClase);

        }

        public void setClassroom(Classroom classroom) {
            this.classroom = classroom;
        }

    }

}


