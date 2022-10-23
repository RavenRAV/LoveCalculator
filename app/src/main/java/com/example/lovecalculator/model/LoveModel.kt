package com.example.lovecalculator.model

import android.os.Parcelable
import java.io.Serializable

data class LoveModel  (
    val fname: String,
    val sname: String,
    val percentage: String,
    val result: String
        ) : Serializable