package com.app.modular

import android.content.Context
import androidx.startup.AppInitializer
import com.app.core.navigation.Navigator
import com.app.core.test.TestConstants
import com.app.featurea.api.ModuleAApi
import com.app.featureb.api.ModuleBModalApi
import com.app.featurec.api.ModuleCApi
import com.app.featurez.api.ModuleZApi
import com.app.main.api.MainFeatureApi
import com.app.modular.startup.NavigatorInitializer
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(
    application = HiltTestApplication::class,
    sdk = [TestConstants.testSdk],
    qualifiers = TestConstants.testQualifiers,
    instrumentedPackages = [TestConstants.testInstrumentedPackages]
)
class NavigatorInitializerTest {

    @get:Rule
    internal var hiltRule = HiltAndroidRule(this)

    @Inject
    @ApplicationContext
    internal lateinit var appContext: Context

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun `navigator initialized correctly`() {
        AppInitializer.getInstance(appContext).initializeComponent(NavigatorInitializer::class.java)

        try {
            Navigator.retrieveFeature(ModuleAApi::class)
            Navigator.retrieveFeature(ModuleCApi::class)
            Navigator.retrieveFeature(ModuleZApi::class)
            Navigator.retrieveFeature(MainFeatureApi::class)
            Navigator.retrieveModalFeature(ModuleBModalApi::class)
        } catch (e: Exception) {
            Assert.fail(e.localizedMessage)
        }
    }
}
