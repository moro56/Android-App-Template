package com.app.core.base.exts

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

/**
 * Format a timestamp with current timezone
 *
 * @param format format of the datetime
 */
fun Long.formatDate(format: String = "dd/MM/yyyy"): String = Instant.ofEpochMilli(this).let {
    DateTimeFormatter.ofPattern(format).withZone(ZoneId.systemDefault()).format(it)
}
