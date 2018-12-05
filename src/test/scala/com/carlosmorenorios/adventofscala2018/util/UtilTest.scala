package com.carlosmorenorios.adventofscala2018.util

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.specs2.mutable.Specification

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
@RunWith(classOf[JUnitRunner])
class UtilTest extends Specification {

  "All days classes" should {
    "Return the input in a list of string" in {
      val input = Util.readInput("/test.txt")
      input should have length 3
      input.head mustEqual "primera linea"
      input.last mustEqual "tercera linea"
    }
  }
}
