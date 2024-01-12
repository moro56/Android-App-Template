package com.app.modular.startup

import android.content.Context
import androidx.startup.Initializer
import com.app.core.navigation.Navigator
import com.app.featurea.api.ModuleAApi
import com.app.featureb.api.ModuleBApi
import com.app.featurec.api.ModuleCApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorInitializer : Initializer<Navigator> {

    @Inject
    lateinit var featureA: ModuleAApi

    @Inject
    lateinit var featureB: ModuleBApi

    @Inject
    lateinit var featureC: ModuleCApi

    override fun create(context: Context): Navigator {
        InitializerEntryPoint.resolve(context).inject(this)

        Navigator.initialize(
            features = listOf(featureA, featureB, featureC),
            modalFeatures = listOf()
        )
        return Navigator
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}