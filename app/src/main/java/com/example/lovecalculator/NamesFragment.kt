package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentNamesBinding
import com.example.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NamesFragment : Fragment() {
    lateinit var binding: FragmentNamesBinding
    lateinit var firstName: String
    lateinit var secondName: String

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
                App.api.calculate(firstNameEd.text.toString(), secondNameEd.text.toString())
                    .enqueue(object : Callback<LoveModel>{
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            findNavController().navigate(R.id.resultFragment,
                            bundleOf(KEY_FOR_RESULT to response.body()))
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.e("ololo", "onFailure: ${t.message}", )
                        }
                    })
            }
        }
    }


    companion object {
        const val KEY_FOR_PERCENTAGE = "key.percent"
        const val KEY_FOR_RESULT = "key.result"

    }
}