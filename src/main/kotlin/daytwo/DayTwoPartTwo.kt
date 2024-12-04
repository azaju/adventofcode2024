package org.example.daytwo

import java.io.File
import kotlin.math.abs

class DayTwoPartTwo {
    companion object {

        fun isIncreasingAndHaveMaxOneError(report: MutableList<Int>): Boolean {
            var countRemoved = 0
            for (i in 1 until report.size) {
                if (report[i] <= report[i - 1]) {
                    countRemoved += 1
                    if (countRemoved > 1)
                        return false
                }
            }
            return true
        }

        fun isDecreasingAndHaveMaxOneError(report: MutableList<Int>): Boolean {
            var countRemoved = 0
            for (i in 1 until report.size) {
                if (report[i] >= report[i - 1]) {
                    countRemoved += 1
                    if (countRemoved > 1)
                        return false
                }
            }
            return true
        }

        fun differByAtLeastOneWithMaxOneError(report: MutableList<Int>): Boolean {
            var countRemoved = 0
            for (i in 1 until report.size) {
                if ((abs(report[i] - report[i - 1]) == 0)) {
                    countRemoved += 1
                    if (countRemoved > 1)
                        return false
                }
            }
            return true
        }

        fun differByMaxThreeWithMaxOneError (report: MutableList<Int>): Boolean {
            if (report.size < 2) return false
            var countRemoved = 0
            for (i in 1 until report.size -1) {
                if ((abs(report[i] - report[i - 1]) > 3)) {
                    countRemoved += 1
                    if (countRemoved > 1)
                        return false
                    else {
                        report.removeAt(i)
                        differByMaxThreeWithMaxOneError(report)
                    }

                }
            }
            return true
        }

        fun calculateNumberOfSafeReport(fileName: String): Int {
            val filePath = fileName
            var reportList = mutableListOf<MutableList<Int>>()
            var totalSafeReport = 0;
            File(filePath).forEachLine { line ->
                reportList.add(line.split("\\s+".toRegex()).map { it.toInt() }.toMutableList())
            }

            reportList.asSequence().forEach {
                if (isIncreasingAndHaveMaxOneError(it) or isDecreasingAndHaveMaxOneError(it)) {
                    if (differByAtLeastOneWithMaxOneError(it) and differByMaxThreeWithMaxOneError(it))
                        totalSafeReport += 1
                }
            }
            println(totalSafeReport)
            return totalSafeReport
        }
    }
}