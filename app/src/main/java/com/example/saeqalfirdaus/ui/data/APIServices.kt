package com.example.saeqalfirdaus.ui.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIServices {
    @POST(value = "save-mhs.php")
    suspend fun SimpanDataMahasiswa(
        @Body mahasiswaRequest: MahasiswaRequest
    ): SimpanMahasiswaResponse

    @GET(value = "read-mhs.php")
    suspend fun ambilDataMahasiswa(): MahasiswaListResponse
}