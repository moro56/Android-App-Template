package com.app.core.base

import com.app.core.base.exts.formatDate
import org.junit.Assert
import org.junit.Test

class ExtensionsTest {

    @Test
    fun test_date_formatter() {
        val timestamp1 = 1838434914000L
        val timestamp2 = 1119897637000L
        val timestamp3 = 1293434606000L
        val timestamp4 = 1674130947000L

        val date1 = timestamp1.formatDate()
        val date2 = timestamp2.formatDate("dd MM yyyy HH mm ss")
        val date3 = timestamp3.formatDate("yyyy-MM-dd")
        val date4 = timestamp4.formatDate("dd MM yyyy")

        Assert.assertEquals("04/04/2028", date1)
        Assert.assertEquals("27 06 2005 18 40 37", date2)
        Assert.assertEquals("2010-12-27", date3)
        Assert.assertEquals("19 01 2023", date4)
    }
}
