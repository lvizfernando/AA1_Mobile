package ufscar.mobile.aa1_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import ufscar.mobile.aa1_mobile.databinding.ActivityMainBinding;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.profissionalButton);
        button.setOnClickListener(v -> {
            // Criar uma intenção para iniciar a segunda Activity
            Intent intent = new Intent(MainActivity.this, Agendamento.class);
            startActivity(intent);
        });
        ImageView headerImage = findViewById(R.id.header_image);
    }
}