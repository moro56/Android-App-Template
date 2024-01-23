package com.app.core.base

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.SaverScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.test.junit4.createComposeRule
import com.app.core.base.state.GlobalState
import com.app.core.base.state.LocalAppState
import com.app.core.base.state.globalStateSaver
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(
    sdk = [33],
    qualifiers = "en-rUS-w412dp-h732dp-xxxhdpi",
    instrumentedPackages = ["androidx.loader.content"]
)
class GlobalStateTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `global state initialize correctly`() {
        var userLoggedIn = false
        var bottomBarState = false

        composeTestRule.setContent {
            val globalState = rememberSaveable(saver = globalStateSaver) {
                GlobalState(userLoggedIn = userLoggedIn)
            }
            CompositionLocalProvider(LocalAppState provides globalState) {
                val globalStateLocal = LocalAppState.current

                SideEffect {
                    userLoggedIn = globalStateLocal.isUserLoggedIn
                    bottomBarState = globalStateLocal.bottomBarState
                }

                Box {}
            }
        }

        Assert.assertEquals(false, userLoggedIn)
        Assert.assertEquals(true, bottomBarState)
    }

    @Test
    fun `global state change correctly`() {
        val userLoggedIn = false
        var bottomBarState = true

        composeTestRule.setContent {
            val globalState = rememberSaveable(saver = globalStateSaver) {
                GlobalState(userLoggedIn = userLoggedIn)
            }
            CompositionLocalProvider(LocalAppState provides globalState) {
                val globalStateLocal = LocalAppState.current

                SideEffect {
                    globalStateLocal.bottomBarState = false
                    bottomBarState = globalStateLocal.bottomBarState
                }

                Box {}
            }
        }

        Assert.assertEquals(false, bottomBarState)
    }

    @Test
    fun `global state saver works correctly`() {
        var userLoggedIn = true

        composeTestRule.setContent {
            val globalState = GlobalState(userLoggedIn = userLoggedIn)

            val saverState = rememberUpdatedState(globalStateSaver)
            val savedString = with(saverState.value) {
                SaverScope { true }.save(globalState)
            }

            savedString?.also { saved ->
                globalStateSaver.restore(saved)?.also {
                    userLoggedIn = it.isUserLoggedIn
                }
            }
        }

        Assert.assertEquals(true, userLoggedIn)
    }
}
