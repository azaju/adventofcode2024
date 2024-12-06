package day5

import org.example.day5.DayFivePartOne.Companion.getRules
import org.example.day5.DayFivePartOne.Companion.getUpdates
import org.example.day5.DayFivePartOne.Companion.updateMatchRule
import org.example.day5.DayFivePartOne.Companion.updateMatchRules
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class DayFivePartOneTests {


    @Test
    fun testGetAllRules() {
        assertEquals(21, getRules("src/test/resources/dataday5/dataday5simple.txt").size)
    }

    @Test
    fun testGetAllUpdates() {
        assertEquals(6, getUpdates("src/test/resources/dataday5/dataday5simple.txt").size   )
    }

    @Test
    fun testUpdateMatchRule() {
        assertTrue { updateMatchRule("src/test/resources/dataday5/dataday5simple.txt") }
    }

    @Test
    fun testUpdateMatchRules() {
        assertEquals(4996, updateMatchRules("src/test/resources/dataday5/dataday5.txt"))
    }
}