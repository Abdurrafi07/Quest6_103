package com.example.p6problemsolving.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun RencanaStudyView(){
    var choesenDropdown by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf("") }
    var pilihanKelas by remember { mutableStateOf("") }

    val listData: MutableList<String> = mutableListOf(choesenDropdown, pilihanKelas)


}