package ufscar.mobile.aa1_mobile;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class Agendamento extends AppCompatActivity {
    private Date date;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        // Configurar o header com a imagem
        ImageView imgHeader = findViewById(R.id.headerImage);
        imgHeader.setOnClickListener(v -> {
            // Criar uma Intent para abrir a MainActivity
            Intent intent = new Intent(Agendamento.this, MainActivity.class);
            // Iniciar a nova atividade
            startActivity(intent);
            // Encerrar a atividade atual
            finish();
        });

        String intentExtra;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                intentExtra = null;
            } else {
                intentExtra = extras.getString("nomeProfissional");
            }
        } else {
            intentExtra = (String) savedInstanceState.getSerializable("nomeProfissional");
        }

        TextView t=(TextView)findViewById(R.id.idView);
        t.setText(intentExtra);

        Button dateButton = findViewById(R.id.dateButton);
        dateButton.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog((Context) this, (DatePickerDialog.OnDateSetListener) this, 2023, 1, 1);
            dialog.show();
            dialog.getDatePicker().setMinDate((new Date().getTime()));
        });

        Button button = findViewById(R.id.agendarButton);
        button.setOnClickListener(v -> {
            // Criar uma Intent para abrir a tela de agendamento
            Intent intent = new Intent(this, Consultas.class);
            // Passar dados extras para a tela de agendamento, se necessário
            intent.putExtra("nomeProfissional", intentExtra);
            // Iniciar a nova atividade
            this.startActivity(intent);
            // Encerrar a atividade atual
            finish();
        });
    }
}
