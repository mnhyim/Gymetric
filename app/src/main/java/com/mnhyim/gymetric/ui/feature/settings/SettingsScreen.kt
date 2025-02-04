package com.mnhyim.gymetric.ui.feature.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mnhyim.gymetric.ui.feature.settings.components.SettingItemEntry
import com.mnhyim.gymetric.ui.navigation.Routes
import com.mnhyim.gymetric.ui.util.SettingsItemEnum

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Settings",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ) { innerPadding ->
        SettingsScreenContent(
            onNavigate = { onNavigate(it) },
            modifier = modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun SettingsScreenContent(
    onNavigate: (Routes) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items = SettingsItemEnum.entries.toTypedArray()) {
            SettingItemEntry(
                icon = it.icon,
                title = it.title,
                subtitle = it.subtitle,
                onClick = { onNavigate(it.route) }
            )
        }
    }
}