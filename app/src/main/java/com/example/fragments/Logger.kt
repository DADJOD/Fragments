package com.example.fragments

import android.util.Log

object Logger {
    fun logMe() {
        val stack = Thread.currentThread().stackTrace
        Log.d("happyX", "${stack[3].className} ${stack[3].methodName} ${stack[3].lineNumber}")
    }

    fun logSomething(some: Any) {
        Log.d("happyX", "$some")
    }
}

//object Logger {
//    fun logMe() {
//        val stack = Thread.currentThread().stackTrace
//        Log.d("happy", stack[3].className + " " + stack[3].methodName)
//    }
//}
