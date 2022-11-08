package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentNamesBinding
import com.example.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NamesFragment : Fragment() {
    lateinit var binding: FragmentNamesBinding
    val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()

    }

    private fun initClickers() {
        with(binding){
            calcButton.setOnClickListener {
                viewModel.getLiveModel(firstNameEd.text.toString(), secondNameEd.text.toString())
                    .observe(viewLifecycleOwner, Observer { loveModel ->
                        Log.e("ololo", "initClickers: ${loveModel}", )
                        findNavController().navigate(R.id.resultFragment,
                        bundleOf(KEY_FOR_RESULT to loveModel))
                })
            }
        }
    }


    companion object {
        const val KEY_FOR_RESULT = "key.result"
    }
}