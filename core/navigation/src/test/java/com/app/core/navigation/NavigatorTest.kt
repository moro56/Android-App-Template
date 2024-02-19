package com.app.core.navigation

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Test

class NavigatorTest {

    @Test
    fun `test retrieve features`() {
        Navigator.initialize(
            features = listOf(feature1, feature2),
            modalFeatures = listOf(feature3)
        )

        Assert.assertNotNull(Navigator.retrieveFeature(Feature1::class))
        Assert.assertNotNull(Navigator.retrieveFeature(Feature2::class))
        Assert.assertNotNull(Navigator.retrieveModalFeature(Feature3::class))
    }

    @Test
    fun `test open modal`() {
        Navigator.initialize(
            features = listOf(),
            modalFeatures = listOf(feature3)
        )

        every { feature3.featureRoute } returns "route"
        justRun { feature3.show(any(), any()) }

        Navigator.openModal(Feature3::class, mockk())

        verify { feature3.show("route", any()) }

    }

    // MOCKS

    private val feature1 = mockk<Feature1>()
    private val feature2 = mockk<Feature2>()
    private val feature3 = mockk<Feature3>()

    interface Feature1 : FeatureApi
    interface Feature2 : FeatureApi
    interface Feature3 : ModalFeatureApi
}