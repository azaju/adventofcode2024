package day3

import day3.DayThreePartOne.Companion.calculateNbOccurencies
import day3.DayThreePartOne.Companion.calculateMulResultsForAString
import day3.DayThreePartOne.Companion.findMul
import day3.DayThreePartOne.Companion.findMulOccurencies
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test



class DayThreePartOneTests {

    @Test
    fun testRegexWithOneOccurence() {
        assertEquals("mul(2,4)", findMul("zdfsdfsdfmul(2,4)fsdfsf!èç!èè(!"))
    }

    @Test
    fun testRegexWithTwoOccurences() {
        assertEquals(2, findMulOccurencies("zdfsdfsdfmul(2,4)fsdfsfmul(2,4)!èç!èè(!"))
    }

    @Test
    fun testCalculateSingleMulResult(){
        assertEquals(8, calculateMulResultsForAString("zdfsdfsdfmul(2,4)fsdfsf!èç!èè(!)"))
    }

    @Test
    fun testCalculateDoubleMulResult() {
        assertEquals(16, calculateMulResultsForAString("zdfsdfsdfmul(2,4)fsdfsfmul(2,4)!èç!èè(!"))
    }

    @Test
    fun testFileToFindNbOccurencies() {
        assertEquals(170778545, calculateNbOccurencies("src/test/resources/dataday3.txt"))
    }
}

