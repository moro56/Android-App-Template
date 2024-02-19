package com.app.modular

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.rememberNavController
import androidx.startup.AppInitializer
import com.app.core.navigation.Navigator
import com.app.core.test.TestConstants
import com.app.featureb.api.ModuleBModalApi
import com.app.modular.startup.NavigatorInitializer
import com.app.modular.ui.components.BottomSheetLayout
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
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
class BottomSheetTest {

    @get:Rule
    internal var hiltRule = HiltAndroidRule(this)

    @get:Rule
    internal var composeTestRule = createComposeRule()

    @Inject
    @ApplicationContext
    internal lateinit var appContext: Context

    @Before
    fun setup() {
        hiltRule.inject()
        AppInitializer.getInstance(appContext).initializeComponent(NavigatorInitializer::class.java)
    }

    @Test
    fun `bottom sheet opens correctly with feature B content`() {
        composeTestRule.setContent {
            BottomSheetLayout(navController = rememberNavController())
        }

        Navigator.retrieveModalFeature(ModuleBModalApi::class).show.invoke(
            ModuleBModalApi.featureRoute,
            mapOf()
        )

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("Feature2BottomSheet").assertIsDisplayed()
        composeTestRule.onNodeWithTag("EmptyBottomSheet").assertIsNotDisplayed()
    }

    @Test
    fun `bottom sheet opens correctly with empty content`() {
        composeTestRule.setContent {
            BottomSheetLayout(navController = rememberNavController())
        }

        Navigator.retrieveModalFeature(ModuleBModalApi::class).show.invoke(
            "empty",
            mapOf()
        )

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("Feature2BottomSheet").assertIsNotDisplayed()
        composeTestRule.onNodeWithTag("EmptyBottomSheet").assertIsDisplayed()
    }
}
