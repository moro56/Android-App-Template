package com.app.featurez.impl.di

import com.app.featurez.api.ModuleZApi
import com.app.featurez.impl.ModuleZ
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FeatureZModule {
    @Provides
    fun providesModuleZFeatureApi(): ModuleZApi = ModuleZ()
}
