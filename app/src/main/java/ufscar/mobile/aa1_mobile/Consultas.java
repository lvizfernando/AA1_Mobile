package ufscar.mobile.aa1_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.TextView;


public class Consultas extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        Intent it = getIntent();
        int dia = getIntent().getIntExtra("dia", -1);
        int mes = getIntent().getIntExtra("mes", -1);
        int ano = getIntent().getIntExtra("ano", -1);
        int hora = getIntent().getIntExtra("hora", -1);
        int minuto = getIntent().getIntExtra("minuto", -1);
        String nomeProfissional = getIntent().getStringExtra("nomeProfissional");
        String especialidadeProfissional = getIntent().getStringExtra("especialidadeProfissional");
        TextView tv = findViewById(R.id.textView2);
        tv.setText(dia + "|" + mes + "|" + ano + "|" + hora + "|" + minuto + "|" + nomeProfissional+"|" + especialidadeProfissional);

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
}
