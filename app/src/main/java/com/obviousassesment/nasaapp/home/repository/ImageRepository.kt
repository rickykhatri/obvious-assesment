package com.obviousassesment.nasaapp.home.repository

import com.google.gson.Gson
import com.obviousassesment.nasaapp.home.BaseApplication.Companion.applicationContext
import com.obviousassesment.nasaapp.home.model.ImagesData
import org.json.JSONException
import java.io.IOException

/**
 * This class holds all app level configurations
 */
object ImageRepository {

    fun validateJsonFile(fileName:String):String? {
        return try {
            if (!fileName.isNullOrBlank()) {
                if  (!fileName.endsWith(".json")) null else fileName
            } else {
                null
            }
        } catch (jsonException:JSONException) {
            null
        }
    }

    fun getJsonDataFromAsset(file: String = ""): ImagesData? {
        val fileName = if (!file.isNullOrBlank()) file else "data.json"
        val jsonString: String
        try {
            jsonString =
                applicationContext.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return Gson().fromJson(jsonString, ImagesData::class.java)
    }
}