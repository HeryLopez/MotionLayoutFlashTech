package com.jetbrains.handson.mpp.testmotionlayout.ui.introfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jetbrains.handson.mpp.testmotionlayout.R

class IntroFragment1 : Fragment() {

    companion object {
        fun newInstance() = IntroFragment1()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.intro_fragment1_fragment, container, false)
    }
}