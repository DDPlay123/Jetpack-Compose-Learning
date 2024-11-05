package mai.project.compose.presentation.course_2.model

import androidx.compose.runtime.Immutable
import mai.project.compose.domain.ExplainImmutableAndStable

/**
 * @see Immutable 說明 [ExplainImmutableAndStable]
 */
@Immutable
data class Snack(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val price: Long,
    val tagline: String = "",
    val tags: Set<String> = emptySet()
)

val snacks = listOf(
    Snack(
        id = 1L,
        name = "Cupcake",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54117357372_aed1dfdd1e_m.jpg",
        price = 299
    ),
    Snack(
        id = 2L,
        name = "Donut",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54117358057_8bbd0c5625_m.jpg",
        price = 299
    ),
    Snack(
        id = 3L,
        name = "Eclair",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54118216791_fb94ef6594_m.jpg",
        price = 299
    ),
    Snack(
        id = 4L,
        name = "Froyo",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54118217991_2e797ee114_m.jpg",
        price = 299
    ),
    Snack(
        id = 5L,
        name = "Gingerbread",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54118488283_15344ed082_m.jpg",
        price = 499
    ),
    Snack(
        id = 6L,
        name = "Honeycomb",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54118489288_18915e9d53_m.jpg",
        price = 299
    ),
    Snack(
        id = 7L,
        name = "Ice Cream Sandwich",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54118489743_576430a3f5_m.jpg",
        price = 1299
    ),
    Snack(
        id = 8L,
        name = "Jellybean",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54118490363_5a4e63f3d1_m.jpg",
        price = 299
    ),
    Snack(
        id = 9L,
        name = "KitKat",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54118550279_9901a252c4_m.jpg",
        price = 549
    ),
    Snack(
        id = 10L,
        name = "Lollipop",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54118550329_e36da62b1d_m.jpg",
        price = 299
    ),
    Snack(
        id = 11L,
        name = "Marshmallow",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54118551484_a6c25bdeaf_m.jpg",
        price = 299
    ),
    Snack(
        id = 12L,
        name = "Nougat",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54118552454_4bd0d59dd0_m.jpg",
        price = 299
    ),
    Snack(
        id = 13L,
        name = "Oreo",
        tagline = "A tag line",
        imageUrl = "https://live.staticflickr.com/65535/54118552534_9c07618c5b_m.jpg",
        price = 299
    )
)

val snacksOrdered = snacks.sortedBy {
    it.name.first()
}
