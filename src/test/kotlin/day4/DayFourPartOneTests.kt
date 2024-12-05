package day4


import org.example.day4.DayFourPartOne.Companion.findAllOccurencies
import org.example.day4.DayFourPartOne.Companion.findNbSAMXOnOneLine
import org.example.day4.DayFourPartOne.Companion.findNbXMASOnOneLine
import org.example.day4.DayFourPartOne.Companion.findNbXMASandSAMXOnOneLine
import org.example.day4.DayFourPartOne.Companion.findOneOrManyXMASinDiagonal
import org.example.day4.DayFourPartOne.Companion.findOneOrManyXMASinManyLinesAndColumns
import org.example.day4.DayFourPartOne.Companion.findXMASandSMAXinManyColumns
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayFourPartOneTests {



    @Test
    fun testFindOneOrManyXMASInOneLine() {
        assertEquals(1,findNbXMASOnOneLine("AAAXMASSMA"))
        assertEquals(2,findNbXMASOnOneLine("AAAXMASSMXMASA"))
    }

    @Test
    fun testFindOneOrManySAMXInOneLine() {
        assertEquals(1,findNbSAMXOnOneLine("AAAXMASAMXSMA"))
        assertEquals(2,findNbSAMXOnOneLine("AAASAMXMASSAMXMASA"))
    }

    @Test
    fun testFindOneOrManyXMASandSAMXInOneLine() {
        assertEquals(2,findNbXMASandSAMXOnOneLine("AAAXMASAMSAMX"))
        assertEquals(3,findNbXMASandSAMXOnOneLine("AAAXMASAMXMSAMX"))
    }

    @Test
    fun testFindXMASandSAMXinManyColumns() {
        assertEquals(4,findXMASandSMAXinManyColumns("src/test/resources/dataday4/dataday4columns.txt"))
    }

    @Test
    fun testFindXMASandSAMXinManyLinesAndColumns() {
        assertEquals(8,findOneOrManyXMASinManyLinesAndColumns("src/test/resources/dataday4/dataday4linesandcolumns.txt"))
    }

    @Test
    fun testFindXMASandSAMXinDiagonal() {
        assertEquals(10,findOneOrManyXMASinDiagonal("src/test/resources/dataday4/dataday4linesandcolumns.txt"))
    }

    @Test
    fun testFinsXMASandSAMXinLinesColumnsAndDiagonals() {
        assertEquals(2370, findAllOccurencies("src/test/resources/dataday4/dataday4.txt"))
    }
}