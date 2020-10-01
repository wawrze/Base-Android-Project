package com.wawra.app_name.presentation

import android.os.Bundle
import androidx.navigation.findNavController
import com.wawra.app_name.R
import com.wawra.app_name.base.BaseActivity
import com.wawra.app_name.base.Navigation

class MainActivity : BaseActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getNavigationController() = findNavController(R.id.activity_main_fragment)

}