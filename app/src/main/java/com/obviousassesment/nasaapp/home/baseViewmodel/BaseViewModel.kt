package com.obviousassesment.nasaapp.home.baseViewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 * BaseViewModel class for defining the coroutine scope and common properties
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val supervisorJob = SupervisorJob()

    /**
     * This is a scope for all coroutines launched by [BaseViewModel]
     * that will be dispatched in a Thread Pool
     */
    protected val ioScope = CoroutineScope(Dispatchers.Default + supervisorJob)

    protected val context = application

    /**
     * Cancel all coroutines when the ViewModel is cleared
     */
    override fun onCleared() {
        super.onCleared()
        supervisorJob.cancel()
    }
}
