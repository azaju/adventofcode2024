package dayone

import org.example.dayone.DayOnePartTwo.Companion.calculateScore
import org.example.dayone.DayOnePartTwo.Companion.findNbOccurencies
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DayOnePartTwoTests {

    @Test
    fun testSimple() {
        assertEquals(2, findNbOccurencies(3, mutableListOf(3, 2, 5, 8, 3)))
    }

    @Test
    fun testLessSimple() {
        calculateScore("src/test/resources/datadayone.txt")
    }
}