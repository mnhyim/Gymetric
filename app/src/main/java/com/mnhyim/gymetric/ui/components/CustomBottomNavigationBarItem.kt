package com.mnhyim.gymetric.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomBottomNavigationBarItem(
    selected: Boolean,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = icon,
        contentDescription = "",
        tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
        modifier = modifier
            .padding(horizontal = 4.dp)
            .clip(RoundedCornerShape(16.dp))
//            .background(color = if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.05f) else Color.Unspecified)
            .clickable { onClick() }
            .padding(vertical = 8.dp)
    )
}