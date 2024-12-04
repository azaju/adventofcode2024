package day3

import java.io.File

class DayThreePartOne {

    companion object {

        private fun getRegex(): Regex {
            return """mul\((-?\d+),(-?\d+)\)""".toRegex()
        }

        fun findMul(input: String): String {
            val matches = getRegex().findAll(input)

            var extractedMul=""
            for (match in matches) {
                val x = match.groupValues[1].toInt()
                val y = match.groupValues[2].toInt()
                extractedMul="mul($x,$y)"
            }
            return extractedMul
        }

        fun findMulOccurencies(input: String): Int {
            val matches = getRegex().findAll(input)
            return matches.count()
        }

        fun calculateMulResultsForAString(inputText:String): Int {
            val matches = getRegex().findAll(inputText)

            return calculateOccurencies(matches)
        }

        fun calculateNbOccurencies(filePath: String): Int {
            val matches = getRegex().findAll(File(filePath).readText())

            return calculateOccurencies(matches)
        }

        private fun calculateOccurencies(matches: Sequence<MatchResult>): Int {
            var nbOccurencies = 0
            for (match in matches) {
                val x = match.groupValues[1].toInt()
                val y = match.groupValues[2].toInt()
                nbOccurencies += x * y
            }
            return nbOccurencies
        }
    }
}