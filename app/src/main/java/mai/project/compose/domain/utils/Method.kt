package mai.project.compose.domain.utils

import android.util.Log
import mai.project.compose.BuildConfig

object Method {

    fun logE(
        message: String,
        throwable: Throwable? = null,
        tag: String? = null,
    ){
        if(BuildConfig.DEBUG) {
            val className = Throwable().stackTrace[2].className
            val simpleClassName = tag ?: className.substringAfterLast('.')
            Log.e(simpleClassName, message, throwable)
        }
    }
}