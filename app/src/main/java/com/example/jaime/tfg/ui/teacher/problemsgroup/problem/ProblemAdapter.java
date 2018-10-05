package com.example.jaime.tfg.ui.teacher.problemsgroup.problem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.jaime.tfg.R;
import com.example.jaime.tfg.data.model.Problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaime on 21/10/2017.
 */

public class ProblemAdapter extends RecyclerView.Adapter<ProblemAdapter.ProblemaViewHolder> implements Filterable{

    private List<Problem> problems;
    private List<Problem> problemsFiltrered;
    private Context context;
    public ProblemaCallBack callBack;

    public interface ProblemaCallBack {
        void onBtnEditarProblema(Problem problem);
        void onBtnEliminarProblemas(Context context, Problem problem);
    }

    public ProblemAdapter(List<Problem> problems, Context context, ProblemaCallBack grupoProblemasCallBack) {
        this.problems = problems;
        this.problemsFiltrered = problems;
        this.context = context;
        this.callBack = grupoProblemasCallBack;
    }

    @Override
    public ProblemaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_problemas_item, parent, false);
        return new ProblemaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProblemaViewHolder holder, int position) {

        holder.setProblem(problemsFiltrered.get(position));

        holder.enunciado.setText(problemsFiltrered.get(position).getStatement());
        holder.solucion.setText(problemsFiltrered.get(position).getOperation());
        holder.puntos.setText(String.valueOf(problemsFiltrered.get(position).getPuntos()));
        holder.tipoOperacion.setText(problemsFiltrered.get(position).getOperationType());
    }

    @Override
    public int getItemCount() {
        return problemsFiltrered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    problemsFiltrered = problems;

                } else {

                    List<Problem> filteredList = new ArrayList<>();

                    for (Problem problem : problems) {
                        if (problem.getStatement().contains(charSequence) || problem.getOperation().contains(charSequence)) {
                            filteredList.add(problem);
                        }
                    }
                    problemsFiltrered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = problemsFiltrered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                problemsFiltrered = (List<Problem>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ProblemaViewHolder extends RecyclerView.ViewHolder {

        public TextView enunciado;
        public TextView solucion;
        public TextView puntos;
        public TextView tipoOperacion;
        public Button btnEditarProblemas;
        public Button btnEliminarProblemas;

        public Problem problem;

        public ProblemaViewHolder(View v) {
            super(v);

            enunciado = v.findViewById(R.id.txtViewMostrarEnunciado);
            solucion = v.findViewById(R.id.txtViewMostrarOperacion);
            puntos = v.findViewById(R.id.txtViewPuntos);
            tipoOperacion = v.findViewById(R.id.txtViewMostrarTipoOperacion);
            btnEditarProblemas = v.findViewById(R.id.btnEditarProblema);
            btnEliminarProblemas = v.findViewById(R.id.btnEliminarProblema);

            btnEditarProblemas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.onBtnEditarProblema(problem);
                }
            });

            btnEliminarProblemas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.onBtnEliminarProblemas(context, problem);
                }
            });

        }

        public void setProblem(Problem problem) {
            this.problem = problem;
        }

    }
}