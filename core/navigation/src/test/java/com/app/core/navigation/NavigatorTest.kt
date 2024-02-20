package com.app.core.navigation

import androidx.navigation.NavOptions
import com.app.core.navigation.models.NavCommand
import com.app.core.navigation.models.NavDestination
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Test

class NavigatorTest {

    @Test
    fun `test commands`() {
        val navigator = AppNavigator(
            navController = mockk {
                every { popBackStack() } returns true
                every { popBackStack(any<String>(), any()) } returns true
                justRun { navigate(any<String>(), any<NavOptions>()) }
            }
        )

        navigator.navigate(NavCommand.GoBack)
        verify { navigator.navController.popBackStack() }

        navigator.navigate(NavCommand.NavigateToRoute("route1"))
        verify { navigator.navController.navigate("route1") }

        navigator.navigate(NavCommand.GoBackToRoute("route2", true))
        verify { navigator.navController.popBackStack("route2", true) }
    }

    @Test
    fun `test destination with params`() {
        val destination = NavDestination.FeatureB

        Assert.assertEquals(
            "featureB/{paramTitle}?paramValue={paramValue}",
            destination.completeRoute
        )
        Assert.assertEquals("featureB/test?paramValue=11", destination.createRoute("test", 11))
    }
}
