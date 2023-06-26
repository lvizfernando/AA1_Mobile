package ufscar.mobile.aa1_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.profissionalButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar uma intenção para iniciar a segunda Activity
                Intent intent = new Intent(MainActivity.this, Agendamento.class);
                startActivity(intent);
            }
        });
        ImageView headerImage = findViewById(R.id.header_image);
    }
}