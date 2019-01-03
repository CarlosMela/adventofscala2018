package com.carlosmorenorios.adventofscala2018.days

import com.carlosmorenorios.adventofscala2018.util.Util
import com.sun.xml.internal.ws.util.UtilException

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
object Day25 {
  var constellations: List[Set[List[Int]]] = List()

  def main(args: scala.Array[scala.Predef.String]): scala.Unit = {
    val points = Util.readInput("/day25.txt").map(toPoint)
    println("Result of first part: " + solution1(points))
    //    println("Result of second part: " + solution2(points))
  }

  def solution1(points: List[List[Int]]): Int = {
    points.foreach(p => {
      checkConstellations(p)
    })
    constellations.length
  }

  def checkConstellations(p: List[Int]): Unit = {
    var constellationsList: List[Set[List[Int]]] = List()
    var connectedConstellation = Set(p)
    for (c <- constellations) {
      if (isConnected(p, c)) {
        connectedConstellation = connectedConstellation.union(c)
      } else {
        constellationsList = c :: constellationsList
      }
    }
    constellations = connectedConstellation :: constellationsList
  }

  def isConnected(p: List[Int], c: Set[List[Int]]): Boolean = {
    for (star <- c) {
      if (Util.manhattanDistance(p, star) <= 3) {
        return true
      }
    }
    false
  }

  def toPoint(s: String): List[Int] = {
    s.split(",").toList.map(n => n.toInt)
  }
}
