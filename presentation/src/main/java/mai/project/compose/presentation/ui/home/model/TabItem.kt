package mai.project.compose.presentation.ui.home.model

/**
 * 首頁使用的 Tab 標籤
 *
 * @param title Tab 標籤的文字
 * @param courses Tab 標籤的內容
 */
data class TabItem(
    val title: String,
    val courses: List<Course>,
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
        val content: String,
    )
}

/**
 * 取得 Tab 標籤的資訊
 */
val getHomeTab = listOf(
    TabItem(
        title = "Bonus",
        courses = listOf(
            TabItem.Course(
                index = "0-1",
                title = "Slider",
                content = ""
            )
        )
    ),
    TabItem(
        title = "Components",
        courses = listOf(
            TabItem.Course(
                index = "1-1",
                title = "Column, Row, Box, Spacer",
                content = "建立 Rows、Columns、Box 和 Spacer，以及如何為 Composable 元件添加修飾符。設定 padding、margin、對齊方式及其他屬性。"
            ),
            TabItem.Course(
                index = "1-2",
                title = "Surface, Shape, Clickable",
                content = "建立 Surface 來為 Composable 元件繪製背景及外觀 (Shape)，並為元件添加點擊操作。設置 weight 或 offset 修飾符。"
            )
        )
    ),
    TabItem(
        title = "Material Widgets",
        courses = listOf(
            TabItem.Course(
                index = "2-1",
                title = "Text",
                content = "建立具有不同屬性的 Text 元件，如顏色、背景、字重、字體、字型樣式、字間距等。"
            ),
            TabItem.Course(
                index = "2-2",
                title = "Button, Chip",
                content = "建立 Text/Icon 按鈕、FAB 按鈕 及 Chips。修改按鈕的屬性，例如顏色、文字或狀態。"
            ),
            TabItem.Course(
                index = "2-3",
                title = "TextField",
                content = "建立具有常規樣式或輪廓樣式的 TextField 元件。設置錯誤提示、顏色、狀態、圖標、電話或信用卡的視覺轉換，以及 IME 操作。"
            ),
            TabItem.Course(
                index = "2-4",
                title = "Image",
                content = "建立用於顯示圖片的 Image 元件，設置圖片和裁剪樣式。更改 Image 的形狀或應用 ColorFilter 和 PorterDuff 模式。"
            ),
            TabItem.Course(
                index = "2-5-1",
                title = "LazyColumn1",
                content = "LazyColumn 是 Compose 中垂直 RecyclerView LinearLayoutManager 的對應組件。"
            ),
            TabItem.Course(
                index = "2-5-2",
                title = "LazyColumn2",
                content = "LazyColumn 滾動狀態和修改動態列表。"
            ),
            TabItem.Course(
                index = "2-5-3",
                title = "LazyRow",
                content = "LazyRow 是 Compose 中水平 RecyclerView LinearLayoutManager 的對應組件。"
            ),
            TabItem.Course(
                index = "2-5-4",
                title = "StickyHeader",
                content = "帶有 StickyHeaders 的 LazyColumn。"
            ),
            TabItem.Course(
                index = "2-5-5",
                title = "LazyVerticalGrid",
                content = "LazyVerticalGrid 是 Compose 中垂直 RecyclerView GridLayoutManager 的對應組件。"
            ),
            TabItem.Course(
                index = "2-5-6",
                title = "Dynamic LazyVerticalGrid",
                content = "具有動態調整高度的 LazyGridLayout。"
            ),
            TabItem.Course(
                index = "2-5-7",
                title = "ListItem",
                content = "使用內建的 ListItem 組件創建單行、雙行、三行列表項目，或結合其他組件來構建列表項目。"
            ),
            TabItem.Course(
                index = "2-5-8",
                title = "LazyListState.LazyListLayoutInfo",
                content = "使用 LazyListState 的 LazyListLayoutInfo 獲取有關 LazyRow/LazyColumn 的元數據。"
            ),
            TabItem.Course(
                index = "2-6",
                title = "TopAppbar, Tabs",
                content = "頂部 ActionBar 與 TabRow。"
            ),
            TabItem.Course(
                index = "2-7",
                title = "底部的 NavigationBar",
                content = "NavigationBar 等同於 BottomNavigationView 元件，並使用 NavigationBarItem 製作項目樣式。"
            ),
            TabItem.Course(
                index = "2-8",
                title = "底部的 BottomAppBar",
                content = "使用 Scaffold 的 BottomAppBar 實現底部導覽功能。"
            ),
            TabItem.Course(
                index = "2-9-1",
                title = "側邊的 ModalNavigationDrawer",
                content = "ModalNavigationDrawer 等同於 DrawerLayout 元件，並使用 ModalDrawerSheet 創建側邊工作表。"
            ),
            TabItem.Course(
                index = "2-9-2",
                title = "ModalNavigationDrawer2",
                content = "ModalNavigationDrawer 位於 Scaffold 的內容區域。"
            ),
            TabItem.Course(
                index = "2-10-1",
                title = "BottomSheetScaffold",
                content = "使用 BottomSheetScaffold 和 rememberBottomSheetScaffoldState 創建底部工作表 (Bottom Sheet)。\n" +
                        "BottomSheetScaffold 類似於使用 BottomSheetBehavior 控制的 Layout。"
            ),
            TabItem.Course(
                index = "2-10-2",
                title = "ModalBottomSheet",
                content = "使用 ModalBottomSheet 和 rememberModalBottomSheetState 創建模態底部工作表 (Modal Bottom Sheet)。\n" +
                        "ModalBottomSheet 類似於 BottomSheetDialog。"
            ),
            TabItem.Course(
                index = "2-11",
                title = "Snackbar, Progress, Selector, Slider",
                content = "範例包含：Snackbar、Progress、CheckBox、TriStateCheckBox、Switch、RadioButton（含群組）、Slider"
            ),
            TabItem.Course(
                index = "2-12",
                title = "Dialog",
                content = "範例包含：AlertDialog 和 Dialog"
            ),
            TabItem.Course(
                index = "2-13",
                title = "SwipeToDismiss",
                content = "創建可透過向左或向右滑動來關閉的可組合項 (Composable)"
            ),
            TabItem.Course(
                index = "2-14",
                title = "LazyColumn Checkbox",
                content = "帶有 CheckBox 的 LazyColumn，可勾選和取消勾選項目"
            ),
            TabItem.Course(
                index = "2-15",
                title = "Chip and TextField",
                content = "在輸入文字並選擇圖片後新增 Chips"
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
        courses = listOf(
            TabItem.Course(
                index = "7-1",
                title = "Dark & Light Mode",
                content = "切換系統的亮色或暗色模式。"
            )
        )
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