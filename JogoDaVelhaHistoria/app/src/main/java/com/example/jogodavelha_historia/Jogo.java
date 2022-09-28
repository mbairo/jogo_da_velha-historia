
package com.example.jogodavelha_historia;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Jogo extends AppCompatActivity {
    private Button btn_voltar;
    private Button btn_check;
    private ImageView img_p1;
    private ImageView img_p2;

    private ImageView linha0_coluna0;

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
                } else if (heroiEscolhidoP1.equals("2")) {
                    img_p1.setImageResource(R.drawable.dompedro2);
                } else if (heroiEscolhidoP1.equals("3")) {
                    img_p1.setImageResource(R.drawable.ruibarbosa);
                } else if (heroiEscolhidoP1.equals("4")) {
                    img_p1.setImageResource(R.drawable.santosdumont);
                } else if (heroiEscolhidoP1.equals("5")){
                    img_p1.setImageResource(R.drawable.tiradentes);
                } else if (heroiEscolhidoP1.equals("6")){
                    img_p1.setImageResource(R.drawable.josebonifacio);
                } else if (heroiEscolhidoP1.equals("7")){
                    img_p1.setImageResource(R.drawable.chapolin);
                }

                // Jogador 2 (p2)
                String heroiEscolhidoP2 = editText_num_jogador2.getText().toString();

                if (heroiEscolhidoP2.equals("1")) {
                    img_p2.setImageResource(R.drawable.ayrtonsenna);
                } else if (heroiEscolhidoP2.equals("2")) {
                    img_p2.setImageResource(R.drawable.dompedro2);
                } else if (heroiEscolhidoP2.equals("3")) {
                    img_p2.setImageResource(R.drawable.ruibarbosa);
                } else if (heroiEscolhidoP2.equals("4")) {
                    img_p2.setImageResource(R.drawable.santosdumont);
                } else if (heroiEscolhidoP2.equals("5")){
                    img_p2.setImageResource(R.drawable.tiradentes);
                } else if (heroiEscolhidoP2.equals("6")){
                    img_p2.setImageResource(R.drawable.josebonifacio);
                } else if (heroiEscolhidoP2.equals("7")){
                    img_p2.setImageResource(R.drawable.chapolin);
                }
            }
        });
    }

    public void jogada (ImageView campo, int linhaX, int colunaY) {
        String heroiEscolhidoP1 = editText_num_jogador1.getText().toString();
        String heroiEscolhidoP2 = editText_num_jogador2.getText().toString();

        if (player == 1) {
            if (heroiEscolhidoP1.equals("1")){
                matriz[linhaX][colunaY] = 1;
                campo.setImageResource(R.drawable.ayrtonsenna);
                player = 2;
                ganhador = "Ayrton Senna";
                verificarSeGanhou(1);
            } else if (heroiEscolhidoP1.equals("2")) {
                matriz[linhaX][colunaY] = 1;
                campo.setImageResource(R.drawable.dompedro2);
                player = 2;
                ganhador = "Dom Pedro II";
                verificarSeGanhou(1);
            } else if (heroiEscolhidoP1.equals("3")) {
                matriz[linhaX][colunaY] = 1;
                campo.setImageResource(R.drawable.ruibarbosa);
                player = 2;
                ganhador = "Rui Barbosa";
                verificarSeGanhou(1);
            } else if (heroiEscolhidoP1.equals("4")) {
                matriz[linhaX][colunaY] = 1;
                campo.setImageResource(R.drawable.santosdumont);
                player = 2;
                ganhador = "Santos Dumont";
                verificarSeGanhou(1);
            } else if (heroiEscolhidoP1.equals("5")) {
                matriz[linhaX][colunaY] = 1;
                campo.setImageResource(R.drawable.tiradentes);
                player = 2;
                ganhador = "Tiradentes";
                verificarSeGanhou(1);
            } else if (heroiEscolhidoP1.equals("6")) {
                matriz[linhaX][colunaY] = 1;
                campo.setImageResource(R.drawable.josebonifacio);
                player = 2;
                ganhador = "José Bonifácio";
                verificarSeGanhou(1);
            } else if (heroiEscolhidoP1.equals("7")) {
                matriz[linhaX][colunaY] = 1;
                campo.setImageResource(R.drawable.chapolin);
                player = 2;
                ganhador = "Chapolin";
                verificarSeGanhou(1);
            }


        } else {
            if (heroiEscolhidoP2.equals("1")){
                matriz[linhaX][colunaY] = 2;
                campo.setImageResource(R.drawable.ayrtonsenna);
                player = 1;
                ganhador = "Ayrton Senna";
                verificarSeGanhou(2);
            } else if (heroiEscolhidoP2.equals("2")) {
                matriz[linhaX][colunaY] = 2;
                campo.setImageResource(R.drawable.dompedro2);
                player = 1;
                ganhador = "Dom Pedro II";
                verificarSeGanhou(2);
            } else if (heroiEscolhidoP2.equals("3")) {
                matriz[linhaX][colunaY] = 2;
                campo.setImageResource(R.drawable.ruibarbosa);
                player = 1;
                ganhador = "Rui Barbosa";
                verificarSeGanhou(2);
            } else if (heroiEscolhidoP2.equals("4")) {
                matriz[linhaX][colunaY] = 2;
                campo.setImageResource(R.drawable.santosdumont);
                player = 1;
                ganhador = "Santos Dumont";
                verificarSeGanhou(2);
            } else if (heroiEscolhidoP2.equals("5")) {
                matriz[linhaX][colunaY] = 2;
                campo.setImageResource(R.drawable.tiradentes);
                player = 1;
                ganhador = "Tiradentes";
                verificarSeGanhou(2);
            } else if (heroiEscolhidoP2.equals("6")) {
                matriz[linhaX][colunaY] = 2;
                campo.setImageResource(R.drawable.josebonifacio);
                player = 1;
                ganhador = "José Bonifácio";
                verificarSeGanhou(2);
            } else if (heroiEscolhidoP2.equals("7")) {
                matriz[linhaX][colunaY] = 2;
                campo.setImageResource(R.drawable.chapolin);
                player = 1;
                ganhador = "Chapolin";
                verificarSeGanhou(2);
            }
        }
        contador++;
    }

    public void verificarSeGanhou(int heroiDoPlayer) {
        if (fimDeJogo(heroiDoPlayer) == true && empate == false) {
            AlertDialog.Builder alertaVencedor = new AlertDialog.Builder(this);
            alertaVencedor.setTitle("VITORIA");
            alertaVencedor.setMessage(ganhador + " Ganhou!");
            alertaVencedor.setCancelable(false);

            alertaVencedor.setPositiveButton("História", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), "Aqui vai a história...", Toast.LENGTH_LONG).show();
                }
            });
            alertaVencedor.setPositiveButton("Menu Inicial", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), "Entiti para o inicio...", Toast.LENGTH_LONG).show();
                }
            });

            alertaVencedor.create();
            alertaVencedor.show();
        }
    }

    public boolean fimDeJogo (int heroiDoPlayer) {
        for (int indice = 0; indice < matriz.length; indice++) {
            if (matriz[indice][0] == heroiDoPlayer && matriz[indice][1] == heroiDoPlayer && matriz[indice][2] == heroiDoPlayer) {
                empate = false;
                return true;
            }
            if (matriz[0][indice] == heroiDoPlayer && matriz[1][indice] == heroiDoPlayer && matriz[2][indice] == heroiDoPlayer) {
                empate = false;
                return true;
            }
        }
        if (matriz[0][0] == heroiDoPlayer && matriz[1][1] == heroiDoPlayer && matriz[2][2] == heroiDoPlayer) {
            empate = false;
            return true;
        }
        if (matriz[2][0] == heroiDoPlayer && matriz[1][1] == heroiDoPlayer && matriz[0][2] == heroiDoPlayer) {
            empate = false;
            return true;
        }
        return false;
    }

    // Métodos
    private void BuscarElementos () {
        btn_voltar = findViewById(R.id.btn_voltar);
        btn_check = findViewById(R.id.btn_check);
        linha0_coluna0 = findViewById(R.id.linha0_coluna0);
        img_p1 = findViewById(R.id.img_p1);
        img_p2 = findViewById(R.id.img_p2);

        editText_num_jogador1 = findViewById(R.id.editText_num_jogador1);
        editText_num_jogador2 = findViewById(R.id.editText_num_jogador2);

        vetorImageView[0] = findViewById(R.id.linha0_coluna0);
        vetorImageView[1] = findViewById(R.id.linha0_coluna1);
        vetorImageView[2] = findViewById(R.id.linha0_coluna2);
        vetorImageView[3] = findViewById(R.id.linha1_coluna0);
        vetorImageView[4] = findViewById(R.id.linha1_coluna1);
        vetorImageView[5] = findViewById(R.id.linha1_coluna2);
        vetorImageView[6] = findViewById(R.id.linha2_coluna0);
        vetorImageView[7] = findViewById(R.id.linha2_coluna1);
        vetorImageView[8] = findViewById(R.id.linha2_coluna2);

    }


}










