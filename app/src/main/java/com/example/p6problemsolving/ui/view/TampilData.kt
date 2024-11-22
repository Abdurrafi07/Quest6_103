package com.example.p6problemsolving.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p6problemsolving.R
import com.example.p6problemsolving.ui.model.Mahasiswa

@Composable
fun TampilView(
    uiState: Mahasiswa,
    onBackButtonClicked: () -> Unit = {},
    onResetButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.primary))
    ) {
        // Header Section
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Logo",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "HARVARD UNIVERSITY",
                    color = Color.Red,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Muda Mendunia UHUYYYYYY",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Display Mahasiswa Data
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "NIM: ${uiState.nim}")
                        Text(text = "Nama: ${uiState.nama}")
                    }
                    Text(text = uiState.email)
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Display Mata Kuliah and Kelas
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    Text(text = "Nama Mata Kuliah : ${uiState.matakuliah}")
                    Text(text = "Kelas: ${uiState.kelas}")
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = onBackButtonClicked) {
                        Text(text = "Kembali")
                    }
                    Button(onClick = onResetButtonClicked) {
                        Text(text = "Reset")
                    }
                }
            }
        }
    }
}