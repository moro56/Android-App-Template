package com.app.featurea.impl

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.app.core.test.MainDispatcherRule
import com.app.core.test.TestConstants
import com.app.featurea.impl.ui.FeatureAContract
import com.app.featurea.impl.ui.FeatureAScreen
import com.app.featurea.impl.ui.FeatureAScreenContent
import com.app.featurea.impl.ui.FeatureAViewModel
import com.app.ui.preview.ThemePreviewWrapper
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.test.runTest
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
class FeatureAScreenTest {

    @get:Rule
    val rule = MainDispatcherRule()

    @get:Rule
    internal var composeTestRule = createComposeRule()

    @Test
    fun `screen shows correctly`() = runTest {
        composeTestRule.setContent {
            FeatureAScreenContent(
                modifier = Modifier,
                state = FeatureAContract.State(0),
                onGoToBClick = {},
                onCreateRandomNumberClick = {},
                onShowSnackBarClick = {},
                onShowFeatureBModalClick = {}
            )
        }

        composeTestRule.onNodeWithText("Feature A").assertIsDisplayed()
        composeTestRule.onNodeWithText("Go to B").assertIsDisplayed()
        composeTestRule.onNodeWithText("Random Number: 0").assertIsDisplayed()
        composeTestRule.onNodeWithText("Create New Number").assertIsDisplayed()
        composeTestRule.onNodeWithText("Show SnackBar").assertIsDisplayed()
        composeTestRule.onNodeWithText("Show Feature B Modal").assertIsDisplayed()
    }

    @Test
    fun `number changes correctly`() = runTest {
        composeTestRule.setContent {
            ThemePreviewWrapper {
                FeatureAScreen(
                    modifier = Modifier,
                    onGoToBClick = {},
                    onShowFeatureBModalClick = {},
                    viewModel = viewModel
                )
            }
        }

        composeTestRule.onNodeWithText("Random Number: 0").assertIsDisplayed()
        composeTestRule.onNodeWithText("Create New Number").performClick()

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Random Number: ${viewModel.uiState.value.number}")
            .assertIsDisplayed()
    }

    @Test
    fun `snackBar shows correctly`() = runTest {
        composeTestRule.setContent {
            ThemePreviewWrapper {
                FeatureAScreen(
                    modifier = Modifier,
                    onGoToBClick = {},
                    onShowFeatureBModalClick = {},
                    viewModel = viewModel
                )
            }
        }

        composeTestRule.onNodeWithText("Random Number: 0").assertIsDisplayed()
        composeTestRule.onNodeWithText("Show SnackBar").performClick()

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Effect example").assertIsDisplayed()
    }

    @Test
    fun `buttons work correctly`() = runTest {
        var showBCaptured = false
        var showBModalCaptured = false

        composeTestRule.setContent {
            ThemePreviewWrapper {
                FeatureAScreen(
                    modifier = Modifier,
                    onGoToBClick = {
                        showBCaptured = true
                    },
                    onShowFeatureBModalClick = {
                        showBModalCaptured = true
                    },
                    viewModel = viewModel
                )
            }
        }

        composeTestRule.onNodeWithText("Go to B").performClick()
        composeTestRule.onNodeWithText("Show Feature B Modal").performClick()

        Assert.assertTrue(showBCaptured)
        Assert.assertTrue(showBModalCaptured)
    }

    // MOCKS

    private val viewModel = FeatureAViewModel()
}