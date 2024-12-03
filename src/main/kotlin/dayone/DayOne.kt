package org.example.dayone

import java.io.File
import kotlin.math.abs

class DayOne {
    companion object {
        fun diffBetweenTwoNumbers(minLeft: Int, minRight: Int): Int {
            return abs(minLeft - minRight)
        }

        fun getMin(list: List<Int>): Int {
            return list.minOrNull() ?: 0
        }

        fun getTotalDiff(firstList : MutableList<Int>, secondList : MutableList<Int>): Int {

            firstList.sort()
            secondList.sort()
            var total = 0
            firstList.zip(secondList).map { (a, b) ->
                total += diffBetweenTwoNumbers(a, b)
            }

            return total
        }

        fun convertFileToLists(fileName: String) {
            // Chemin vers le fichier texte
            val filePath = fileName

            // Initialisation des listes pour chaque colonne
            val firstList = mutableListOf<Int>()
            val secondList = mutableListOf<Int>()

            // Lecture du fichier ligne par ligne
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

            var total = getTotalDiff(firstList, secondList)

            println("Total: $total")
        }
    }
}