package com.example.jogodavelha_historia.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jogodavelha_historia.R
import com.example.jogodavelha_historia.model.Heroi

// Construtor
class AdapterHeroi (private  val context : Context, private val herois : MutableList<Heroi>): RecyclerView.Adapter<AdapterHeroi.HeroiViewHolder>() {

    // onCreateViewHolder cria a parte visual do card
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroiViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.card_heroi,parent, false)
        val holder = HeroiViewHolder(itemLista)
        return holder
    }

    // Exibe os itens da lista
    override fun onBindViewHolder(holder: HeroiViewHolder, position: Int) {
        holder.foto.setImageResource(herois[position].foto)
        holder.nome.text = herois[position].nome
        holder.descricao.text = herois[position].descricao
    }

    override fun getItemCount(): Int = herois.size

    inner class HeroiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.img_card_heroi)
        val nome = itemView.findViewById<TextView>(R.id.text_nome)
        val descricao = itemView.findViewById<TextView>(R.id.text_descricao)
    }

}