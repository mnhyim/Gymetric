package com.mnhyim.gymetric.ui.feature.exercise.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowLeft
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mnhyim.gymetric.domain.model.DateItem
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeeklyDate(
    dates: List<DateItem>,
    selectedDate: LocalDate,
    onClick: (LocalDate) -> Unit,
    onNext: () -> Unit,
    onPrev: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clip(RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp))
    ) {
        TopAppBar(
            title = {
                Row {
                    Column {
                        Text(
                            text = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text(
                            text = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")),
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = onPrev) {
                        Icon(Icons.AutoMirrored.Filled.ArrowLeft, "")
                    }
                    IconButton(onClick = onNext) {
                        Icon(Icons.AutoMirrored.Filled.ArrowRight, "")
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        Row(
            modifier = modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp, 8.dp, 16.dp, 16.dp)
        ) {
            dates.forEach { date ->
                WeeklyItem(
                    date = date,
                    isSelected = date.date == selectedDate,
                    onClick = { onClick(date.date) },
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f)
                )
            }
        }
    }
}