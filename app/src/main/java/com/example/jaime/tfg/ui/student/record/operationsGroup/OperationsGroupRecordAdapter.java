package com.example.jaime.tfg.ui.student.record.operationsGroup;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.OperationsGroupRecord;

import java.util.List;

/**
 * Created by Jaime on 21/03/2018.
 */

public class OperationsGroupRecordAdapter extends RecyclerView.Adapter<OperationsGroupRecordAdapter.OperationsGroupRecordViewHolder> {

    private List<OperationsGroupRecord> operationsGroupRecordList;
    private Context context;
    public OnItemClick callBack;

    private int selectedPosition = -1;

    public interface OnItemClick {
        void onClick(OperationsGroupRecord operationsGroupRecord);
    }

    public OperationsGroupRecordAdapter(List<OperationsGroupRecord> operationsGroupRecordList, Context context, OnItemClick callBack) {
        this.operationsGroupRecordList = operationsGroupRecordList;
        this.context = context;
        this.callBack = callBack;
    }

    @Override
    public OperationsGroupRecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_registro_grupo_operaciones_item, parent, false);
        return new OperationsGroupRecordViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(OperationsGroupRecordViewHolder holder, int position) {

        OperationsGroupRecord operationsGroupRecord = operationsGroupRecordList.get(position);

        holder.setOperationsGroupRecord(operationsGroupRecord);
        holder.setPosition(position);

        holder.name.setText(operationsGroupRecord.getName());
        holder.date.setText(operationsGroupRecord.getDate());
        holder.points.setText(String.valueOf(operationsGroupRecord.getPointsObtained()));

        if(selectedPosition == position) {
            holder.itemView.setBackgroundColor(Color.parseColor("#00ddff"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FF03A9F4"));
        }

    }

    @Override
    public int getItemCount() {
        return operationsGroupRecordList.size();
    }

    public class OperationsGroupRecordViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout layout;

        public TextView name;
        public TextView date;
        public TextView points;

        private OperationsGroupRecord operationsGroupRecord;
        private int position;

        public OperationsGroupRecordViewHolder(View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.itemView);
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

