package com.example.fragments

import android.util.Log

object Logger {
    fun logMe() {
        val stack = Thread.currentThread().stackTrace
        Log.d("happyX", "${stack[3].className} ${stack[3].methodName}")
    }
}

//object Logger {
//    fun logMe() {
//        val stack = Thread.currentThread().stackTrace
//        Log.d("happy", stack[3].className + " " + stack[3].methodName)
//    }
//}
