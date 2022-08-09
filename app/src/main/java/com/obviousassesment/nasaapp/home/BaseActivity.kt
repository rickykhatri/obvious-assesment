package com.obviousassesment.nasaapp.home

import android.content.res.Configuration
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    private var viewDataBinding: T? = null
    private var baseViewModel: V? = null

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        supportActionBar?.setDisplayShowTitleEnabled(true)

    }

    override fun onDestroy() {
        super.onDestroy()
        viewDataBinding = null
        baseViewModel = null
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * Override for get view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): V

    /**
     * Override for get binding variable
     *
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    fun getViewDataBinding(): T? = viewDataBinding

    private fun performDataBinding() {
        baseViewModel = baseViewModel ?: getViewModel()
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        viewDataBinding?.setVariable(getBindingVariable(), baseViewModel)
        viewDataBinding?.executePendingBindings()
        viewDataBinding?.lifecycleOwner = this
    }
}
