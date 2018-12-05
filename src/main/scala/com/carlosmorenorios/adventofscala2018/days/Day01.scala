package com.carlosmorenorios.adventofscala2018.days

import com.carlosmorenorios.adventofscala2018.util.Util

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
object Day01 {

  def main(args: scala.Array[scala.Predef.String]): scala.Unit = {
    val frequencyChanges = Util.readInput("/day01.txt")
    println("Result of first part: " + solution1(frequencyChanges))
    println("Result of second part: " + solution2(frequencyChanges))
  }

  def solution1(changes: List[String]): Int = {
    changes.map(Util.numberWithSign).sum
  }

  def solution2(changes: List[String]): Int = {
    findFirstDuplicatedFrequency(Set(0), changes, 0, 0)
  }

  def findFirstDuplicatedFrequency(found: Set[Int], changes: List[String], currentIndex: Int, currentFrequency: Int): Int = {
    val newFrequency = currentFrequency + Util.numberWithSign(changes(currentIndex))
    if (found(newFrequency))
      newFrequency
    else {
      findFirstDuplicatedFrequency(found + newFrequency, changes, (currentIndex + 1) % changes.length, newFrequency)
    }
  }
}
