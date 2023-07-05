package ufscar.mobile.aa1_mobile;

import android.graphics.Canvas;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProfessionalAdapter professionalAdapter;
    private List<Professional> professionalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        this.CreateProfessionals();

        ProfessionalAdapter professionalAdapter = new ProfessionalAdapter(this, professionalList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(professionalAdapter);

    }
    public void CreateProfessionals(){
        Professional professional = new Professional("Alda Hideko", "Pediatra",R.drawable.pediatra, 0);
        professionalList.add(professional);

         professional = new Professional("Felipe Araújo", "Oftalmologista",R.drawable.oftalmo, 1);
        professionalList.add(professional);

         professional = new Professional("Pedro Santana", "Rinolaringologista",R.drawable.rino, 2);
        professionalList.add(professional);

        professional = new Professional("Amanda Silva", "Cardiologista",R.drawable.cardio, 3);
        professionalList.add(professional);
    }
}
