package day2

import org.example.daytwo.DayTwoPartOne.Companion.calculateNumberOfSafeReport
import org.example.daytwo.DayTwoPartOne.Companion.differByAtLeastOne
import org.example.daytwo.DayTwoPartOne.Companion.differByMaxThree
import org.example.daytwo.DayTwoPartOne.Companion.isDecreasing
import org.example.daytwo.DayTwoPartOne.Companion.isIncreasing
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DayTwoPartOneTests {

    @Test
    fun testReportIncrease() {
        assertTrue { isIncreasing(mutableListOf(1,4,5,6)) }
        assertFalse { isIncreasing(mutableListOf(1,4,2,5)) }
    }

    @Test
    fun testReportDecrease() {
        assertTrue { isDecreasing(mutableListOf(6,5,4,1)) }
        assertFalse { isDecreasing(mutableListOf(6,5,4,7)) }
    }

    @Test
    fun testReportLevelsDifferByAtLeastOne() {
        assertTrue { differByAtLeastOne(mutableListOf(1,2,4,5)) }
        assertFalse { differByAtLeastOne(mutableListOf(1,2,4,4)) }
    }

    @Test
    fun testReportLevelsDifferByMaxThree() {
        assertTrue { differByMaxThree(mutableListOf(1,2,4,5)) }
        assertFalse { differByMaxThree(mutableListOf(1,2,4,8)) }
    }

    @Test
    fun testNumberOfSafeReports() {
        assertEquals(371, calculateNumberOfSafeReport("src/test/resources/dataday2.txt"))
    }
}