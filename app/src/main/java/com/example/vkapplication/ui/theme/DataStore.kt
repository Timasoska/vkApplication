package com.example.vkapplication.ui.theme

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class DataStore(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)

    fun saveSampleData(sampleData: List<Sites>) {
        val editor = sharedPreferences.edit()
        val json = Gson().toJson(sampleData)
        editor.putString("sampleData", json)
        editor.apply()
    }

    fun loadSampleData(): List<Sites> {
        val json = sharedPreferences.getString("sampleData", null)
        return if (json != null) {
            Gson().fromJson(json, Array<Sites>::class.java).toList()
        } else {
            emptyList()
        }
    }
}