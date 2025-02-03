package com.mnhyim.gymetric.ui.feature.settings.manage_muscle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mnhyim.gymetric.data.dao.MuscleGroupDao
import com.mnhyim.gymetric.data.entity.MuscleGroupEntity
import com.mnhyim.gymetric.domain.model.MuscleGroup
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageMuscleGroupViewModel @Inject constructor(
    private val muscleGroupDao: MuscleGroupDao
) : ViewModel() {

    private var _muscleGroup = MutableStateFlow(emptyList<MuscleGroup>())
    val muscleGroup = _muscleGroup.asStateFlow()

    init {
        viewModelScope.launch {
            muscleGroupDao.getAllMuscleGroup().collect {
                _muscleGroup.value = it.map { MuscleGroup(id = it.id, name = it.name) }
            }
        }
    }

    fun insert() {
        viewModelScope.launch {
            muscleGroupDao.insertMuscleGroup(
                MuscleGroupEntity(0, "AAA")
            )
        }
    }

    fun delete(muscleGroup: MuscleGroup) {
        viewModelScope.launch {
            muscleGroupDao.deleteMuscleGroup(MuscleGroupEntity(muscleGroup.id,muscleGroup.name))
        }
    }
}