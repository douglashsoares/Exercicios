package com.douglas.exercicios.animais

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.douglas.exercicios.databinding.ItemAnimaisBinding
import com.douglas.exercicios.databinding.ItemPessoaBinding

class AnimaisAdapter(
    val animais: List<Animais>
) : RecyclerView.Adapter<AnimaisAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimaisAdapter.ViewHolder {
        val binding = ItemAnimaisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder (binding)
    }

    override fun onBindViewHolder(holder: AnimaisAdapter.ViewHolder, position: Int) {
        val animais= animais[position]
        holder.bind(animais)
    }

    override fun getItemCount(): Int {
        return animais.size
    }


    class ViewHolder(val binding : ItemAnimaisBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(animais: Animais) {
            binding.txtNomeAnimal.text = animais.nome
            binding.txtRacaAnimal.text = animais.raca
            binding.txtTipoAnimal.text = animais.tipo
        }
    }

}