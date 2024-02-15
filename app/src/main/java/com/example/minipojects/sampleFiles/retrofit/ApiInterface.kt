package com.example.minipojects.sampleFiles.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/users?page=2")
    suspend fun getAllUsers(): Response<ResponseListUsers>
}