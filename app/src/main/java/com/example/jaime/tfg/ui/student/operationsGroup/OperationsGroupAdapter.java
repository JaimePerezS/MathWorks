package com.example.jaime.tfg.ui.student.operationsGroup;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.OperationsGroup;

import java.util.List;

/**
 * Created by Jaime on 11/01/2018.
 */

public class OperationsGroupAdapter extends RecyclerView.Adapter<OperationsGroupAdapter.OperationsGroupViewHolder> {

    public OperationsGroupCallBack callback;

    public interface OperationsGroupCallBack {
        void onClick(OperationsGroup operationsGroup);
    }

    private List<OperationsGroup> operationsGroupList;
    private Context context;

    public OperationsGroupAdapter(List<OperationsGroup> operationsGroupList, Context context, OperationsGroupCallBack callback) {
        this.operationsGroupList = operationsGroupList;
        this.context = context;
        this.callback = callback;
    }

    @Override
    public OperationsGroupAdapter.OperationsGroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_group, parent, false);
        return new OperationsGroupViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OperationsGroupAdapter.OperationsGroupViewHolder holder, int position) {
        OperationsGroup operationsGroup = operationsGroupList.get(position);
        holder.setOperationsGroup(operationsGroup);

        holder.name.setText(operationsGroup.getName());

    }

    @Override
    public int getItemCount() {
        return operationsGroupList.size();
    }

    public class OperationsGroupViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout layout;
        public TextView name;

        private OperationsGroup operationsGroup;

        public OperationsGroupViewHolder(View itemView) {
            super(itemView);

            this.layout = itemView.findViewById(R.id.formGroup);
            this.name = itemView.findViewById(R.id.txtViewNombreGrupo);

            this.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callback.onClick(operationsGroup);
                }
            });
        }

        public void setOperationsGroup(OperationsGroup operationsGroup) {
            this.operationsGroup = operationsGroup;
        }
    }
}
