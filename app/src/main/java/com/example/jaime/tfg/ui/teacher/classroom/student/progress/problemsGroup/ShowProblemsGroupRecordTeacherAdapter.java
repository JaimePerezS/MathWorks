package com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.ProblemsGroupRecord;

import java.util.List;

public class ShowProblemsGroupRecordTeacherAdapter extends RecyclerView.Adapter<ShowProblemsGroupRecordTeacherAdapter.ProblemsGroupRecordViewHolder> {
    private List<ProblemsGroupRecord> problemsGroupRecordList;
    private Context context;
    private onItemClick callBack;

    private int selectedPosition = -1;

    public interface onItemClick {
        void onClick(ProblemsGroupRecord problemsGroupRecord);
    }

    public ShowProblemsGroupRecordTeacherAdapter(List<ProblemsGroupRecord> problemsGroupRecordList, Context context, onItemClick callBack) {
        this.problemsGroupRecordList = problemsGroupRecordList;
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public ProblemsGroupRecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_registro_grupo_problemas_profesor_item, parent, false);
        return new ProblemsGroupRecordViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProblemsGroupRecordViewHolder holder, int position) {
        ProblemsGroupRecord problemsGroupRecord = problemsGroupRecordList.get(position);

        holder.setProblemsGroupRecord(problemsGroupRecord);
        holder.setPosition(position);

        holder.name.setText(problemsGroupRecord.getName());
        holder.date.setText(problemsGroupRecord.getDate());
        holder.points.setText(String.valueOf(problemsGroupRecord.getPointsObtained()));

        if(selectedPosition == position) {
            holder.itemView.setBackgroundColor(Color.parseColor("#d8d8d8"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    @Override
    public int getItemCount() {
        return problemsGroupRecordList.size();
    }

    public class ProblemsGroupRecordViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView date;
        public TextView points;

        private ProblemsGroupRecord problemsGroupRecord;
        private int position;

        public ProblemsGroupRecordViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtViewNombreGrupoProblemas);
            date = itemView.findViewById(R.id.txtViewFecha);
            points = itemView.findViewById(R.id.txtViewPuntosObtenidos);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedPosition = position;
                    notifyDataSetChanged();
                    callBack.onClick(problemsGroupRecord);
                }
            });
        }

        public void setProblemsGroupRecord(ProblemsGroupRecord problemsGroupRecord) {
            this.problemsGroupRecord = problemsGroupRecord;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
