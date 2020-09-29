package com.jetbrains.handson.mpp.testmotionlayout.common

import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ProgressBar
import androidx.constraintlayout.motion.widget.MotionLayout

class InterpolationAnimation(
    private val motion: MotionLayout,
    private val from: Float,
    private val to: Float
) : Animation() {

    override fun applyTransformation(
        interpolatedTime: Float,
        t: Transformation
    ) {
        super.applyTransformation(interpolatedTime, t)
        val value = from + (to - from) * interpolatedTime
        motion.progress = value
    }

}