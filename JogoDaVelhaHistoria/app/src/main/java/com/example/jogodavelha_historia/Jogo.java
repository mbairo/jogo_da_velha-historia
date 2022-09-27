package com.example.jogodavelha_historia;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Jogo extends AppCompatActivity {
    private Button btn_voltar;
    private ImageView img_p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo);
        BuscarElementos ();


        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jogo.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Metodos
    private void BuscarElementos () {
        btn_voltar = findViewById(R.id.btn_voltar);
    }
}
