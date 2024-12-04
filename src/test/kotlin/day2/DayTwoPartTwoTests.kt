package day2

import org.example.daytwo.DayTwoPartTwo.Companion.calculateNumberOfSafeReport
import org.example.daytwo.DayTwoPartTwo.Companion.differByAtLeastOneWithMaxOneError
import org.example.daytwo.DayTwoPartTwo.Companion.differByMaxThreeWithMaxOneError
import org.example.daytwo.DayTwoPartTwo.Companion.isDecreasingAndHaveMaxOneError
import org.example.daytwo.DayTwoPartTwo.Companion.isIncreasingAndHaveMaxOneError

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DayTwoPartTwoTests {

    @Test
    fun testNumberOfSafeReports() {
        calculateNumberOfSafeReport("src/test/resources/dataday2simple.txt")
    }

    @Test
    fun testIncreasingAndRemoveOneLevelMakeItWorks() {
        assertTrue { isIncreasingAndHaveMaxOneError(mutableListOf(1,4,3,6)) }
        assertFalse { isIncreasingAndHaveMaxOneError(mutableListOf(1,4,3,8,6)) }
    }

    @Test
    fun testDecreasingAndRemoveOneLevelMakeItWorks() {
        assertTrue { isDecreasingAndHaveMaxOneError(mutableListOf(6,4,5,1)) }
        assertTrue { isDecreasingAndHaveMaxOneError(mutableListOf(6,4,3,1,2)) }
        assertFalse { isDecreasingAndHaveMaxOneError(mutableListOf(5,6,8,1)) }
        assertFalse { isDecreasingAndHaveMaxOneError(mutableListOf(9,7,6,2,1)) }
    }


    @Test
    fun testDifferByAtLeastOneWithMaxOneError() {
        assertTrue { differByAtLeastOneWithMaxOneError(mutableListOf(1,4,4,6)) }
        assertFalse { differByAtLeastOneWithMaxOneError(mutableListOf(1,4,4,4,6)) }
    }

    @Test
    fun testDifferByMaxThreeWithMaxOneError() {
        //assertTrue { differByMaxThreeWithMaxOneError(mutableListOf(1,4,8,9)) }
        //assertFalse { differByMaxThreeWithMaxOneError(mutableListOf(1,5,9,12)) }
        assertFalse { differByMaxThreeWithMaxOneError(mutableListOf(1,2,7,8,9)) }
    }



}