package ufscar.mobile.aa1_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ufscar.mobile.aa1_mobile.ConsultaAdapter;
import ufscar.mobile.aa1_mobile.persistence.Consulta;
import ufscar.mobile.aa1_mobile.persistence.ConsultaDao;
import ufscar.mobile.aa1_mobile.persistence.ConsultaDatabase;


public class Consultas extends AppCompatActivity {
    boolean loading = true;
    private RecyclerView recyclerView;
    private List<Consulta> consultaList = new ArrayList<>();
    private ConsultaDao consultaDao;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        recyclerView = findViewById(R.id.recyclerConsultas);

        consultaDao = ConsultaDatabase.getInstance(this).consultaDao();

        populateConsultas();

        ImageView imgHeader = findViewById(R.id.headerImage);
        imgHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar uma Intent para abrir a MainActivity
                Intent intent = new Intent(Consultas.this, MainActivity.class);
                // Iniciar a nova atividade
                startActivity(intent);
                // Encerrar a atividade atual
                finish();
            }
        });
    }

    private void populateConsultas(){
        consultaDao.getAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(consultas -> {
                    for (Consulta consulta : consultas) {
                        consultaList.add(consulta);
                        Log.d("Conteudo consulta", consulta.getNomeProfissional());
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    ConsultaAdapter consultaAdapter = new ConsultaAdapter(consultaList);
                    recyclerView.setAdapter(consultaAdapter);

                    consultaAdapter.notifyDataSetChanged();
                });

        Log.d("Room error", "completed");
    }
}
