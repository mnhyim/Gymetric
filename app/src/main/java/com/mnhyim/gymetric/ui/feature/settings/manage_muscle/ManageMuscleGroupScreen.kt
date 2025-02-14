package com.mnhyim.gymetric.ui.feature.settings.manage_muscle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.ui.feature.settings.components.AddMuscleGroupDialog
import com.mnhyim.gymetric.ui.feature.settings.components.MuscleGroupItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageMuscleGroupScreen(
    viewModel: ManageMuscleGroupViewModel = hiltViewModel(),
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showModal by remember { mutableStateOf(false) }
    val muscleGroup by viewModel.muscleGroup.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Add Muscle Group"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigate
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showModal = true },
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    ) { innerPadding ->
        if (showModal) {
            AddMuscleGroupDialog(
                onSave = { viewModel.insert(it) },
                onDismiss = { showModal = false },
            )
        }

        ManageMuscleGroupScreenContent(
            muscleGroup = muscleGroup,
            onDelete = { viewModel.delete(it) },
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp, 0.dp, 16.dp, 16.dp)
        )
    }
}

@Composable
private fun ManageMuscleGroupScreenContent(
    muscleGroup: List<MuscleGroup>,
    onDelete: (MuscleGroup) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = muscleGroup) {
                MuscleGroupItem(
                    item = it,
                    onDelete = { onDelete(it) }
                )
            }
        }
    }
}