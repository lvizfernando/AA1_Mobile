package ufscar.mobile.aa1_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import androidx.appcompat.app.AppCompatActivity;

import ufscar.mobile.aa1_mobile.service.Profissional;
import ufscar.mobile.aa1_mobile.persistence.ConsultaDao;
import ufscar.mobile.aa1_mobile.persistence.ConsultaDatabase;
import ufscar.mobile.aa1_mobile.persistence.Consulta;

public class Agendamento extends AppCompatActivity {
    private Button btnConfirmar;
    private DatePicker datePicker;
    private TimePicker timePicker;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);
        // Configurar o header com a imagem
        ImageView imgHeader = findViewById(R.id.headerImage);
        // Obter o objeto Professional selecionado na MainActivity
        int idProfissional = getIntent().getIntExtra("idProfissional", 1);
        String nomeProfissional = getIntent().getStringExtra("nomeProfissional");
        String especialidadeProfissional = getIntent().getStringExtra("especialidadeProfissional");

        imgHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar uma Intent para abrir a MainActivity
                Intent intent = new Intent(Agendamento.this, MainActivity.class);
                // Iniciar a nova atividade
                startActivity(intent);
                // Encerrar a atividade atual
                finish();
            }
        });

        // Configurar DatePicker
        datePicker = findViewById(R.id.datePicker);

        // Configurar TimePicker
        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        // Configurar botão Confirmar
        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter a data selecionada do DatePicker
                int dia = datePicker.getDayOfMonth();
                int mes = datePicker.getMonth() + 1; // Os meses são indexados a partir de 0
                int ano = datePicker.getYear();

                // Obter o horário selecionado do TimePicker
                int hora = timePicker.getHour();
                int minuto = timePicker.getMinute();
                // Criar um novo objeto Consulta com os detalhes da consulta
                Consulta consulta = new Consulta(dia, mes, hora, minuto, ano, idProfissional, nomeProfissional, especialidadeProfissional);
                consulta.setDia(dia);
                consulta.setHora(hora);
                consulta.setMinuto(minuto);
                consulta.setMes(mes);
                consulta.setAno(ano);
                consulta.setIdProfissional(idProfissional);
                consulta.setNomeProfissional(nomeProfissional);
                consulta.setEspecialidadeProfissional(especialidadeProfissional);

                uploadConsulta(consulta);
            }
        });
    }

    private void uploadConsulta(Consulta consulta){
        // Adicionar a consulta à lista de consultas
        List<Consulta> consultas = new ArrayList<>();
        consultas.add(consulta);

        // Criar uma Intent para abrir a ConsultasActivity
        Intent intent = new Intent(Agendamento.this, Consultas.class);

        ConsultaDao consultaDao = ConsultaDatabase.getInstance(this).consultaDao();
        consultaDao.insertConsulta(consulta).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {

                },  throwable -> {

                });;

        Log.d("Room error", "none happened");

        // Iniciar a nova atividade
        startActivity(intent);
    }
}
