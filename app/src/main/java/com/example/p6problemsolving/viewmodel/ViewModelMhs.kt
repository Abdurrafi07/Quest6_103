package com.example.p6problemsolving.viewmodel

import androidx.lifecycle.ViewModel
import com.example.p6problemsolving.ui.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelMhs : ViewModel() {
    //Request
    private val _statusUI = MutableStateFlow(Mahasiswa())

    //Respone
    val statusUI: StateFlow<Mahasiswa> = _statusUI.asStateFlow()

    fun saveDataMhs(ls: MutableList<String>){
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                email = ls[2],
            )
        }
    }
}