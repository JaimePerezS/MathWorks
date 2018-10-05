package com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.OperationsRecord;

import java.util.List;

public class ShowOperationsRecordTeacherAdapter extends RecyclerView.Adapter<ShowOperationsRecordTeacherAdapter.OperationsRecordViewHolder> {
    private List<OperationsRecord> operationsRecordList;
    private Context context;

    public ShowOperationsRecordTeacherAdapter(List<OperationsRecord> operationsRecordList, Context context) {
        this.operationsRecordList = operationsRecordList;
        this.context = context;
    }

    @Override
    public OperationsRecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_registro_operaciones_profesor_item, parent, false);
        return new OperationsRecordViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(OperationsRecordViewHolder holder, int position) {
        OperationsRecord operationsRecord = operationsRecordList.get(position);

        holder.txtViewOperation.setText(operationsRecord.getStatement());
        holder.txtViewMistakes.setText(String.valueOf(operationsRecord.getMistakes()));
        holder.txtViewPoints.setText(String.valueOf(operationsRecord.getPointsObtained()));

    }

    @Override
    public int getItemCount() {
        return operationsRecordList.size();
    }


    public class OperationsRecordViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewOperation;
        public TextView txtViewMistakes;
        public TextView txtViewPoints;

        public OperationsRecordViewHolder(View itemView) {
            super(itemView);

            txtViewOperation = itemView.findViewById(R.id.txtViewOperacion);
            txtViewMistakes = itemView.findViewById(R.id.txtViewErrores);
            txtViewPoints = itemView.findViewById(R.id.txtViewPuntos);

        }
    }
}
