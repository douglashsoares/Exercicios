package com.douglas.exercicios.pessoas

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.douglas.exercicios.database.DataBase
import com.douglas.exercicios.databinding.FragmentPessoasBinding
import com.douglas.exercicios.models.Pessoa
import java.util.*


class PessoasFragment : Fragment() {

    private lateinit var binding: FragmentPessoasBinding
    val pessoasUiList = ArrayList<Pessoa>().apply {
        addAll(DataBase.pessoasList)
    }

    val deleteClickCallBack: (Pessoa) -> Unit = {
        deletarPessoa(it)
    }

    val editarPessoaCallBack: (Pessoa) -> Unit = { it ->
        PessoaEditBottomSheet.newInstance(it) { novaPessoa ->
            editarPessoa(novaPessoa)
        }.show(parentFragmentManager, "Salguod")
    }


    val pessoasAdapter = PessoasAdapter(pessoasUiList, deleteClickCallBack, editarPessoaCallBack )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPessoasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.rcPessoas.adapter = pessoasAdapter

        binding.btnAdicionar.setOnClickListener {

            val nome = binding.edtNome.text.toString()
            val idade = binding.edtIdade.text.toString().toInt()
            val pessoa = Pessoa(UUID.randomUUID().toString(), nome, idade)

            DataBase.pessoasList.add(pessoa)
            pessoasUiList.clear()
            pessoasUiList.addAll(DataBase.pessoasList)
            pessoasAdapter.notifyDataSetChanged()

            binding.edtNome.setText("")
            binding.edtIdade.setText("")

            context?.let {
                val imm = it.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
            }

        }

        binding.btnFiltrarMaiorIdade.setOnClickListener {
            val pessoasFiltro = DataBase.pessoasList.filter {
                it.ehMaiorDeIdade()
            }
            pessoasUiList.clear()
            pessoasUiList.addAll(pessoasFiltro)
            pessoasAdapter.notifyDataSetChanged()
        }

    }


    fun deletarPessoa(pessoa: Pessoa){

        DataBase.pessoasList.remove(pessoa)

        pessoasUiList.clear()
        pessoasUiList.addAll(DataBase.pessoasList)
        pessoasAdapter.notifyDataSetChanged()

    }

    fun editarPessoa(pessoa: Pessoa){

        val findPessoa =  DataBase.pessoasList.find{
            it.id == pessoa.id
        }

        findPessoa?.let{
            it.nome = pessoa.nome
            it.idade = pessoa.idade
        }

        pessoasUiList.clear()
        pessoasUiList.addAll(DataBase.pessoasList)
        pessoasAdapter.notifyDataSetChanged()
    }

}