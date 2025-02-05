package com.mnhyim.gymetric.ui.feature.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.mnhyim.gymetric.domain.model.MuscleGroup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MuscleGroupDropdown(
    muscleGroups: List<MuscleGroup>,
    selectedMuscleGroup: Long,
    onSelect: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }
        ) {
            OutlinedTextField(
                value = muscleGroups.find { it.id == selectedMuscleGroup }?.name ?: "",
                onValueChange = {},
                label = {
                    Text(
                        text = "Muscle Group",
                        style = MaterialTheme.typography.bodySmall
                    )
                },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                readOnly = true,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = Modifier
                    .wrapContentHeight()
                    .heightIn(max = LocalConfiguration.current.screenHeightDp.dp * 0.15f)
                    .background(MaterialTheme.colorScheme.surfaceContainerHigh)
            ) {
                repeat(muscleGroups.size) {
                    Text(
                        text = muscleGroups[it].name,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                            .clickable {
                                onSelect(muscleGroups[it].id)
                                isExpanded = false
                            }
                            .padding(8.dp, 12.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}