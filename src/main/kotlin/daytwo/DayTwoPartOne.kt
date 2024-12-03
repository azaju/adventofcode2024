package org.example.daytwo

import java.io.File
import kotlin.math.abs

class DayTwoPartOne {

    companion object {

        fun isIncreasing(report: MutableList<Int>): Boolean {
            for (i in 1 until report.size) {
                if (report[i] <= report[i - 1]) {
                    return false
                }
            }
            return true
        }

        fun isDecreasing(report: MutableList<Int>): Boolean {
            for (i in 1 until report.size) {
                if (report[i] >= report[i - 1]) return false
            }
            return true
        }

        fun differByAtLeastOne(report: MutableList<Int>): Boolean {
            for (i in 1 until report.size) {
                if ((abs(report[i] - report[i - 1]) == 0)) return false
            }
            return true
        }

        fun differByMaxThree(report: MutableList<Int>): Boolean {
            for (i in 1 until report.size) {
                if ((abs(report[i] - report[i - 1]) > 3)) return false
            }
            return true
        }

        fun calculateNumberOfSafeReport(fileName: String): Int {
            // Chemin vers le fichier texte
            val filePath = fileName

            // Initialisation des listes pour chaque colonne
            var reportList = mutableListOf<MutableList<Int>>()

            var totalSafeReport = 0;
            // Lecture du fichier ligne par ligne
            File(filePath).forEachLine { line ->
                reportList.add(line.split("\\s+".toRegex()).map { it.toInt() }.toMutableList())
            }
            reportList.asSequence().forEach {
                if (isIncreasing(it) or isDecreasing(it)) {
                    if(differByAtLeastOne(it) and differByMaxThree(it))
                        totalSafeReport +=1
                }
            }
            return totalSafeReport
        }
    }
}
