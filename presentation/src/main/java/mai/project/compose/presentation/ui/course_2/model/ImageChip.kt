package mai.project.compose.presentation.ui.course_2.model

import android.net.Uri
import androidx.compose.runtime.Immutable
import mai.project.compose.core.ExplainImmutableStable

/**
 * @see Immutable 說明 [ExplainImmutableStable]
 */
@Immutable
data class ImageChip(
    val id: String,
    val text: String,
    val image: Uri,
)

val mockImageChip = ImageChip(
    id = "",
    text = "text",
    image = Uri.EMPTY
)
