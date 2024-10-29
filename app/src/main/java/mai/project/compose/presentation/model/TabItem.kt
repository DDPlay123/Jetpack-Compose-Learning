package mai.project.compose.presentation.model

/**
 * 首頁使用的 Tab 標籤
 */
data class TabItem(
    val title: String
) {
    companion object {
        /**
         * Tab 標籤的頁面
         */
        val getHomeTab
            get() = listOf(
                TabItem("Components"),
                TabItem("Material Widgets"),
                TabItem("Layout"),
                TabItem("State"),
                TabItem("Gesture"),
                TabItem("Graphics"),
                TabItem("Theming"),
                TabItem("Semantics"),
                TabItem("Animation")
            )
    }
}