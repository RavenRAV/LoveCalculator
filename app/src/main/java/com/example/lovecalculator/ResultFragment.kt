package com.example.lovecalculator

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

    private fun initViews() {
//        if (arguments!=null){
//            val percentage =arguments?.getString(NamesFragment.KEY_FOR_PERCENTAGE)
//            val result = arguments?.getString(NamesFragment.KEY_FOR_RESULT)
//
//            with(binding){
//                resultTV.text = result
//                percentageTV.text = percentage + "%"
//
//            }
//        }

        if (arguments!= null){
            val model = arguments?.getSerializable(NamesFragment.KEY_FOR_RESULT) as LoveModel

            with(binding){
                resultTV.text = model.result
                percentageTV.text = model.percentage
            }
        }

    }


    companion object {

    }
}