package com.app.main

import android.content.res.Resources
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import com.app.core.test.TestConstants
import com.app.main.models.Screens
import com.app.main.ui.components.BottomNavBar
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(
    application = HiltTestApplication::class,
    sdk = [TestConstants.testSdk],
    qualifiers = TestConstants.testQualifiers,
    instrumentedPackages = [TestConstants.testInstrumentedPackages]
)
class BottomNavBarTest {

    @get:Rule
    internal var composeTestRule = createComposeRule()

    private val resources by lazy {
        Resources.getSystem()
    }

    @Test
    fun `bottom navBar shows correctly`() {
        composeTestRule.setContent {
            BottomNavBar(rememberNavController())
        }

        composeTestRule.onNodeWithText(resources.getString(Screens.FeatureXScreen.title))
            .assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(
            resources.getString(Screens.FeatureXScreen.title),
            useUnmergedTree = true
        ).assertIsDisplayed()

        composeTestRule.onNodeWithText(resources.getString(Screens.FeatureYScreen.title))
            .assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(
            resources.getString(Screens.FeatureYScreen.title),
            useUnmergedTree = true
        ).assertIsDisplayed()
    }
}
