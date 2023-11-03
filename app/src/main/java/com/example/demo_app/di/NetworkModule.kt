package com.example.demo_app.di

import com.example.demo_app.network.NetworkInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun providesService(retrofit: Retrofit) : NetworkInterface = retrofit.create(NetworkInterface::class.java)

    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://dummy.restapiexample.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}