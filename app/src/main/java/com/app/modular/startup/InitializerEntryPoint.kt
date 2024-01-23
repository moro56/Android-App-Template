package com.app.modular.startup

import android.content.Context
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface InitializerEntryPoint {
    companion object {
        /**
         * A helper method to resolve the InitializerEntryPoint from the context
         *
         * @param context initializer context
         */
        fun resolve(context: Context): InitializerEntryPoint {
            val appContext = context.applicationContext ?: throw IllegalStateException()
            return EntryPointAccessors.fromApplication(
                appContext,
                InitializerEntryPoint::class.java
            )
        }
    }

    /**
     * Inject the [NavigatorInitializer]
     */
    fun inject(initializer: NavigatorInitializer)
}
