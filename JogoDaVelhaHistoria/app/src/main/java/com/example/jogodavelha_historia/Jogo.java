package com.example.jogodavelha_historia;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Jogo extends AppCompatActivity {
    private Button btn_voltar;
    private Button btn_check;
    private ImageView img_p1;
    private ImageView img_p2;
    private ImageView img_p1_x;
    private ImageView img_p2_o;


    private ImageView linha0_coluna0;
    private EditText edit_linha1_coluna0;
    private EditText editText_num_jogador1;
    private EditText editText_num_jogador2;




    private int matriz [][] = new int[3][3];
    private ImageView[] vetorImageView = new ImageView [9];
    private String ganhador;
    private String p1;
    private String p2;
    private int player;
    private  int contador;

    private boolean empate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo);
        BuscarElementos ();

        contador = 1;
        player = 1;
        empate = true;

        vetorImageView[0] = findViewById(R.id.linha0_coluna0);
        vetorImageView[1] = findViewById(R.id.linha0_coluna1);
        vetorImageView[2] = findViewById(R.id.linha0_coluna2);
        vetorImageView[3] = findViewById(R.id.linha1_coluna0);
        vetorImageView[4] = findViewById(R.id.linha1_coluna1);
        vetorImageView[5] = findViewById(R.id.linha1_coluna2);
        vetorImageView[6] = findViewById(R.id.linha2_coluna0);
        vetorImageView[7] = findViewById(R.id.linha2_coluna1);
        vetorImageView[8] = findViewById(R.id.linha2_coluna2);


        vetorImageView[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada (vetorImageView[0], 0, 0);
            }
        });
        vetorImageView[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada (vetorImageView[1], 0, 1);

            }
        });
        vetorImageView[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada (vetorImageView[2], 0, 2);

            }
        });
        vetorImageView[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada (vetorImageView[3], 1, 0);

            }
        });
        vetorImageView[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada (vetorImageView[4], 1, 1);

            }
        });
        vetorImageView[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada (vetorImageView[5], 1, 2);

            }
        });
        vetorImageView[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada (vetorImageView[6], 2, 0);

            }
        });
        vetorImageView[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada (vetorImageView[7], 2, 1);

            }
        });
        vetorImageView[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogada (vetorImageView[8], 2, 2);

            }
        });


        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jogo.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Jogador 1 (p1)
                String heroiEscolhidoP1 = editText_num_jogador1.getText().toString();
                if (heroiEscolhidoP1.equals("1")) {
                    img_p1.setImageResource(R.drawable.ayrtonsenna);
                    img_p1_x = img_p1;
                } else if (heroiEscolhidoP1.equals("2")) {
                    img_p1.setImageResource(R.drawable.dompedro2);
                    img_p1_x = img_p1;
                } else if (heroiEscolhidoP1.equals("3")) {
                    img_p1.setImageResource(R.drawable.santosdumont);
                    img_p1_x = img_p1;
                } else if (heroiEscolhidoP1.equals("4")) {
                    img_p1.setImageResource(R.drawable.ruibarbosa);
                    img_p1_x = img_p1;
                } else if (heroiEscolhidoP1.equals("5")){
                    img_p1.setImageResource(R.drawable.chapolin);
                    img_p1_x = img_p1;
                }

                // Jogador 2 (p2)
                String heroiEscolhidoP2 = editText_num_jogador2.getText().toString();
                if (heroiEscolhidoP2.equals("1")) {
                    img_p2.setImageResource(R.drawable.ayrtonsenna);
                    img_p2_o = img_p2;
                } else if (heroiEscolhidoP2.equals("2")) {
                    img_p2.setImageResource(R.drawable.dompedro2);
                    img_p2_o = img_p2;
                } else if (heroiEscolhidoP2.equals("3")) {
                    img_p2.setImageResource(R.drawable.santosdumont);
                    img_p2_o = img_p2;
                } else if (heroiEscolhidoP2.equals("4")) {
                    img_p2.setImageResource(R.drawable.ruibarbosa);
                    img_p2_o = img_p2;
                } else if (heroiEscolhidoP2.equals("5")){
                    img_p2.setImageResource(R.drawable.chapolin);
                    img_p2_o.setImageResource(R.drawable.chapolin);
                }
            }
        });
    }

    // Metodos
    private void BuscarElementos () {
        btn_voltar = findViewById(R.id.btn_voltar);
        btn_check = findViewById(R.id.btn_check);
        linha0_coluna0 = findViewById(R.id.linha0_coluna0);
        edit_linha1_coluna0 = findViewById(R.id.edit_linha1_coluna0);
        img_p1 = findViewById(R.id.img_p1);
        img_p2 = findViewById(R.id.img_p2);

        editText_num_jogador1 = findViewById(R.id.editText_num_jogador1);
        editText_num_jogador2 = findViewById(R.id.editText_num_jogador2);
    }

    public void jogada (ImageView campo, int linhaX, int colunaY) {
        if (player == 1) {
            matriz[linhaX][colunaY] = 1;
            campo = img_p1_x;
            player = 2;
            ganhador = p1;
            mostrarGanhador(1);
        } else {
            matriz[linhaX][colunaY] = 2;
            campo = img_p2_o;
            player = 1;
            ganhador = p2;
            mostrarGanhador(2);

        }
        contador++;
    }
    public boolean fimDeJogo (int posicaoClicada) {
        for (int indice = 0; indice < matriz.length; indice++) {
            if (matriz[indice][0] == posicaoClicada && matriz[indice][1] == posicaoClicada && matriz[indice][2] == posicaoClicada) {
                empate = false;
                return true;
            }
            if (matriz[0][indice] == posicaoClicada && matriz[1][indice] == posicaoClicada && matriz[2][indice] == posicaoClicada) {
                empate = false;
                return true;
            }
        }
        if (matriz[0][0] == posicaoClicada && matriz[1][1] == posicaoClicada && matriz[2][2] == posicaoClicada) {
            empate = false;
            return true;
        }
        if (matriz[2][0] == posicaoClicada && matriz[1][1] == posicaoClicada && matriz[0][2] == posicaoClicada) {
            empate = false;
            return true;
        }

        return false;
    }

    public void mostrarGanhador(int x) {
        if (fimDeJogo(x) == true && empate == false) {
            AlertDialog.Builder alertaVencedor = new AlertDialog.Builder(this);
            alertaVencedor.setTitle("VITORIA");
            alertaVencedor.setMessage(player);
            alertaVencedor.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // todo
                }

            });
            alertaVencedor.create();
            alertaVencedor.show();
        }

    }

}




















