package com.douglas.exercicios

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.douglas.exercicios.databinding.FragmentHomeBinding
import java.util.*


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnContador.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_basicFragment)
        }

        binding.btnCalculadora.setOnClickListener{

            it.findNavController().navigate(R.id.action_homeFragment_to_calculatorFragment)

        }

        binding.btnLista.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }

        binding.btnPessoa.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_pessoaFragment)
        }

        binding.btnPessoas.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_pessoasFragment)
        }


    }
}