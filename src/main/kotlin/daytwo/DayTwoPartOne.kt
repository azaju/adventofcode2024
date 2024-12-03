package org.example.daytwo

import java.io.File
import kotlin.math.abs

class DayTwoPartOne {

    companion object {

        fun isIncreasing(report: MutableList<Int>): Boolean {
            var increasedList = false

            for (i in 0 until report.size - 1) {
                if (i > 0) {
                    if ((report[i] > report[i - 1]) and (report[i] < report[i + 1])) increasedList = true
                    else return false
                } else
                    if (report[i] < report[i + 1])
                        increasedList = true
                    else
                        return false
            }
            return increasedList
        }

        fun isDecreasing(report: MutableList<Int>): Boolean {
            var decreasedList = false

            for (i in 0 until report.size - 1) {
                if (i > 0) {
                    if ((report[i] < report[i - 1]) and (report[i] > report[i + 1])) decreasedList = true
                    else return false
                } else
                    if (report[i] > report[i + 1])
                        decreasedList = true
                    else
                        return false
            }
            return decreasedList
        }

        fun differByAtLeastOne(report: MutableList<Int>): Boolean {
            var differByAtLeastOne = false;
            for (i in 0 until report.size - 1) {
                if (i > 0) {
                    if (
                        (abs(report[i] - report[i - 1]) >= 1) and
                        (abs(report[i] - report[i + 1]) >= 1)
                    )
                        differByAtLeastOne = true
                    else return false
                } else
                    if (abs(report[i] - report[i + 1]) >= 1)
                        differByAtLeastOne = true
                    else
                        return false
            }
            return differByAtLeastOne;
        }

        fun differByMaxThree(report: MutableList<Int>): Boolean {
            var differByMaxThree = false;
            for (i in 0 until report.size - 1) {
                if (i > 0) {
                    if (
                        (abs(report[i] - report[i - 1]) <= 3) and
                        (abs(report[i] - report[i + 1]) <= 3)
                    )
                        differByMaxThree = true
                    else return false
                } else
                    if (abs(report[i] - report[i + 1]) <= 3)
                        differByMaxThree = true
                    else
                        return false
            }
            return differByMaxThree;
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
            println(totalSafeReport)
            return totalSafeReport
        }
    }

    /*
    File(filePath).forEachLine { line ->
                val values = line.split("\\s+".toRegex()) // Séparation des valeurs par espaces ou tabulations
                if (values.size >= 2) { // S'assurer qu'il y a au moins 2 colonnes
                    val value1 = values[0].toIntOrNull() // Convertir en entier
                    val value2 = values[1].toIntOrNull()

                    // Ajouter les valeurs aux listes respectives si elles sont valides
                    value1?.let { firstList.add(it) }
                    value2?.let { secondList.add(it) }
                }
            }
    */

}
