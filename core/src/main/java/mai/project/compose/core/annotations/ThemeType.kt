package mai.project.compose.core.annotations

import androidx.annotation.IntDef

@IntDef(
    ThemeType.DEFAULT,
    ThemeType.LIGHT,
    ThemeType.DARK
)
@Retention(AnnotationRetention.SOURCE)
/**
 * 系統的主題類型
 */
annotation class ThemeType {
    companion object {
        /**
         * 預設
         */
        const val DEFAULT = 0

        /**
         * 亮色模式
         */
        const val LIGHT = 1

        /**
         * 暗色模式
         */
        const val DARK = 2
    }
}
