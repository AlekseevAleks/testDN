package ru.lexxdroid.testdn.presentation.error

import android.util.Log

object ErrorUtils {

    fun onError(throwable: Throwable) {
        logError("Unexpected Error", throwable)
    }

    private fun logError(message: String, throwable: Throwable) {
        Log.e("testdn", "$message: ${throwable.printStackTrace()}")
    }
}