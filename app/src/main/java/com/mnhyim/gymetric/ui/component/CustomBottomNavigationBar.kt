package com.mnhyim.gymetric.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.mnhyim.gymetric.checkCurrentRoute
import com.mnhyim.gymetric.ui.navigation.BottomNavBarDestination
import com.mnhyim.gymetric.ui.navigation.Routes

@Composable
fun CustomBottomNavigationBar(
    checkCurrentRoute: (Routes) -> Boolean,
    onClick: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        shape = RectangleShape,
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        )
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp)
        ) {
            BottomNavBarDestination.entries.toTypedArray().onEach {
                CustomBottomNavigationBarItem(
                    selected = checkCurrentRoute(it.route),
                    icon = it.icon,
                    onClick = { onClick(it.route) },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

}