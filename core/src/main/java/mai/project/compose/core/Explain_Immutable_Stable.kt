package mai.project.compose.core

/**
 * 說明用：@Immutable 用於標記不可變的類別，以便在 Compose 在重組過程中優化性能
 *
 * - 主要用於幫助 Compose 確保在狀態不變的情況下，不重組不必要的部分
 * - 使用場景：當此類用於設定數據或配置參數、或僅用於初始化使用的類
 *
 * ```
 * // @Immutable 與 @Stable 想輔相成，前者強調完全不可變，後者允續可追蹤的可變狀態
 *
 * @Immutable
 * data class Address(val city: String, val street: String)
 *
 * @Stable
 * class MutableUserProfile(var name: String, var age: Int)
 * ```
 *
 * 重要說明：
 * 1. 當使用 @Immutable 時，使用 copy 重新賦值，對於 MutableState 會判斷為新的物件，這樣會使組件重組
 *      - 比如說 Address 的兩個參數分別應用到不同的組件上，但使用 copy 重新賦值給 Address 物件的 city 參數，這樣一樣會使兩個組件重組
 * 2. 要解決上一點的問題，使用 @Stable 並將參數改為使用 var，這樣就能讓 Compose 識別到具體的參數變化，只讓特定的元件進行更新
 */
data object Explain_Immutable_Stable