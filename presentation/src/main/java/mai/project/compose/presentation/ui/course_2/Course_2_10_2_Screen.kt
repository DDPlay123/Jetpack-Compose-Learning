@file:OptIn(ExperimentalMaterial3Api::class)

package mai.project.compose.presentation.ui.course_2

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mai.project.compose.presentation.R
import mai.project.compose.presentation.theme.Jetpack_Compose_LearningTheme

@Composable
fun Course_2_10_2_ScreenRoot() {
    Course_2_10_2_Screen()
}

@Composable
private fun Course_2_10_2_Screen(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier,
        topBar = { TopBar(onExpandClick = { openBottomSheet = !openBottomSheet }) }
    ) { paddingValues ->
        Content(
            innerPadding = paddingValues,
            bottomSheetState = bottomSheetState
        )
        if (openBottomSheet) {
            BottomSheetContent(
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                sheetState = bottomSheetState,
                onDismissRequest = { openBottomSheet = false },
                onItemClick = { name ->
                    Toast.makeText(context, "Selected $name", Toast.LENGTH_SHORT).show()
                    scope.launch {
                        bottomSheetState.hide()
                    }.invokeOnCompletion {
                        if (!bottomSheetState.isVisible) {
                            openBottomSheet = false
                        }
                    }
                }
            )
        }
    }
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onExpandClick: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = { Text("ModalBottomSheet") },
        actions = {
            IconButton(
                onClick = onExpandClick
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
private fun BottomSheetContent(
    modifier: Modifier = Modifier,
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    onItemClick: (String) -> Unit,
) {
    ModalBottomSheet(
        modifier = modifier,
        sheetState = sheetState,
        onDismissRequest = onDismissRequest,
        containerColor = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            items(20) { index ->
                val name = "User - $index"
                ListItem(
                    modifier = Modifier
                        .clickable { onItemClick.invoke(name) },
                    headlineContent = {
                        Text(text = name)
                    },
                    leadingContent = {
                        Icon(
                            modifier = Modifier.size(40.dp),
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = null
                        )
                    }
                )
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
private fun Course_2_10_2_ScreenPreview() {
    Jetpack_Compose_LearningTheme {
        Course_2_10_2_Screen()
    }
}