package com.app.featureb

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.app.core.test.TestConstants
import com.app.featureb.ui.ModalFeatureBScreen
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Assert
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
class ModalFeatureBScreenTest {

    @get:Rule
    internal var composeTestRule = createComposeRule()

    @Test
    fun `screen shows correctly`() {
        composeTestRule.setContent {
            ModalFeatureBScreen(
                modifier = Modifier,
                title = "Test",
                onCloseClick = {}
            )
        }

        composeTestRule.onNodeWithText("Test").assertIsDisplayed()
        composeTestRule.onNodeWithText("Close").assertIsDisplayed()
    }


    @Test
    fun `buttons work correctly`() {
        var closeCaptured = false

        composeTestRule.setContent {
            ModalFeatureBScreen(
                modifier = Modifier,
                title = "Test",
                onCloseClick = {
                    closeCaptured = true
                }
            )
        }

        composeTestRule.onNodeWithText("Close").performClick()

        Assert.assertTrue(closeCaptured)
    }
}