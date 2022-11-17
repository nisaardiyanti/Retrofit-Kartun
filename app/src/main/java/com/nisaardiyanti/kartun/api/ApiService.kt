package com.nisaardiyanti.kartun.api

import com.nisaardiyanti.kartun.model.ResponseApi
import com.nisaardiyanti.kartun.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        //no sembilan menampilkan gambar
       // @Query("menghitung") ukuran:Int,
        @Query("page") page: Int

    ): Response<ResponseApi>
    //response dari ResponseApi
   
   
}
