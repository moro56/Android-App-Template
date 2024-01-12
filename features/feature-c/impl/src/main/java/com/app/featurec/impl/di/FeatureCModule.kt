package com.app.featurec.impl.di

import com.app.featurec.api.ModuleCApi
import com.app.featurec.impl.ModuleC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FeatureCModule {

    @Provides
    fun providesModuleCFeatureApi(): ModuleCApi = ModuleC()
}