package mai.project.compose.presentation.course_2.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import mai.project.compose.R
import mai.project.compose.core.Explain_Immutable_Stable
import kotlin.random.Random

/**
 * @see Immutable 說明 [Explain_Immutable_Stable]
 */
@Immutable
data class Place(
    val id: Long,
    val description: String,
    @DrawableRes val imgRes: Int,
    val rating: Double = Random.nextDouble(0.0, 10.0),
    val price: Int = Random.nextInt(500)
) {
    @Immutable
    data class Properties(
        val color: Color,
        val comment: String,
        val starRating: Int
    )

    /**
     * 取得屬性
     */
    val properties: Properties
        get() {
            return when (rating) {
                in 8.0..10.0 -> Properties(
                    color = Color(color = 0xff4CAF50),
                    comment = "Very good",
                    starRating = 5
                )

                in 6.0..8.0 -> Properties(
                    color = Color(color = 0xff2196F3),
                    comment = "Good",
                    starRating = 4
                )

                in 4.0..6.0 -> Properties(
                    color = Color(color = 0xffFFEB3B),
                    comment = "Mediocre",
                    starRating = 3
                )

                in 2.0..4.0 -> Properties(
                    color = Color(color = 0xffFF9800),
                    comment = "Bad",
                    starRating = 2
                )

                else -> Properties(
                    color = Color(color = 0xffF44336),
                    comment = "Very bad",
                    starRating = 1
                )
            }
        }
}

val places = listOf(
    Place(
        id = 1,
        description = "Place 1",
        imgRes = R.drawable.landscape1
    ),
    Place(
        id = 2,
        description = "Place 2",
        imgRes = R.drawable.landscape2
    ),
    Place(
        id = 3,
        description = "Place 3",
        imgRes = R.drawable.landscape3
    ),
    Place(
        id = 4,
        description = "Place 4",
        imgRes = R.drawable.landscape4
    ),
    Place(
        id = 5,
        description = "Place 5",
        imgRes = R.drawable.landscape5
    ),
    Place(
        id = 6,
        description = "Place 6",
        imgRes = R.drawable.landscape6
    ),
    Place(
        id = 7,
        description = "Place 7",
        imgRes = R.drawable.landscape7
    ),
    Place(
        id = 8,
        description = "Place 8",
        imgRes = R.drawable.landscape8
    ),
    Place(
        id = 9,
        description = "Place 9",
        imgRes = R.drawable.landscape9
    ),
    Place(
        id = 10,
        description = "Place 10",
        imgRes = R.drawable.landscape10
    )
)
