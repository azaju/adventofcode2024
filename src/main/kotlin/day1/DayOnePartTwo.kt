package org.example.dayone

import java.io.File

class DayOnePartTwo {

    companion object {

        fun calculateScore(fileName: String) {
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
            var total = 0
            firstList.forEach() {
                total += findNbOccurencies(it, secondList)*it
            }
            println(total)
        }

        fun findNbOccurencies(number:Int, secondList: MutableList<Int>): Int {
            var total =0
            secondList.forEach() {
                if (it == number) {
                    total++
                }
            }
            return total
        }
    }
}