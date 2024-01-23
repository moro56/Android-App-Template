package com.app.main.impl.di

import com.app.main.api.MainFeatureApi
import com.app.main.impl.MainFeature
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    fun providesMainFeatureApi(): MainFeatureApi = MainFeature()
}
