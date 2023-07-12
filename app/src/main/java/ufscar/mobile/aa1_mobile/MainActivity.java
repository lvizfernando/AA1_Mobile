package ufscar.mobile.aa1_mobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.graphics.Canvas;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ufscar.mobile.aa1_mobile.databinding.ActivityMainBinding;
import ufscar.mobile.aa1_mobile.service.Profissional;
import ufscar.mobile.aa1_mobile.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProfessionalAdapter professionalAdapter;
    private List<Professional> professionalList = new ArrayList<>();
    private MainViewModel mainViewModel;

    private Boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.HomeImagem);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar uma Intent para abrir a MainActivity
                Intent intent = new Intent(MainActivity.this, Consultas.class);
                // Iniciar a nova atividade
                startActivity(intent);
                // Encerrar a atividade atual
                finish();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Wait for connection
        while (!isNetworkAvailable()) {
        }

        // Get and set profissionais from json
        mainViewModel.pullProfissionais();
        mainViewModel.getProfissionais().observe(this, profissionais -> {
            for (Profissional q : profissionais) {
                this.CreateProfessionals(q);
            }
            ProfessionalAdapter professionalAdapter = new ProfessionalAdapter(this, professionalList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(professionalAdapter);
        });
    }

    public void CreateProfessionals(Profissional p){
        // Setting imageId
        int drawId;
        switch (p.getImageId()) {
            case "pediatra":
                drawId = R.drawable.pediatra;
                break;
            case "oftalmo":
                drawId = R.drawable.oftalmo;
                break;
            case "rino":
                drawId = R.drawable.rino;
                break;
            case "cardio":
                drawId = R.drawable.cardio;
                break;
            default:
                drawId = R.drawable.pediatra;
                break;
        }

        Log.d("Profissional String", p.toString());

        Professional professional = new Professional(p.getName(), p.getSpeciality(), drawId, p.getId()-1);
        professionalList.add(professional);
    }
}
