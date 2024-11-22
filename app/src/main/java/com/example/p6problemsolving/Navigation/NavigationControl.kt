package com.example.p6problemsolving.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p6problemsolving.ui.view.FormMhsView
import com.example.p6problemsolving.ui.view.MainScreen
import com.example.p6problemsolving.ui.view.RencanaStudyView
import com.example.p6problemsolving.viewmodel.RencanaStudyViewModel
import com.example.p6problemsolving.viewmodel.ViewModelMhs

enum class Halaman{
    MAIN,
    FORMMHS,
    MATKUL,
    TAMPILDATA
}

@Composable
fun NavigationControl(modifier: Modifier = Modifier,
                      viewModel: ViewModelMhs = viewModel(),
                      krsViewModel: RencanaStudyViewModel = viewModel(),
                      navHost: NavHostController = rememberNavController()
){
    val uiState by viewModel.statusUI.collectAsState()
    NavHost(
        navController = navHost,
        startDestination = Halaman.MAIN.name,
        modifier = Modifier.padding()
    ) {
        composable(route = Halaman.MAIN.name){
            MainScreen(onMulaiButton = {
                navHost.navigate(
                    Halaman.FORMMHS.name
                )
            })
        }
        composable(route = Halaman.FORMMHS.name){
            FormMhsView(
                onSumbitButtonClicked = {
                viewModel.saveDataMhs(it)
                navHost.navigate(Halaman.MATKUL.name)
            },
                onBackButtonClicked = {
                    navHost.popBackStack()
                }
            )
        }
        composable(route = Halaman.MATKUL.name){
            RencanaStudyView(
                mahasiswa = uiState,
                onSubmitButtonClicked = {krsViewModel.saveDataKRS(it)},
                onBackButtonClicked = {navHost.popBackStack()}
            ) 
        }

    }
}

