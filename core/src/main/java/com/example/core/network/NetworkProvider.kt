package com.example.core.network

import retrofit2.Retrofit

interface NetworkProvider {

    fun provideRetrofit(): Retrofit
}