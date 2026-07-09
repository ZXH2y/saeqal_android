package com.example.saeqalfirdaus.ui.screen

import android.net.http.HttpEngine
import android.net.http.HttpException
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Class
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.saeqalfirdaus.ui.data.APIClient
import com.example.saeqalfirdaus.ui.data.MahasiswaRequest
import com.example.saeqalfirdaus.ui.theme.SaeqalFirdausTheme
import kotlinx.coroutines.launch
import org.json.JSONObject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FromRegistrasiScreen(onSuccess: () -> Unit = {}) {
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
        "Teknik Perencanaan Wilayah dan Kota"
    )

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
    ) {
        // Header gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    ),
                    shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 32.dp)
            ) {
                Text(
                    text = "Registrasi Mahasiswa",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Silahkan lengkapi formulir di bawah ini!",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Light,
                        letterSpacing = 0.5.sp,
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                    )
                )
            }
        }

        // Konten utama
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 120.dp, bottom = 40.dp, start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                // Card putih kosong
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp),
                    shape = RoundedCornerShape(size = 24.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 70.dp, bottom = 30.dp, start = 24.dp, end = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Isi form akan ditambahkan di sini
                        OutlinedTextField(
                            value = nim,
                            onValueChange = { if(it.all { char -> char.isDigit() }) nim = it },
                            label = { Text("NIM") },
                            placeholder = { Text("ex: 210280001") },
                            leadingIcon = { Icon(Icons.Default.Badge, contentDescription = null, tint = MaterialTheme.colorScheme.primary) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        OutlinedTextField(
                            value = nama,
                            onValueChange = { nama = it },
                            label = { Text("Nama") },
                            placeholder = { Text("Masukkan Nama Sesuai KTP") },
                            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = MaterialTheme.colorScheme.primary) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                capitalization = KeyboardCapitalization.Words,
                                imeAction = ImeAction.Next
                            ),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        ExposedDropdownMenuBox(
                            expanded = expandedKelas,
                            onExpandedChange = { expandedKelas = it },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            OutlinedTextField(
                                value = kelas,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Kelas") },
                                placeholder = { Text("Pilih Kelas") },
                                leadingIcon = { Icon(Icons.Default.Class, contentDescription = null, tint = MaterialTheme.colorScheme.primary) },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedKelas) },
                                modifier = Modifier.menuAnchor().fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp)
                            )

                            ExposedDropdownMenu(
                                expanded = expandedKelas,
                                onDismissRequest = { expandedKelas = false }
                            ) {
                                opsiKelas.forEach { selectionOptions ->
                                    DropdownMenuItem(
                                        text = { Text(selectionOptions) },
                                        onClick = {
                                            kelas = selectionOptions
                                            expandedKelas = false
                                        },
                                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                    )
                                }
                            }
                        }

                        ExposedDropdownMenuBox(
                            expanded = expandedProdi,
                            onExpandedChange = { expanded = it },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            OutlinedTextField(
                                value = prodi,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Program Studi") },
                                placeholder = { Text("Pilih Program Studi") },
                                leadingIcon = { Icon(Icons.Default.School, contentDescription = null, tint = MaterialTheme.colorScheme.primary) },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                                modifier = Modifier.menuAnchor().fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp)
                            )

                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                opsiProdi.forEach { selectionOptions ->
                                    DropdownMenuItem(
                                        text = { Text(selectionOptions) },
                                        onClick = {
                                            prodi = selectionOptions
                                            expanded = false
                                        },
                                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = {
                                if (nim.isNotBlank() && nama.isNotBlank() && kelas.isNotBlank() && prodi.isNotBlank()){
                                    scope.launch {
                                        isLoading = true
                                        try {
                                            val request = MahasiswaRequest(nim, nama, kelas, prodi)
                                            val response = APIClient.instace.SimpanDataMahasiswa(
                                                mahasiswaRequest = request
                                            )
                                            if (response.status){
                                                Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
                                                nim = ""
                                                nama = ""
                                                kelas = ""
                                                prodi = ""
                                                onSuccess()
                                            }
                                        }catch (e: retrofit2.HttpException){
                                            val errorBody = e.response()?.errorBody()?.string()
                                            val errorMessage = try {
                                                val jsonObject = JSONObject(errorBody ?: "")
                                                jsonObject.getString("message")
                                            }catch (_: Exception){
                                                "Terjadi kesalahan pada server"
                                            }
                                            Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                                        } catch (e: Exception)
                                        {
                                            Toast.makeText(context, e.localizedMessage, Toast.LENGTH_SHORT).show()
                                        }finally {
                                            isLoading = false
                                        }
                                    }

                                } else {
                                    Toast.makeText(context, "Lengkapi semua kolom", Toast.LENGTH_SHORT).show()
                                }
                            },
                            enabled = !isLoading,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp),
                            shape = RoundedCornerShape(16.dp),
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                        ) {
                            if (isLoading) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(24.dp),
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    strokeWidth = 2.dp
                                )
                            } else {
                                Icon(Icons.Default.Save, contentDescription = null)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Simpan Data",
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FromRegistrasiScreenPreview(){
    SaeqalFirdausTheme{
        FromRegistrasiScreen()
    }
}
