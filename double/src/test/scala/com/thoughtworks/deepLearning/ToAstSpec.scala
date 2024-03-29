package com.thoughtworks.deepLearning

import cats._
import com.thoughtworks.deepLearning.any.ToLayer
import com.thoughtworks.deepLearning.double._
import org.scalatest.{FreeSpec, Matchers}

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
final class ToLayerSpec extends FreeSpec with Matchers {
  "ToLayer" in {
    implicitly[
      ToLayer.OfType[Int, Double#Batch, Double] =:= ToLayer.Aux[Int, Double#Batch, Eval[scala.Double], Eval[scala.Double]]]

    implicitly[
      ToLayer.Aux[Int, Double#Batch, Eval[scala.Double], Eval[scala.Double]] =:= ToLayer.OfType[Int, Double#Batch, Double]]
  }
}
