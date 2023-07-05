package ufscar.mobile.aa1_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Consultas extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        ImageView headerImage = findViewById(R.id.headerImage);
        headerImage.setOnClickListener(v -> {
            // Criar uma Intent para abrir a MainActivity
            Intent intent = new Intent(Consultas.this, MainActivity.class);
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

        TextView t=(TextView)findViewById(R.id.nameText);
        t.setText(intentExtra);
    }
}