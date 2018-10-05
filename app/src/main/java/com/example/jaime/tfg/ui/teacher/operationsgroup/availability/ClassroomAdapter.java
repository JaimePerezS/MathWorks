package com.example.jaime.tfg.ui.teacher.operationsgroup.availability;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Classroom;

import java.util.List;

/**
 * Created by Jaime on 23/01/2018.
 */

public class ClassroomAdapter extends RecyclerView.Adapter<ClassroomAdapter.ClassroomViewHolder> {

    private List<Classroom> classroomsList;
    private Context context;
    public OnItemClick callBack;

    private int selectedPosition = -1;

    public interface OnItemClick {
        void onClick(Classroom classroom);
    }

    public ClassroomAdapter(List<Classroom> classroomsList, Context context, OnItemClick callBack) {
        this.classroomsList = classroomsList;
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public ClassroomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_clase_visibilidad_item, parent, false);
        return new ClassroomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ClassroomViewHolder holder, int position) {

        Classroom classroom = classroomsList.get(position);

        holder.setClassroom(classroom);
        holder.setPosition(position);

        holder.name.setText(classroom.getName());

        if(selectedPosition == position) {
            holder.itemView.setBackgroundColor(Color.parseColor("#d8d8d8"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    @Override
    public int getItemCount() {
        return classroomsList.size();
    }

    public class ClassroomViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        private Classroom classroom;

        private int position;

        public ClassroomViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtViewNombreClase);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedPosition = position;
                    notifyDataSetChanged();
                    callBack.onClick(classroom);
                }
            });

        }

        public void setClassroom(Classroom classroom) {
            this.classroom = classroom;
        }

        public void setPosition(int position) { this.position = position; }
    }
}
