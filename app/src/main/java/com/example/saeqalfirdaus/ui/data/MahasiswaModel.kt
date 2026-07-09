package com.example.saeqalfirdaus.ui.data

import com.google.gson.annotations.SerializedName

data class MahasiswaRequest(
    @SerializedName(value = "nim") val nim: String,
    @SerializedName(value = "nama") val nama: String,
    @SerializedName(value = "kelas") val kelas: String,
    @SerializedName(value = "prodi") val prodi: String,
)

// Dipakai sebagai respons setelah SIMPAN data (cuma butuh status + pesan)
data class SimpanMahasiswaResponse(
    @SerializedName(value = "status") val status: Boolean,
    @SerializedName(value = "message") val message: String
)

// Dipakai sebagai satu ITEM data mahasiswa di dalam daftar/list
data class MahasiswaResponse(
    @SerializedName(value = "nim") val nim: String,
    @SerializedName(value = "nama") val nama: String,
    @SerializedName(value = "kelas") val kelas: String,
    @SerializedName(value = "prodi") val prodi: String,
)

data class MahasiswaListResponse(
    @SerializedName(value = "status") val status: Boolean,
    @SerializedName(value = "data") val data: List<MahasiswaResponse>
)