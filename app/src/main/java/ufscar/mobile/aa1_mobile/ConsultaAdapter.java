package ufscar.mobile.aa1_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ConsultaAdapter extends RecyclerView.Adapter<ConsultaAdapter.ConsultaViewHolder> {
    private List<Consulta> consultaList;

    public ConsultaAdapter(List<Consulta> consultaList){
        this.consultaList = consultaList;
    }
    @NonNull
    @Override
    public ConsultaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View consultaList = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_consultas, parent, false);

        return new ConsultaViewHolder(consultaList);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultaViewHolder holder, int position) {
        Consulta consulta = consultaList.get(position);
        holder.data.setText(consulta.getDataFormatada());
        holder.nomeprofissional.setText(consulta.getNomeProfissional());
        holder.especialidadeprofissional.setText(consulta.getEspecialidadeProfissional());
    }

    @Override
    public int getItemCount() {
        return consultaList.size();
    }

    public class ConsultaViewHolder extends RecyclerView.ViewHolder {
        TextView data;
        TextView nomeprofissional;
        TextView especialidadeprofissional;
        public ConsultaViewHolder(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.textViewDate);
            nomeprofissional = itemView.findViewById(R.id.textViewName);
            especialidadeprofissional = itemView.findViewById(R.id.textViewSpecialty);

        }
    }
}
