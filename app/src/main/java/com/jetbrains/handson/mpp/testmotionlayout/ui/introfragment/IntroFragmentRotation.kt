package com.jetbrains.handson.mpp.testmotionlayout.ui.introfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import com.jetbrains.handson.mpp.testmotionlayout.R

private const val ARG_SHOW_PATHS = "showPaths"

class IntroFragmentRotation : Fragment() {

    private var showPaths: Boolean = false

    companion object {
        @JvmStatic
        fun newInstance(showPaths: Boolean) =
            IntroFragmentRotation().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_SHOW_PATHS, showPaths)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            showPaths = it.getBoolean(ARG_SHOW_PATHS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.intro_fragment_rotation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MotionLayout>(R.id.root).transitionToEnd()
        if(showPaths){
            view.findViewById<MotionLayout>(R.id.root).setDebugMode(2)
        }
    }
}