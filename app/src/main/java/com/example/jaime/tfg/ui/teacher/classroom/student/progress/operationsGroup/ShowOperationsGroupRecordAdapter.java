package com.example.jaime.tfg.ui.teacher.classroom.student.progress.operationsGroup;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.OperationsGroupRecord;

import java.util.List;

public class ShowOperationsGroupRecordAdapter extends RecyclerView.Adapter<ShowOperationsGroupRecordAdapter.OperationsGroupRecordViewHolder>{

    private List<OperationsGroupRecord> operationsGroupRecordList;
    private Context context;
    public OnItemClick callBack;

    private int selectedPosition = -1;

    public interface OnItemClick {
        void onClick(OperationsGroupRecord operationsGroupRecord);
    }

    public ShowOperationsGroupRecordAdapter(List<OperationsGroupRecord> operationsGroupRecordList, Context context, OnItemClick callBack) {
        this.operationsGroupRecordList = operationsGroupRecordList;
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public ShowOperationsGroupRecordAdapter.OperationsGroupRecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_registro_grupo_operaciones_profesor_item, parent, false);
        return new OperationsGroupRecordViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(OperationsGroupRecordViewHolder holder, final int position) {
        OperationsGroupRecord operationsGroupRecord = operationsGroupRecordList.get(position);

        holder.setOperationsGroupRecord(operationsGroupRecord);
        holder.setPosition(position);

        holder.name.setText(operationsGroupRecord.getName());
        holder.date.setText(operationsGroupRecord.getDate());
        holder.points.setText(String.valueOf(operationsGroupRecord.getPointsObtained()));

        if(selectedPosition == position) {
            holder.itemView.setBackgroundColor(Color.parseColor("#d8d8d8"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    @Override
    public int getItemCount() {
        return operationsGroupRecordList.size();
    }

    public class OperationsGroupRecordViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView date;
        public TextView points;

        private OperationsGroupRecord operationsGroupRecord;
        private int position;

        public OperationsGroupRecordViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtViewNombreGrupoOperaciones);
            date = itemView.findViewById(R.id.txtViewFecha);
            points = itemView.findViewById(R.id.txtViewPuntosObtenidos);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedPosition = position;
                    notifyDataSetChanged();
                    callBack.onClick(operationsGroupRecord);
                }
            });
        }

        public void setOperationsGroupRecord(OperationsGroupRecord operationsGroupRecord) {
            this.operationsGroupRecord = operationsGroupRecord;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
