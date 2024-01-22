package com.app.featureb.impl.di

import com.app.featureb.api.ModuleBApi
import com.app.featureb.api.ModuleBModalApi
import com.app.featureb.impl.ModalModuleB
import com.app.featureb.impl.ModuleB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FeatureBModule {
    @Provides
    fun providesModuleBFeatureApi(): ModuleBApi = ModuleB()

    @Provides
    fun providesModuleBModalFeatureApi(): ModuleBModalApi = ModalModuleB()
}
