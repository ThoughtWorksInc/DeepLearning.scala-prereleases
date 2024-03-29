package com.thoughtworks.deepLearning.double.layers

import cats._
import cats.implicits._
import com.thoughtworks.deepLearning.double.optimizers.Optimizer
import com.thoughtworks.deepLearning.{Batch, BatchId, Layer}
import com.thoughtworks.deepLearning.double.utilities.DoubleMonoidBatch

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
final case class Weight(var rawValue: scala.Double)(implicit optimizer: Optimizer)
    extends Layer
    with DoubleMonoidBatch
    with BatchId {
  override type Input = Batch
  override type Output = Batch.Aux[Data, Delta]
  override type Open = Output

  override def open() = this

  override def forward(any: BatchId.Aux[Input]) = this

  override def backward(delta: Delta): Unit = {
    synchronized {
      rawValue = optimizer.updateDouble(rawValue, delta.value)
    }
  }

  override def value = Eval.now(rawValue)

  override def close(): Unit = {}

}