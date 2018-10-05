package com.example.jaime.tfg.ui.teacher.classroom.student.progress.problemsGroup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.ProblemsRecord;

import java.util.List;

public class ShowProblemsRecordTeacherAdapter extends RecyclerView.Adapter<ShowProblemsRecordTeacherAdapter.ProblemsRecordViewHolder>{
    private List<ProblemsRecord> problemsRecordList;
    private Context context;

    public ShowProblemsRecordTeacherAdapter(List<ProblemsRecord> problemsRecordList, Context context) {
        this.problemsRecordList = problemsRecordList;
        this.context = context;
    }

    @Override
    public ProblemsRecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_registro_problemas_profesor_item, parent, false);
        return new ProblemsRecordViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(ProblemsRecordViewHolder holder, int position) {
        ProblemsRecord problemsRecord = problemsRecordList.get(position);

        holder.txtViewStatement.setText(problemsRecord.getStatement());
        holder.txtViewIdentifyMistakes.setText(String.valueOf(problemsRecord.getMistakesIdent()));
        holder.txtViewOperationMistakes.setText(String.valueOf(problemsRecord.getMistakesOper()));
        holder.txtViewPoints.setText(String.valueOf(problemsRecord.getPointsObtained()));

    }

    @Override
    public int getItemCount() {
        return problemsRecordList.size();
    }

    public class ProblemsRecordViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewStatement;
        public TextView txtViewIdentifyMistakes;
        public TextView txtViewOperationMistakes;
        public TextView txtViewPoints;

        public ProblemsRecordViewHolder(View itemView) {
            super(itemView);

            txtViewStatement = itemView.findViewById(R.id.txtViewEnunciado);
            txtViewIdentifyMistakes = itemView.findViewById(R.id.txtViewErroresIdentificar);
            txtViewOperationMistakes = itemView.findViewById(R.id.txtViewErroresOperacion);
            txtViewPoints = itemView.findViewById(R.id.txtViewPuntos);

        }
    }
}
