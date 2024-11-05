package mai.project.compose.presentation.home.model

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
     * @param index 索引
     * @param title 標題
     * @param content 內容描述
     */
    data class Course(
        val index: String,
        val title: String,
        val content: String
    )
}

/**
 * 取得 Tab 標籤的資訊
 */
val getHomeTab = listOf(
    TabItem(
        title = "Components",
        courses = listOf(
            TabItem.Course(
                index = "1-1",
                title = "Column, Row, Box, Spacer",
                content = "建立 Rows、Columns、Box 和 Spacer，如何為 composable 元件添加修飾符。設定 padding、margin、對齊方式及其他屬性。"
            ),
            TabItem.Course(
                index = "1-2",
                title = "Surface, Shape, Clickable",
                content = "建立並修改 Surface 來為 Composable 元件繪製背景，為任何 Composable 元件添加點擊操作。設置 weight 或 offset 修飾符。"
            )
        )
    ),
    TabItem(
        title = "Material Widgets",
        courses = listOf(
            TabItem.Course(
                index = "2-1",
                title = "Text",
                content = "建立具有不同屬性的文字組件，如顏色、背景、字重、字體、字型樣式、字間距等。"
            ),
            TabItem.Course(
                index = "2-2",
                title = "Button",
                content = "建立 文字/圖片按鈕、FAB 按鈕 或 Chips。修改按鈕的屬性，例如顏色、文字或狀態。"
            ),
            TabItem.Course(
                index = "2-3",
                title = "TextField",
                content = "建立具有常規樣式或輪廓樣式的 TextField 組件。設置錯誤提示、顏色、狀態、圖標、電話或信用卡的視覺轉換，以及 IME 操作。"
            ),
            TabItem.Course(
                index = "2-4",
                title = "Image",
                content = "建立用於顯示圖片的 Image 組件，設置圖片和裁剪樣式。更改 Image 的形狀或應用 ColorFilter 和 PorterDuff 模式。"
            ),
            TabItem.Course(
                index = "2-5-1",
                title = "LazyColumn1",
                content = "LazyColumn 是 Compose 中垂直 RecyclerView 的對應組件。"
            ),
            TabItem.Course(
                index = "2-5-2",
                title = "LazyColumn2",
                content = "LazyColumn 滾動狀態和修改動態列表。"
            ),
            TabItem.Course(
                index = "2-5-3",
                title = "LazyRow",
                content = "LazyRow 是 Compose 中水平 RecyclerView 的對應組件。"
            ),
            TabItem.Course(
                index = "2-5-4",
                title = "StickyHeader",
                content = "帶有 StickyHeaders 的 LazyColumn。"
            ),
            TabItem.Course(
                index = "2-5-5",
                title = "LazyVerticalGrid",
                content = "網格樣式的項目顯示。"
            ),
            TabItem.Course(
                index = "2-5-6",
                title = "Dynamic LazyVerticalGrid",
                content = "具有動態高度的 LazyGridLayout。"
            ),
            TabItem.Course(
                index = "2-5-7",
                title = "ListItem",
                content = "使用內建的 ListItem 組件創建單行、雙行、三行列表項目，或結合其他組件來構建列表項目。"
            ),
            TabItem.Course(
                index = "2-5-8",
                title = "LazyListLayoutInfo",
                content = "使用 LazyLayoutState 的 LazyListLayoutInfo 獲取有關 LazyRow/LazyColumn 的元數據。"
            ),
            TabItem.Course(
                index = "2-6",
                title = "TopAppbar&Tabs",
                content = "頂部應用欄顯示與當前畫面相關的資訊和操作。"
            )
        )
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