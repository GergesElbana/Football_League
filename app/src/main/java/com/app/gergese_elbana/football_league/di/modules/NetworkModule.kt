package com.app.gergese_elbana.football_league.di.modules

import android.content.Context
import com.app.gergese_elbana.football_league.data.remote.ApiServices
import com.app.gergese_elbana.football_league.data.remote.network.HeaderInterceptor
import com.app.gergese_elbana.football_league.data.remote.network.NetworkHelper
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideHeaderInterceptor(androidContext()) }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
    single { provideNetworkHelper(androidContext()) }
}
private const val URL:String="http://api.football-data.org/v2/competitions/"
private fun provideRetrofit(
    okHttpClient: OkHttpClient,
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(URL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): ApiServices =
    retrofit.create(ApiServices::class.java)

private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

fun provideHeaderInterceptor(context: Context): HeaderInterceptor {
    return HeaderInterceptor(context)
}

fun provideOkHttpClient(headerInterceptor: HeaderInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .build()
}