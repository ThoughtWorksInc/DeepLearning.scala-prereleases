package com.thoughtworks.deepLearning.boolean

import cats._
import cats.implicits._
import org.nd4s.Implicits._
import com.thoughtworks.deepLearning.Batch._
import com.thoughtworks.deepLearning.NeuralNetwork._
import com.thoughtworks.deepLearning.Batch
import com.thoughtworks.deepLearning.any._
import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4j.linalg.factory.Nd4j
import org.nd4j.linalg.ops.transforms.Transforms

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
package object utilities {

  type Boolean = Type[Eval[scala.Boolean], Eval[scala.Boolean]]
}