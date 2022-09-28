package com.example.jogodavelha_historia.herois;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jogodavelha_historia.MainActivity;
import com.example.jogodavelha_historia.R;

public class Chapolin extends AppCompatActivity {
    private Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapolin);
        getSupportActionBar().hide();
        BuscarElementos ();

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chapolin.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void BuscarElementos () {
        btn_voltar = findViewById(R.id.btn_voltar);
    }
}

// Img Chaplin: https://br.pinterest.com/pin/217439488236123904/?nic_v3=1a2eDfdgG