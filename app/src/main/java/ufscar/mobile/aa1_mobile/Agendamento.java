package ufscar.mobile.aa1_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

public class Agendamento extends AppCompatActivity {
    private Button btnConfirmar;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Professional professional;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);
        // Configurar o header com a imagem
        ImageView imgHeader = findViewById(R.id.headerImage);
        // Obter o objeto Professional selecionado na MainActivity
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
                Consulta consulta = new Consulta(dia, mes, hora, minuto, ano, nomeProfissional, especialidadeProfissional);
                consulta.setDia(dia);
                consulta.setHora(hora);
                consulta.setMinuto(minuto);
                consulta.setAno(ano);
                consulta.setNomeProfissional(nomeProfissional);
                consulta.setEspecialidadeProfissional(especialidadeProfissional);

// Adicionar a consulta à lista de consultas
                List<Consulta> consultas = new ArrayList<>();
                consultas.add(consulta);


                // Criar uma Intent para abrir a ConsultasActivity
                Intent intent = new Intent(Agendamento.this, Consultas.class);
                // Passar a data e o horário selecionados como extras
                intent.putExtra("dia", dia);
                intent.putExtra("mes", mes);
                intent.putExtra("ano", ano);
                intent.putExtra("hora", hora);
                intent.putExtra("minuto", minuto);
                intent.putExtra("nomeProfissional", nomeProfissional);
                intent.putExtra("especialidadeProfissional", especialidadeProfissional);
                // Iniciar a nova atividade
                startActivity(intent);
            }
        });
    }
}
