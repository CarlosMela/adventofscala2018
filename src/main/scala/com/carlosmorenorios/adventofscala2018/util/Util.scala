package com.carlosmorenorios.adventofscala2018.util

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
object Util {

  def readInput(inputPath: String): List[String] = {
    try {
      def source = io.Source.fromFile(getClass.getResource(inputPath).getFile)

      (for (line <- source.getLines) yield line).toList
    } catch {
      case _: Exception => List()
    }
  }

  def replaceInList(list: List[Int], index: Int, value: Int): List[Int] = {
    list.patch(index, Seq(value), 1)
  }

  def numberWithSign(n: String): Int = {
    n.substring(1).toInt *
      (if (n.startsWith("-")) -1 else 1)
  }

  def manhattanDistance(point1: List[Int], point2: List[Int]): Int = {
    manhattanDistanceJoinedPoints(point1.union(point2): _*)
  }

  private def manhattanDistanceJoinedPoints(points: Int*): Int = {
    val length: Int = points.length / 2
    (0 until length).fold(0)((sum, i) => sum + Math.abs(points(i) - points(i + length)))
  }
}
