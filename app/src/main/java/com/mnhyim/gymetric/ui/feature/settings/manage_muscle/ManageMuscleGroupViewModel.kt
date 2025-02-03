package com.mnhyim.gymetric.ui.feature.settings.manage_muscle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.domain.repository.MuscleGroupRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageMuscleGroupViewModel @Inject constructor(
    private val muscleGroupRepository: MuscleGroupRepository
) : ViewModel() {

    private var _muscleGroup = MutableStateFlow(emptyList<MuscleGroup>())
    val muscleGroup = _muscleGroup.asStateFlow()

    init {
        viewModelScope.launch {
            muscleGroupRepository.getAllMuscleGroup().collect {
                _muscleGroup.value = it.map { MuscleGroup(id = it.id, name = it.name) }
            }
        }
    }

    fun insert() {
        viewModelScope.launch {
            muscleGroupRepository.insertMuscleGroup(
                MuscleGroup(0, "AAA")
            )
        }
    }

    fun delete(muscleGroup: MuscleGroup) {
        viewModelScope.launch {
            muscleGroupRepository.deleteMuscleGroup(muscleGroup)
        }
    }
}