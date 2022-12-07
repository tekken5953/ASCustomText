package com.aslib

class NativeLib {

    /**
     * A native method that is implemented by the 'aslib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'aslib' library on application startup.
        init {
            System.loadLibrary("aslib")
        }
    }
}