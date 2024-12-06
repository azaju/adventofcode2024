package org.example.day5

import java.io.File

class DayFivePartOne {

    data class Rule(val val1: Int?, val val2: Int?)

    companion object {

        fun getRules(input: String): MutableList<Rule> {
            val listOfRules = mutableListOf<Rule>()
            val regex = Regex("""(\d+)\|(\d+)""")

            val matches = regex.findAll(File(input).readText() )
            for(match in matches) {
                listOfRules.add(Rule(match.groupValues[1].toInt(), match.groupValues[2].toInt()))
            }
            return listOfRules
        }

        fun getUpdates(input: String): MutableList<List<Int>> {
            var listOfUPdates = mutableListOf<List<Int>>()
            val regex = Regex("""^\d+(,\d+)*$""")

            File(input).useLines { lines ->
                lines.forEach { line ->
                    val trimmedLine = line.trim()
                    if (regex.matches(trimmedLine)) {
                        val integers = trimmedLine.split(",").map { it.toInt() }
                        listOfUPdates.add(integers)
                    }
                }
            }
            return listOfUPdates
        }

        fun updateMatchRule(input: String): Boolean {
            var listOfRules = getRules(input)
            var listOfUpdates = getUpdates(input)
            var areRulesRespected = true

            // Pour chaque ligne, on va aller tester toutes les règles
            listOfUpdates.get(0).forEach {
                areRulesRespected = respectRules(listOfRules, listOfUpdates.get(0))
            }

            return areRulesRespected
        }

        fun updateMatchRules(input: String): Int {
            var listOfRules = getRules(input)
            var listOfUpdates = getUpdates(input)
            var listOfGoodUpdates = mutableListOf<List<Int>>()
            var areRulesRespected = true

            // Pour chaque ligne d'update on va aller tester toutes les règles
            for(i in 0 until listOfUpdates.size) {
                if (respectRules(listOfRules, listOfUpdates.get(i))) listOfGoodUpdates.add(listOfUpdates.get(i))
            }

            var total = 0
            listOfGoodUpdates.forEach {
                list -> total += list.get((list.size)/2)
            }
            return total
        }

        private fun respectRules(listOfRules: MutableList<DayFivePartOne.Rule>, update: List<Int>): Boolean {
            var isRuleRespected = true

            listOfRules.forEach { rule ->
                if (rule.val1 in update && rule.val2 in update) {
                    isRuleRespected = respectRule(rule, update)
                    if (!isRuleRespected)
                        return false
                }
            }
            return true
        }

         private fun respectRule(rule: DayFivePartOne.Rule, update: List<Int>): Boolean {
            return update.indexOf(rule.val1) < update.indexOf(rule.val2)
        }
    }
}