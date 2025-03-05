@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.course_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import mai.project.compose.presentation.R
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme
import mai.project.compose.presentation.ui.course_2.components_2_5.SnackCard
import mai.project.compose.presentation.ui.course_2.model.snacks

@Composable
fun Course_2_10_1_ScreenRoot() {
    Course_2_10_1_Screen()
}

@Composable
private fun Course_2_10_1_Screen(
    modifier: Modifier = Modifier,
) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.PartiallyExpanded
        )
    )

    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        sheetPeekHeight = 70.dp,
        topBar = { TopBar(scaffoldState = scaffoldState) },
        sheetContent = { SheetContent() }
    ) { paddingValues ->
        Content(
            innerPadding = paddingValues,
            bottomSheetState = scaffoldState.bottomSheetState
        )
    }
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    scaffoldState: BottomSheetScaffoldState,
) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        modifier = modifier,
        title = { Text("BottomSheetScaffold") },
        actions = {
            IconButton(
                onClick = {
                    scope.launch {
                        if (scaffoldState.bottomSheetState.currentValue == SheetValue.Expanded) {
                            scaffoldState.bottomSheetState.partialExpand()
                        } else {
                            scaffoldState.bottomSheetState.expand()
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.vector_expand),
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
private fun SheetContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxHeight(.5f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = "Places to Visit",
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            color = Color(0xffFDD835),
            fontSize = 24.sp
        )
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(snacks) { snack ->
                SnackCard(snack = snack)
            }
        }
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    bottomSheetState: SheetState,
) {
    val offset = try {
        bottomSheetState.requireOffset()
    } catch (e: Exception) {
        Offset.Zero
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xff6D4C41))
            .padding(innerPadding)
            .padding(8.dp)
    ) {
        Text(
            color = Color.White,
            text = "isExpanded: ${bottomSheetState.hasExpandedState}\n" +
                    "currentValue: ${bottomSheetState.currentValue}\n" +
                    "targetValue: ${bottomSheetState.targetValue}\n" +
                    "offset: $offset"
        )
    }
}

@PreviewLightDark
@Composable
private fun Course_2_10_1_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_10_1_Screen()
    }
}