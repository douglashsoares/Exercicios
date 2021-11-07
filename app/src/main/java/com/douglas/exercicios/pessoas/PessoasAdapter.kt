package com.douglas.exercicios.pessoas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.douglas.exercicios.databinding.ItemPessoaBinding
import com.douglas.exercicios.models.Pessoa

class PessoasAdapter(
    val pessoas: List<Pessoa>,
    val deleteClick: (Pessoa) -> Unit,
    val editarClick: (Pessoa) -> Unit
) : RecyclerView.Adapter<PessoasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pessoa = pessoas[position]
        holder.bind(pessoa, deleteClick, editarClick)
    }

    override fun getItemCount(): Int {
        return pessoas.size
    }

    class ViewHolder(val binding: ItemPessoaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pessoa: Pessoa, deleteClick: (Pessoa) -> Unit, editarClick: (Pessoa) -> Unit) {
            binding.txtNome.text = pessoa.nome
            binding.txtIdade.text = pessoa.idade.toString()
            binding.btnExcluir.setOnClickListener {
                deleteClick(pessoa)
            }

            binding.btnEditar.setOnClickListener {
                editarClick(pessoa)
            }
        }
    }


}