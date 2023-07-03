package ufscar.mobile.aa1_mobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class Agendamento extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        SharedPreferences preferences =
                getSharedPreferences("professionalID", Context.MODE_PRIVATE);

        int id = preferences.getInt("CardID", 0);

        TextView t=(TextView)findViewById(R.id.idView);
        t.setText("The id is:");
        t.append(Integer.toString(id));

        DatePicker dp = (DatePicker) findViewById(R.id.datePicker);
        dp.setMinDate((new Date().getTime()));

        Button button = findViewById(R.id.agendarButton);
        button.setOnClickListener(v -> {
            // Iniciar a Activity Consultas
            Intent intent = new Intent(Agendamento.this, Consultas.class);
            startActivity(intent);
        });

        ImageView headerImage = findViewById(R.id.header_image);


    }
}

