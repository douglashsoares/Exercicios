package com.douglas.exercicios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.douglas.exercicios.databinding.FragmentBasicBinding
import com.douglas.exercicios.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSoma.setOnClickListener{
            val num1 =  binding.edtNum1.text.toString().toInt()
            val num2 = binding.edtNum2.text.toString().toInt()

            val resultado: Int = num1 + num2

            binding.txtValorResultado.text = resultado.toString()
        }

        binding.btnSubtracao.setOnClickListener{
            val num1 =  binding.edtNum1.text.toString().toInt()
            val num2 = binding.edtNum2.text.toString().toInt()

            val resultado: Int = num1 - num2

            binding.txtValorResultado.text = resultado.toString()
        }

        binding.btnMult.setOnClickListener{
            val num1 =  binding.edtNum1.text.toString().toInt()
            val num2 = binding.edtNum2.text.toString().toInt()

            val resultado: Int = num1 * num2

            binding.txtValorResultado.text = resultado.toString()

        }
        binding.btnDiv.setOnClickListener{
            val num1 =  binding.edtNum1.text.toString().toInt()
            val num2 = binding.edtNum2.text.toString().toInt()

            if(num2 == 0){
                binding.txtValorResultado.text = "Erro !!!"
            }else {
                val resultado: Int = num1 / num2
                binding.txtValorResultado.text = resultado.toString()
            }
        }


    }


}