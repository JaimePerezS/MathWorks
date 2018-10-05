package com.example.jaime.tfg.ui.student.problemsGroup;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.ProblemsGroup;

import java.util.List;

/**
 * Created by Jaime on 11/01/2018.
 */

public class ProblemsGroupAdapter extends RecyclerView.Adapter<ProblemsGroupAdapter.ProblemsGroupViewHolder>{

    public ProblemsGroupCallBack callback;

    public interface ProblemsGroupCallBack {
        void onClick(ProblemsGroup problemsGroup);
    }

    private List<ProblemsGroup> problemsGroupList;
    private Context context;

    public ProblemsGroupAdapter(List<ProblemsGroup> problemsGroupList, Context context, ProblemsGroupCallBack callback) {
        this.problemsGroupList = problemsGroupList;
        this.context = context;
        this.callback = callback;
    }

    @Override
    public ProblemsGroupAdapter.ProblemsGroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_group, parent, false);
        return new ProblemsGroupViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProblemsGroupAdapter.ProblemsGroupViewHolder holder, int position) {
        ProblemsGroup problemsGroup = problemsGroupList.get(position);

        holder.name.setText(problemsGroup.getName());
        holder.setProblemsGroup(problemsGroup);
    }

    @Override
    public int getItemCount() {
        return problemsGroupList.size();
    }

    public class ProblemsGroupViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout layout;
        public TextView name;

        private ProblemsGroup problemsGroup;

        public ProblemsGroupViewHolder(View itemView) {
            super(itemView);

            this.layout = itemView.findViewById(R.id.formGroup);
            this.name = itemView.findViewById(R.id.txtViewNombreGrupo);

            this.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callback.onClick(problemsGroup);
                }
            });
        }

        public void setProblemsGroup(ProblemsGroup problemsGroup) {
            this.problemsGroup = problemsGroup;
        }

    }
}
