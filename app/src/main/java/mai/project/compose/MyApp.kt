package mai.project.compose

import android.app.Application
import mai.project.compose.data.di.dataModule
import mai.project.compose.domain.di.domainModule
import mai.project.compose.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // 設定 Debug 模式
        setupDebugMode()

        // 設定 Koin
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MyApp)
            // Load modules
            modules(
                listOf(
                    presentationModule,
                    domainModule,
                    dataModule
                )
            )
        }
    }

    /**
     * 設定 Debug 模式
     */
    private fun setupDebugMode() {
        if (BuildConfig.DEBUG) {
            // 設定 Timber
            Timber.plant(tagTree)
        }
    }

    companion object {
        /**
         * Timber 的 TagTree
         */
        private val tagTree: Timber.Tree
            get() {
                return object : Timber.DebugTree() {
                    override fun createStackElementTag(element: StackTraceElement): String =
                        "[${element.fileName}:${element.lineNumber}:${element.methodName}]"

                    override fun log(priority: Int, message: String?, vararg args: Any?) {
                        var adjustedMessage = message
                        message?.let { msg ->
                            val maxLength = 1000 // 最大長度

                            // 超過最大長度，就截斷
                            if (msg.length > maxLength) {
                                adjustedMessage = msg.substring(0, maxLength) + "…"
                            }
                        }
                        super.log(priority, adjustedMessage, *args)
                    }
                }
            }
    }
}