package com.app.modular.startup

import android.content.Context
import androidx.startup.Initializer
import com.app.core.navigation.Navigator
import com.app.featurea.api.ModuleAApi
import com.app.featureb.api.ModuleBApi
import com.app.featurec.api.ModuleCApi
import com.app.featurex.api.ModuleXApi
import com.app.featurey.api.ModuleYApi
import com.app.featurez.api.ModuleZApi
import com.app.main.api.MainFeatureApi
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

    @Inject
    lateinit var featureX: ModuleXApi

    @Inject
    lateinit var featureY: ModuleYApi

    @Inject
    lateinit var featureZ: ModuleZApi

    @Inject
    lateinit var main: MainFeatureApi

    override fun create(context: Context): Navigator {
        InitializerEntryPoint.resolve(context).inject(this)

        Navigator.initialize(
            features = listOf(featureA, featureB, featureC, featureX, featureY, featureZ, main),
            modalFeatures = listOf()
        )
        return Navigator
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
