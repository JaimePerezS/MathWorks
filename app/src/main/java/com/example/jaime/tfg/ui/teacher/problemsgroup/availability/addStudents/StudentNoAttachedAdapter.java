package com.example.jaime.tfg.ui.teacher.problemsgroup.availability.addStudents;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Student;

import java.util.List;

/**
 * Created by Jaime on 06/03/2018.
 */

public class StudentNoAttachedAdapter extends RecyclerView.Adapter<StudentNoAttachedAdapter.StudentViewHolder>{
    private List<Student> studentList;
    private Context context;
    private RecyclerViewOnItemClickListener onItemClickListener;

    public interface RecyclerViewOnItemClickListener {
        void onClick(Student student);
    }

    public StudentNoAttachedAdapter(List<Student> studentList, Context context, RecyclerViewOnItemClickListener onItemClickListener) {
        this.studentList = studentList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_alumno_no_asignado_item, parent, false);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, final int position) {

        final Student student = studentList.get(position);

        holder.setStudent(student);

        holder.name.setText(student.getName() + " " + student.getSurname());

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(student);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public Button btnAdd;

        private Student student;

        public StudentViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtViewNombreApellidos);

            btnAdd = itemView.findViewById(R.id.btnHacerGrupoVisible);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onClick(student);
                }
            });

        }

        public void setStudent(Student student) {
            this.student = student;
        }

    }
}
