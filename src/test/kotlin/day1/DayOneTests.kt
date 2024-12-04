package day1

import day1.DayOne.Companion.convertFileToLists
import day1.DayOne.Companion.diffBetweenTwoNumbers
import day1.DayOne.Companion.getMin
import day1.DayOne.Companion.getTotalDiff
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayOneTests {

    @Test
    fun testsDiffBetweenNumbersWithPositiveResult() {
        assertEquals(2, diffBetweenTwoNumbers(4, 2))
    }

    @Test
    fun testsDiffBetweenNumbersWithNegativeResult() {
        assertEquals(2, diffBetweenTwoNumbers(2, 4))
    }

    @Test
    fun getMinInList() {
        assertEquals(1, getMin(listOf(2,5,4,6,1)))
    }

    @Test
    fun getSumOfDiffBetweenTwoList() {
        assertEquals(5,getTotalDiff(mutableListOf(2,1), mutableListOf(3,5)))
        assertEquals(7,getTotalDiff(mutableListOf(2,1), mutableListOf(4,6)))
    }

    @Test
    fun testInputFile() {
        convertFileToLists("src/test/resources/datadayone.txt")
    }


}