package com.jetbrains.handson.mpp.testmotionlayout.ui.introfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import com.jetbrains.handson.mpp.testmotionlayout.R

class IntroFragment3 : Fragment() {

    companion object {
        fun newInstance() = IntroFragment3()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.intro_fragment3_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MotionLayout>(R.id.root).transitionToEnd()
    }
}