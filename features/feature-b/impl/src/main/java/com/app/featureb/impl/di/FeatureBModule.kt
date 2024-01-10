package com.app.featureb.impl.di

import com.app.featureb.api.ModuleBApi
import com.app.featureb.impl.ModuleB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object FeatureBModule {

    @Provides
    fun providesModuleBFeatureApi(): ModuleBApi = ModuleB()
}