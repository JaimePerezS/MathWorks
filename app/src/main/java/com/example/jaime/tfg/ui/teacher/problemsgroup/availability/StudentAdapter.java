package com.example.jaime.tfg.ui.teacher.problemsgroup.availability;

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
 * Created by Jaime on 01/03/2018.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{
    private List<Student> studentList;
    private Context context;
    private RecyclerViewOnItemClickListener onItemClickListener;

    public interface RecyclerViewOnItemClickListener {
        void onClick(Student student);
    }

    public StudentAdapter(List<Student> studentList, Context context, RecyclerViewOnItemClickListener onItemClickListener) {
        this.studentList = studentList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_alumno_item_visibility, parent, false);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {

        final Student student = studentList.get(position);

        holder.setStudent(student);

        holder.btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(student);
            }
        });

        holder.name.setText(student.getName() + " " + student.getSurname());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public Button btnHide;

        private Student student;

        public StudentViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtViewNombreApellidos);

            btnHide = itemView.findViewById(R.id.btnOcultar);

        }

        public void setStudent(Student student) {
            this.student = student;
        }

    }
}
