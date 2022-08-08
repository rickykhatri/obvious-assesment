package com.obviousassesment.nasaapp.home.configurations

import com.obviousassesment.nasaapp.home.BaseApplication.Companion.applicationContext
import java.io.IOException

/**
 * This class holds all app level configurations
 */
object EnvironmentConfig {

    fun getJsonDataFromAsset(): String? {
        val fileName = "data.json"
        val jsonString: String
        try {
            jsonString =
                applicationContext.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}