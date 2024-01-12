package com.app.featurex.impl.di

import com.app.featurex.api.ModuleXApi
import com.app.featurex.impl.ModuleX
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FeatureXModule {

    @Provides
    fun providesModuleXFeatureApi(): ModuleXApi = ModuleX()
}