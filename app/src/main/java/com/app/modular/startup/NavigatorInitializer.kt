package com.app.modular.startup

import android.content.Context
import androidx.startup.Initializer
import com.app.core.navigation.Navigator
import javax.inject.Singleton

@Singleton
class NavigatorInitializer : Initializer<Navigator> {
//    @Inject
//    lateinit var featureA: ModuleAApi
//
//    @Inject
//    lateinit var featureB: ModuleBApi
//
//    @Inject
//    lateinit var modalFeatureB: ModuleBModalApi
//
//    @Inject
//    lateinit var featureC: ModuleCApi
//
//    @Inject
//    lateinit var featureX: ModuleXApi
//
//    @Inject
//    lateinit var featureY: ModuleYApi
//
//    @Inject
//    lateinit var featureZ: ModuleZApi
//
//    @Inject
//    lateinit var main: MainFeatureApi

    override fun create(context: Context): Navigator {
        InitializerEntryPoint.resolve(context).inject(this)

//        Navigator.initialize(
//            features = listOf(featureA, featureB, featureC, featureX, featureY, featureZ, main),
//            modalFeatures = listOf(modalFeatureB)
//        )
        return Navigator
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
