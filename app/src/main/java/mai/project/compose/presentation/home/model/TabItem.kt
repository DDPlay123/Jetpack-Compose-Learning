package mai.project.compose.presentation.home.model

import android.content.Context
import mai.project.compose.R

/**
 * 首頁使用的 Tab 標籤
 *
 * @param index Tab 標籤的索引
 * @param title Tab 標籤的文字
 * @param courses Tab 標籤的內容
 */
data class TabItem(
    val index: Int,
    val title: String,
    val courses: List<Course>
) {
    /**
     * 學習課程目錄
     *
     * @param index 索引
     * @param title 標題
     * @param content 內容描述
     */
    data class Course(
        val index: Int,
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
        index = 1,
        title = "Components",
        courses = listOf(
            TabItem.Course(
                index = 1,
                title = context.getString(R.string.course_1_1_title),
                content = context.getString(R.string.course_1_1_content)
            ),
            TabItem.Course(
                index = 2,
                title = context.getString(R.string.course_1_2_title),
                content = context.getString(R.string.course_1_2_content)
            )
        )
    ),
    TabItem(
        index = 2,
        title = "Material Widgets",
        courses = emptyList()
    ),
    TabItem(
        index = 3,
        title = "Layout",
        courses = emptyList()
    ),
    TabItem(
        index = 4,
        title = "State",
        courses = emptyList()
    ),
    TabItem(
        index = 5,
        title = "Gesture",
        courses = emptyList()
    ),
    TabItem(
        index = 6,
        title = "Graphics",
        courses = emptyList()
    ),
    TabItem(
        index = 7,
        title = "Theming",
        courses = emptyList()
    ),
    TabItem(
        index = 8,
        title = "Semantics",
        courses = emptyList()
    ),
    TabItem(
        index = 9,
        title = "Animation",
        courses = emptyList()
    )
)