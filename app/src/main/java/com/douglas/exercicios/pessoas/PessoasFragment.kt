package com.douglas.exercicios.pessoas

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.douglas.exercicios.database.AppDatabase
import com.douglas.exercicios.database.DatabaseUtil
import com.douglas.exercicios.databinding.FragmentPessoasBinding
import com.douglas.exercicios.models.Pessoa
import com.douglas.exercicios.models.PessoaEntity
import com.douglas.exercicios.models.toEntity
import com.douglas.exercicios.models.toUi
import java.util.*


class PessoasFragment : Fragment() {

    private lateinit var binding: FragmentPessoasBinding
    val pessoasUiList = ArrayList<Pessoa>()



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

        atualizarListaPessoa()
        binding.rcPessoas.adapter = pessoasAdapter

        binding.btnAdicionar.setOnClickListener {

            val nome = binding.edtNome.text.toString()
            val idade = binding.edtIdade.text.toString().toInt()
            val pessoa = PessoaEntity(UUID.randomUUID().toString(), nome, idade)

            DatabaseUtil.db.pessoaDao().insert(pessoa)
            atualizarListaPessoa()
            pessoasAdapter.notifyDataSetChanged()

            binding.edtNome.setText("")
            binding.edtIdade.setText("")

            context?.let {
                val imm = it.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
            }

        }

        binding.btnFiltrarMaiorIdade.setOnClickListener {
            val pessoasEntity = DatabaseUtil.db.pessoaDao().getAll()
            val pessoasFiltro =  pessoasEntity.map {it.toUi() }.filter {
                it.ehMaiorDeIdade()
            }
            pessoasUiList.clear()
            pessoasUiList.addAll(pessoasFiltro)
            pessoasAdapter.notifyDataSetChanged()
        }

    }


    fun deletarPessoa(pessoa: Pessoa){
        DatabaseUtil.db.pessoaDao().delete(pessoa.id)
        atualizarListaPessoa()
        pessoasAdapter.notifyDataSetChanged()
    }

    fun editarPessoa(pessoa: Pessoa){
        DatabaseUtil.db.pessoaDao().update(pessoa.toEntity())
        atualizarListaPessoa()

        pessoasAdapter.notifyDataSetChanged()
    }

    fun atualizarListaPessoa(){
        val pessoasEntity = DatabaseUtil.db.pessoaDao().getAll()
        pessoasUiList.clear()
        pessoasUiList.addAll(pessoasEntity.map { it.toUi() })
    }

}