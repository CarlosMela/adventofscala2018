package com.carlosmorenorios.adventofscala2018.days

import com.carlosmorenorios.adventofscala2018.util.Util

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
object Day05 {

  def main(args: scala.Array[scala.Predef.String]): scala.Unit = {
    val units = Util.readInput("/day05.txt").head
    println("Result of first part: " + solution1(units))
    println("Result of second part: " + solution2(units))
  }

  def solution1(units: String): Int = {
    var result = units
    var i = 0
    while (i < 30000) { // used brute force. Full recursion in reduce method produced StackOverflowError
      result = reduce(result, 0)
      i += 1
    }

    result.length
  }

  def solution2(units: String): Int = {
    ('a' to 'z').map(c => removeType(units, c)).map(solution1).min
  }

  def reduce(units: String, index: Int): String = {
    if (index >= units.length - 1) {
      return units
    }
    if (react(units.charAt(index), units.charAt(index + 1))) {
      return units.substring(0, index) + units.substring(index + 2)
    }
    reduce(units, index + 1)
  }

  def removeType(units: String, pType: Char): String = {
    units.filter(unit => !sameType(unit, pType))
  }

  def react(a: Char, b: Char): Boolean = {
    sameType(a, b) && a != b
  }

  def sameType(a: Char, b: Char): Boolean = {
    a.toString.equalsIgnoreCase(b.toString)
  }
}
