package com.jetbrains.handson.mpp.testmotionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jetbrains.handson.mpp.testmotionlayout.common.InterpolationAnimation
import com.jetbrains.handson.mpp.testmotionlayout.common.ProgressBarAnimation
import com.jetbrains.handson.mpp.testmotionlayout.ui.introfragment.*
import kotlinx.android.synthetic.main.content_intro_motion_layout.*
import kotlinx.android.synthetic.main.intro_activity.*

class IntroActivity : AppCompatActivity() {

    private lateinit var viewModel: IntroViewModel

    private val progressBarScale = 15

    private var lastPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity)

        viewModel = ViewModelProviders.of(this).get(IntroViewModel::class.java)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, IntroFragment1.newInstance())
                .commitNow()
        }

        button_previous.setOnClickListener {
            viewModel.previousPage()
        }

        button_next.setOnClickListener {
            viewModel.nextPage()
        }

        progressBar.max = viewModel.lastScreens * progressBarScale

        lastPage = viewModel.firstScreen

        viewModel.currentScreen.observe(this, Observer { currentScreen ->

            if (lastPage > currentScreen) {
                animateMotionHeader(currentScreen + 1, currentScreen)
                animateProgressBar(currentScreen + 1, currentScreen)
            } else {
                animateMotionHeader(currentScreen - 1, currentScreen)
                animateProgressBar(currentScreen - 1, currentScreen)
            }
            lastPage = currentScreen


            when (currentScreen) {
                1 -> navigateTo(IntroFragment1.newInstance())
                2 -> navigateTo(IntroFragment2.newInstance())
                3 -> navigateTo(IntroFragmentRotation.newInstance(false))
                4 -> navigateTo(IntroFragmentRotation.newInstance(true))
                5 -> navigateTo(IntroFragmentPizza.newInstance(false))
                6 -> navigateTo(IntroFragmentPizza.newInstance(true))
            }

            button_previous.isEnabled = currentScreen != viewModel.firstScreen
            button_next.isEnabled = currentScreen != viewModel.lastScreens
        })

    }

    private fun animateMotionHeader(from: Int, to: Int) {

        val anim = InterpolationAnimation(
            motionLayout,
            ((1F * (from - 1)) / (viewModel.lastScreens - 1)),
            ((1F * (to - 1)) / (viewModel.lastScreens - 1))
        )
        anim.duration = 500
        motionLayout.startAnimation(anim)
    }

    private fun animateProgressBar(from: Int, to: Int) {
        val anim = ProgressBarAnimation(
            progressBar,
            from.toFloat() * progressBarScale,
            to.toFloat() * progressBarScale
        )
        anim.duration = 500
        progressBar.startAnimation(anim)
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}