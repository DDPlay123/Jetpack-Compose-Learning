@file:OptIn(ExperimentalLayoutApi::class)

package mai.project.compose.presentation.course_2.components_2_2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mai.project.compose.R
import mai.project.compose.ui.theme.Jetpack_Compose_LearningTheme

@Composable
fun ChipExample(
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier
            .fillMaxWidth(),
        maxItemsInEachRow = 3,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AssistChip(
            onClick = {},
            label = {
                Text("AssistChip")
            }
        )

        AssistChip(
            onClick = {},
            enabled = false,
            label = {
                Text("Disabled AssistChip")
            }
        )

        AssistChip(
            onClick = {},
            border = BorderStroke(1.dp, Color.Green.copy(alpha = .9f)),
            colors = AssistChipDefaults.assistChipColors().copy(
                containerColor = Color.Blue,
                labelColor = Color.White
            ),
            label = {
                Text("Colored AssistChip")
            }
        )

        AssistChip(
            onClick = {},
            shape = RoundedCornerShape(50.dp),
            label = {
                Row(
                    modifier = Modifier.border(1.dp, Color.Red),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("AssistChip")
                }
            },
            leadingIcon = {
                Image(
                    painter = painterResource(R.drawable.avatar_1_raster),
                    modifier = Modifier
                        .border(1.dp, Color.Green)
                        .size(AssistChipDefaults.IconSize)
                        .clip(CircleShape),
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Gray.copy(alpha = .6f))
                        .size(20.dp)
                        .padding(4.dp),
                    imageVector = Icons.Filled.Close,
                    tint = Color(0xFFE0E0E0),
                    contentDescription = null
                )
            }
        )

        AssistChip(
            onClick = {},
            shape = RoundedCornerShape(36),
            border = BorderStroke(1.dp, Color(0xff66BB6A).copy(alpha = .9f)),
            colors = AssistChipDefaults.assistChipColors(
                containerColor = Color(0xff66BB6A),
                labelColor = Color.White
            ),
            leadingIcon = {
                Image(
                    painter = painterResource(R.drawable.avatar_1_raster),
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape),
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Black.copy(alpha = .6f))
                        .size(20.dp)
                        .padding(4.dp),
                    imageVector = Icons.Filled.Close,
                    tint = Color(0xFFE0E0E0),
                    contentDescription = null
                )
            },
            label = {
                Text("AssistChip")
            }
        )
    }
}

@Preview
@Composable
private fun ChipExamplePreview() {
    Jetpack_Compose_LearningTheme {
        ChipExample()
    }
}