package com.app.core.navigation.models

/**
 * Model that contains the info used to show a bottomSheet
 *
 * @property route route of the bottomSheet
 * @property params params
 */
data class BottomSheetData(val route: String, val params: Map<String, String> = mapOf())
