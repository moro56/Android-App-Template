package com.app.featurey.impl.di

import com.app.featurey.api.ModuleYApi
import com.app.featurey.impl.ModuleY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FeatureYModule {
    @Provides
    fun providesModuleYFeatureApi(): ModuleYApi = ModuleY()
}
