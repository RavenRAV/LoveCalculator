package com.example.lovecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Vibrator
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.model.LoveModel

class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {

        if (arguments!= null){
            val model = arguments?.getSerializable(NamesFragment.KEY_FOR_RESULT) as LoveModel

            with(binding){
                resultTV.text = "${model.fname} + ${model.sname} = ${model.result}"
                percentageTV.text = model.percentage
            }
        }

    }


    companion object {

    }
}