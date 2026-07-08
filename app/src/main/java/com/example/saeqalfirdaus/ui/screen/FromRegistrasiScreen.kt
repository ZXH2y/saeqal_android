package com.example.saeqalfirdaus.ui.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.saeqalfirdaus.ui.theme.SaeqalFirdausTheme

@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun FromRegistrasiScreen(onSuccess: () -> Unit = {}){
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope ()
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }
    var prodi by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(value = false)}
    var expanded by remember { mutableStateOf(false) }
    var expandedKelas by remember { mutableStateOf(false) }
    var expandedProdi by remember { mutableStateOf(false) }

    val opsiKelas = listOf("Kelas A", "Kelas B", "Kelas C", "Kelas D", "Kelas E")
    val opsiProdi = listOf(
        "Teknik Informatika",
        "Teknik Elektro",
        "Teknik Sipil",
        "Teknik Perencanaan wilayah dan kota"
    )

//    start background biru tipis gradient
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.surface
                    )
                )
            )
            .verticalScroll(scrollState)
    )
    //    end background biru tipis gradient
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FromRegistrasiScreenPreview(){
    SaeqalFirdausTheme{
        FromRegistrasiScreen()
    }
}
