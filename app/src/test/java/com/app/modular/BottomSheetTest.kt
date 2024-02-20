package com.app.modular

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.app.core.navigation.LocalNavigationState
import com.app.core.navigation.models.NavModalDestination
import com.app.core.test.TestConstants
import com.app.modular.ui.components.BottomSheetLayout
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
class BottomSheetTest {

    @get:Rule
    internal var composeTestRule = createComposeRule()

    @Test
    fun `bottom sheet opens correctly with feature B content`() {
        composeTestRule.setContent {
            LocalNavigationState.current.showBottomSheet(NavModalDestination.FeatureB.route)

            BottomSheetLayout()
        }

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("Feature2BottomSheet").assertIsDisplayed()
        composeTestRule.onNodeWithTag("EmptyBottomSheet").assertIsNotDisplayed()
    }

    @Test
    fun `bottom sheet opens correctly with empty content`() {
        composeTestRule.setContent {
            LocalNavigationState.current.showBottomSheet("Empty")

            BottomSheetLayout()
        }

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("Feature2BottomSheet").assertIsNotDisplayed()
        composeTestRule.onNodeWithTag("EmptyBottomSheet").assertIsDisplayed()
    }
}
