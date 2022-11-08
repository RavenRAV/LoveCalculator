package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.model.LoveModel

class LoveViewModel : ViewModel() {
    val repository = Repository()
    fun getLiveModel(firstName: String, secondName: String):LiveData<LoveModel>{
        return repository.getCalculate(firstName, secondName)
    }

}