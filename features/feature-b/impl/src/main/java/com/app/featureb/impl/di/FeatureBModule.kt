package com.app.featureb.impl.di

import com.app.featureb.api.ModuleBModalApi
import com.app.featureb.impl.ModalModuleB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FeatureBModule {

    @Provides
    fun providesModuleBModalFeatureApi(): ModuleBModalApi = ModalModuleB()
}
