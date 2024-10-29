package mai.project.compose.presentation.home.model

import android.content.Context
import mai.project.compose.R

/**
 * 首頁使用的 Tab 標籤
 *
 * @param title Tab 標籤的文字
 * @param courses Tab 標籤的內容
 */
data class TabItem(
    val title: String,
    val courses: List<Course>
) {
    /**
     * 學習課程目錄
     *
     * @param title 標題
     * @param content 內容描述
     */
    data class Course(
        val title: String,
        val content: String
    )
}

/**
 * 取得 Tab 標籤的資訊
 *
 * @param context [Context]
 */
fun getHomeTab(context: Context) = listOf(
    TabItem(
        title = "Components",
        courses = listOf(
            TabItem.Course(
                title = context.getString(R.string.course_1_1_title),
                content = context.getString(R.string.course_1_1_content)
            ),
            TabItem.Course(
                title = context.getString(R.string.course_1_2_title),
                content = context.getString(R.string.course_1_2_content)
            )
        )
    ),
    TabItem(
        title = "Material Widgets",
        courses = emptyList()
    ),
    TabItem(
        title = "Layout",
        courses = emptyList()
    ),
    TabItem(
        title = "State",
        courses = emptyList()
    ),
    TabItem(
        title = "Gesture",
        courses = emptyList()
    ),
    TabItem(
        title = "Graphics",
        courses = emptyList()
    ),
    TabItem(
        title = "Theming",
        courses = emptyList()
    ),
    TabItem(
        title = "Semantics",
        courses = emptyList()
    ),
    TabItem(
        title = "Animation",
        courses = emptyList()
    )
)