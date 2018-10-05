package com.example.jaime.tfg.ui.teacher.classroom.student;

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
import com.example.jaime.tfg.data.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaime on 17/10/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.AlumnoViewHolder> implements Filterable{

    private List<Student> students;
    private List<Student> studentsFiltrered;
    private Context context;
    public AlumnoAdapterCallBack callback;

    public interface AlumnoAdapterCallBack {
        void onBtnVerProgresosOperacionesClick(Student student);
        void onBtnVerProgresosProblemasClick(Student student);
        void onBtnEliminarClick(Context context, Student student);
        void onBtnEditarClick(Student student);
    }

    public StudentAdapter(List<Student> students, Context context, AlumnoAdapterCallBack callback) {
        this.context = context;
        this.students = students;
        this.studentsFiltrered = students;
        this.callback = callback;
    }

    @Override
    public AlumnoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_alumno_item, parent, false);
        return new AlumnoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AlumnoViewHolder holder, int position) {

        final Student student = studentsFiltrered.get(position);
        holder.setStudent(student);
        holder.nombre.setText(student.getName() + " " + student.getSurname());
        holder.idPublico.setText(student.getIdPublic());

        holder.btnVerProgresosOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onBtnVerProgresosOperacionesClick(student);
            }
        });

        holder.btnVerProgresosProblemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onBtnVerProgresosProblemasClick(student);
            }
        });

        holder.btnEditarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onBtnEditarClick(student);
            }
        });

        holder.btnEliminarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onBtnEliminarClick(context, student);
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentsFiltrered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    studentsFiltrered = students;

                } else {

                    List<Student> filteredList = new ArrayList<>();

                    for (Student student : students) {
                        if (student.getName().contains(charString) || student.getSurname().contains(charString)) {
                            filteredList.add(student);
                        }
                    }
                    studentsFiltrered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = studentsFiltrered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                studentsFiltrered = (List<Student>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder  {
        // Campos respectivos de un item

        public TextView nombre;
        public TextView idPublico;
        public Button btnVerProgresosOperaciones;
        public Button btnVerProgresosProblemas;
        public Button btnEditarAlumno;
        public Button btnEliminarAlumno;

        private Student student;

        public AlumnoViewHolder(View v) {
            super(v);

            nombre = v.findViewById(R.id.txtViewNombreAlumno);
            idPublico = v.findViewById(R.id.txtViewIdPublico);
            btnVerProgresosOperaciones = v.findViewById(R.id.btnVerProgresosOperaciones);
            btnVerProgresosProblemas = v.findViewById(R.id.btnVerProgresosProblemas);
            btnEditarAlumno = v.findViewById(R.id.btnEditarAlumno);
            btnEliminarAlumno = v.findViewById(R.id.btnEliminarAlumno);

        }

        public void setStudent(Student student) {
            this.student = student;
        }

    }

}
