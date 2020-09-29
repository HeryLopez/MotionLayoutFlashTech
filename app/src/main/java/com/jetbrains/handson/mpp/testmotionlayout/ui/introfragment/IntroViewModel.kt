package com.jetbrains.handson.mpp.testmotionlayout.ui.introfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IntroViewModel : ViewModel() {
    val firstScreen: Int = 1
    val lastScreens: Int = 4

    private val _currentScreen = MutableLiveData(firstScreen)
    val currentScreen: LiveData<Int>
        get() {
            return _currentScreen
        }

    fun nextPage() {
        val currentValue = _currentScreen.value
        if (currentValue != null && currentValue - 1 <= lastScreens) {
            _currentScreen.value = currentValue + 1
        }
    }

    fun previousPage() {
        val currentValue = _currentScreen.value
        if (currentValue != null && currentValue - 1 >= firstScreen) {
            _currentScreen.value = currentValue - 1
        }
    }

}