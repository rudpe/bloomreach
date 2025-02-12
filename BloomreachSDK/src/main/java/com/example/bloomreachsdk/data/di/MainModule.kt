package com.example.bloomreachsdk.data.di

import com.example.bloomreachsdk.data.InputForm
import com.example.bloomreachsdk.data.InputFormImpl
import com.example.bloomreachsdk.data.api.InputFormApi
import com.example.bloomreachsdk.data.api.InputFormApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    internal fun provideInputFormApi(): InputFormApi = InputFormApiImpl()

    @Provides
    @Singleton
    fun provideInputForm(): InputForm = InputFormImpl(provideInputFormApi())

}