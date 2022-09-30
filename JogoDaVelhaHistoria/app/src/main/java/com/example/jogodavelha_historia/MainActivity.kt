package com.example.jogodavelha_historia
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jogodavelha_historia.Adapter.AdapterHeroi
import com.example.jogodavelha_historia.model.Heroi


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        // utilziado para recuperar os dados <tipo Recyclerview> com o id recyclerView_herois dos activity_main
        val recyclerViewHerois = findViewById<RecyclerView>(R.id.recyclerView_herois)

        val p1 = findViewById<ImageView>(R.id.img_p1)
        val p2 = findViewById<ImageView>(R.id.img_p2)

        recyclerViewHerois.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // ganho de desempenho - Nao obrigatorio
        recyclerViewHerois.setHasFixedSize(true)

        // Configurar o adapter
        val listaDeHerois : MutableList<Heroi> = mutableListOf()
        val adapterHeroi = AdapterHeroi (this, listaDeHerois)
        recyclerViewHerois.adapter = adapterHeroi

        val heroi1 = Heroi (
            R.drawable.ayrtonsenna,
            "1 - Ayrton Senna",
            "Foi um piloto brasileiro de Fórmula 1, campeão da categoria três vezes, em 1988, 1990 e 1991"
        )
        listaDeHerois.add(heroi1)

        val heroi2 = Heroi (
            R.drawable.dompedro2,
            "2 - Dom Pedro II",
            "D. Pedro II, cognominado como o Magnânimo, foi o segundo e último monarca do Império do Brasil, tendo imperado no país durante um período de 58 anos"
        )
        listaDeHerois.add(heroi2)

        val heroi3 = Heroi (
            R.drawable.ruibarbosa,
            "3 - Rui Barbosa",
            "Ruy Barbosa de Oliveira foi um polímata brasileiro, tendo se destacado principalmente como jurista, advogado, político, diplomata, escritor, filólogo, jornalista, tradutor e orador"
        )
        listaDeHerois.add(heroi3)

        val heroi4 = Heroi (
            R.drawable.santosdumont,
            "4 - Santos Dumont",
            "Mineiro, patrono da Aeronáutica e da Força Aérea Brasileira, inventou o avião e o relógio de pulso. Posteriormente, recebeu a patente honorífica de marechal-do-ar"
        )
        listaDeHerois.add(heroi4)

        val heroi5 = Heroi (
            R.drawable.tiradentes,
            "5 - Tiradentes",
            "Joaquim José da Silva Xavier - Foi um dentista, tropeiro, minerador, comerciante, militar e ativista político. Participou de um movimento contra os pesados impostos cobrados e por consequência foi enforcado e depois esquartejado"
        )
        listaDeHerois.add(heroi5)

        val heroi6 = Heroi (
            R.drawable.josebonifacio,
            "6 - José Bonifácio",
            "José Bonifácio de Andrada e Silva foi um naturalista, estadista e poeta brasileiro, conhecido pelo epíteto de Patriarca da Independência por seu papel decisivo na Independência do Brasil. Em 11 de janeiro de 2018, foi declarado oficialmente Patrono da Independência do Brasil"
        )
        listaDeHerois.add(heroi6)

        val heroi7 = Heroi (
            R.drawable.chapolin,
            "7 - Chapolin",
            "Único Herói não brasileiro da lista - Chapolin Colorado herói universal\nO Chapolin Colorado é um herói atrapalhado, medroso e desastrado, que sempre aparece quando alguém precisa. Com sua marreta biônica e a pílula encolhedora, ele, muitas vezes, provoca mais confusão do que necessariamente ajuda."
        )
        listaDeHerois.add(heroi7)

        // Ir para intent Jogo
        val btn_playar = findViewById<Button>(R.id.btn_playar)
        btn_playar.setOnClickListener{
            startActivity(Intent(this@MainActivity, Jogo::class.java))
        }

        btn_playar.setOnLongClickListener(OnLongClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Parabéns!")
            builder.setMessage("Você desbloqueou um Easter Egg ao pressionar por 1406ms o botão Playár que é uma referência a música 1406 do Mamonas Assassinas \n")

            builder.setPositiveButton("Ver o show/música") { dialog, which ->
                Toast.makeText(applicationContext,
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
                val url = "https://www.youtube.com/watch?v=sSdEqQ_wJOo"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)
            }

            builder.setNegativeButton("Não gosto de música boa") { dialog, which ->
                Toast.makeText(applicationContext,
                    android.R.string.no, Toast.LENGTH_SHORT).show()
            }

            builder.show()

            true
        })
    }
}