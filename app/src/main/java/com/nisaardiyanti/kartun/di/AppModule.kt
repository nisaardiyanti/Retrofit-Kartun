package com.nisaardiyanti.kartun.di

import com.nisaardiyanti.kartun.api.ApiService
import com.nisaardiyanti.kartun.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): ApiService =
    //no enam  bagian webservice
        Retrofit.Builder()
        //Kelas Retrofit.Builder menggunakan Builder API untuk memungkinkan menentukan titik akhir URL untuk operasi HTTP
    //dan akhirnya membangun instans Retrofit baru.
    //memanggil baseUrl () diperlukan sebelum akhirnya memanggil builder.build (). 
            .baseUrl(BASE_URL)
            //base url untuk yang dibuat dari ApiService
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


}
