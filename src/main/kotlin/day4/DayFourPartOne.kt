package org.example.day4

import java.io.File

class DayFourPartOne {

    companion object {


        fun findNbXMASOnOneLine(input: String): Int {
            val regex = "XMAS".toRegex();
            val matches = regex.findAll(input)
            return matches.count()
        }

        fun findNbSAMXOnOneLine(input: String): Int {
            val regex = "SAMX".toRegex();
            val matches = regex.findAll(input)
            return matches.count()
        }

        fun findNbXMASandSAMXOnOneLine(input:String): Int {
            return findNbXMASOnOneLine(input) + findNbSAMXOnOneLine(input)
        }

        fun findXMASandSMAXinManyColumns(input: String): Int {
            val listOfLines = createListOfLines(input)
            var total = 0
            // Je crée des listes de string pour chaque colonne
            var columns = mutableListOf<String>()
            for (i in 0 until listOfLines.get(0).length) {
                var column = ""
                listOfLines.forEach{ line -> column += line.get(i) }
                total += findNbXMASOnOneLine(column) + findNbSAMXOnOneLine(column)
            }
            return total
        }

        fun findOneOrManyXMASinManyLinesAndColumns(input:String): Int {
            val listOfLines = createListOfLines(input)
            var total = 0

            listOfLines.forEach { line -> total += findNbXMASOnOneLine(line) + findNbSAMXOnOneLine(line) }

            // Je crée des listes de string pour chaque colonne
            for (i in 0 until listOfLines[0].length) {
                var column = ""
                listOfLines.forEach{ line -> column += line.get(i) }
                total += findNbXMASOnOneLine(column) + findNbSAMXOnOneLine(column)
            }
            return total
        }

        fun findOneOrManyXMASinDiagonal(input: String): Int {
            val grid = createListOfLines(input)

            val targetPatterns = listOf("XMAS", "SAMX")
            val rows = grid.size
            val cols = grid[0].length
            var count = 0

            // Check diagonals (top-left to bottom-right)
            for (startRow in 0 until rows) {
                count += countPatternsInDiagonal(grid, startRow, 0, 1, 1, targetPatterns)
            }
            for (startCol in 1 until cols) {
                count += countPatternsInDiagonal(grid, 0, startCol, 1, 1, targetPatterns)
            }

            // Check diagonals (top-right to bottom-left)
            for (startRow in 0 until rows) {
                count += countPatternsInDiagonal(grid, startRow, cols - 1, 1, -1, targetPatterns)
            }
            for (startCol in cols - 2 downTo 0) {
                count += countPatternsInDiagonal(grid, 0, startCol, 1, -1, targetPatterns)
            }
            return count
        }

        fun findAllOccurencies(input: String): Int {
            return findOneOrManyXMASinManyLinesAndColumns(input) + findOneOrManyXMASinDiagonal(input)
        }

        private fun createListOfLines(input: String): MutableList<String> {
            val listOfLines = mutableListOf<String>()
            // On crée des listes de string à partir des lignes
            File(input).forEachLine { line ->
                listOfLines.add(line.toString())
            }

            return listOfLines
        }

        private fun countPatternsInDiagonal(
            grid: List<String>,
            startRow: Int,
            startCol: Int,
            rowStep: Int,
            colStep: Int,
            patterns: List<String>
        ): Int {
            val rows = grid.size
            val cols = grid[0].length
            var r = startRow
            var c = startCol
            val diagonal = StringBuilder()

            while (r in 0 until rows && c in 0 until cols) {
                diagonal.append(grid[r][c])
                r += rowStep
                c += colStep
            }

            var count = 0
            val diagonalString = diagonal.toString()
            for (pattern in patterns) {
                var index = diagonalString.indexOf(pattern)
                while (index != -1) {
                    count++
                    index = diagonalString.indexOf(pattern, index + 1)
                }
            }
            return count
        }
    }
}