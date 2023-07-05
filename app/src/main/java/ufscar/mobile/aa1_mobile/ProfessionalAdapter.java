package ufscar.mobile.aa1_mobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfessionalAdapter extends RecyclerView.Adapter<ProfessionalAdapter.ProfessionalViewHolder> {
    private final Context context;
    private List<Professional> professionalList;
    public ProfessionalAdapter(Context context, List<Professional> lista){
        this.context = context;
        this.professionalList = lista;
    }
    @NonNull
    @Override
    public ProfessionalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View professionalList = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_professional, parent, false);
        return new ProfessionalViewHolder(professionalList);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionalViewHolder holder, int position) {
        Professional professional = professionalList.get(position);
        holder.nome.setText(professional.getName());
        holder.especialidade.setText(professional.getSpecialty());
        holder.imagem.setImageResource(professional.getImageId());
    }

    @Override
    public int getItemCount() {
        return professionalList.size();
    }

    public class ProfessionalViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView especialidade;
        ImageView imagem;
        Button agendar;
        public ProfessionalViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.professionalName);
            especialidade = itemView.findViewById(R.id.professionalSpecialty);
            imagem = itemView.findViewById(R.id.professionalImage);
            agendar = itemView.findViewById(R.id.bookButton);
            agendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Chamar o método para lidar com o clique no botão de agendamento
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Professional professional = professionalList.get(position);
                        abrirTelaAgendamento(professional);
                    }
                }
            });
        }
    }
    private void abrirTelaAgendamento(Professional professional) {
        // Criar uma Intent para abrir a tela de agendamento
        Intent intent = new Intent(context, Agendamento.class);
        // Passar dados extras para a tela de agendamento, se necessário
        intent.putExtra("nomeProfissional", professional.getName());
        // Iniciar a nova atividade
        context.startActivity(intent);
    }

}
