package ufscar.mobile.aa1_mobile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import io.reactivex.schedulers.Schedulers;
import ufscar.mobile.aa1_mobile.persistence.Consulta;
import ufscar.mobile.aa1_mobile.persistence.ConsultaDao;
import ufscar.mobile.aa1_mobile.persistence.ConsultaDatabase;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class ConsultaAdapter extends RecyclerView.Adapter<ConsultaAdapter.ConsultaViewHolder> {
    private List<Consulta> consultaList;
    ConsultaDao consultaDao;

    public ConsultaAdapter(List<Consulta> consultaList){
        this.consultaList = consultaList;
    }
    @NonNull
    @Override
    public ConsultaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View consultaList = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_consultas, parent, false);
        consultaDao = ConsultaDatabase.getInstance(parent.getContext()).consultaDao();

        return new ConsultaViewHolder(consultaList);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultaViewHolder holder, int position) {
        Consulta consulta = consultaList.get(position);
        holder.data.setText(consulta.getDataFormatada());
        holder.nomeprofissional.setText(consulta.getNomeProfissional());
        holder.especialidadeprofissional.setText(consulta.getEspecialidadeProfissional());
        holder.deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultaDao.deleteById(consulta.getId()).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(() -> {
                            consultaList.remove(position);
                            notifyDataSetChanged();
                        },  throwable -> {

                        });
            }
        });
    }

    @Override
    public int getItemCount() {
        return consultaList.size();
    }

    public class ConsultaViewHolder extends RecyclerView.ViewHolder {
        TextView data;
        TextView nomeprofissional;
        TextView especialidadeprofissional;
        Button deletebutton;
        public ConsultaViewHolder(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.textViewDate);
            nomeprofissional = itemView.findViewById(R.id.textViewName);
            especialidadeprofissional = itemView.findViewById(R.id.textViewSpecialty);
            deletebutton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
