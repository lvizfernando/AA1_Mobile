package ufscar.mobile.aa1_mobile;

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
    private List<Professional> professionalList;
    public ProfessionalAdapter(List<Professional> lista){
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
        }
    }

}
