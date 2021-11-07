package com.douglas.exercicios.pessoas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.douglas.exercicios.databinding.BottomsheetPessoaEditBinding
import com.douglas.exercicios.models.Pessoa
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PessoaEditBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: BottomsheetPessoaEditBinding
    lateinit var editClick: (Pessoa) -> Unit
    lateinit var pessoa: Pessoa

    companion object  {
        fun newInstance(pessoa: Pessoa ,editClick: (Pessoa) -> Unit) : PessoaEditBottomSheet {
            val instance = PessoaEditBottomSheet()
            instance.editClick = editClick
            instance.pessoa = pessoa
            return instance
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomsheetPessoaEditBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.edtNome.setText(pessoa.nome)
        binding.edtIdade.setText(pessoa.idade.toString())

        binding.btnSalvar.setOnClickListener {
            val nome = binding.edtNome.text.toString()
            val idade = binding.edtIdade.text.toString().toInt()
            val newPerson = Pessoa(pessoa.id,nome, idade)

            editClick(newPerson)

            dismiss()
        }
    }



}