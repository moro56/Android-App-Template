package com.app.featurea.impl.di

import com.app.featurea.api.ModuleAApi
import com.app.featurea.impl.ModuleA
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FeatureAModule {

    @Provides
    fun providesModuleAFeatureApi(): ModuleAApi = ModuleA()
}