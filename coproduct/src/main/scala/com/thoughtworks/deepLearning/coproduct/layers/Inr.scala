package com.thoughtworks.deepLearning
package coproduct.layers

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
final case class Inr[Input0 <: Batch, TailData <: shapeless.Coproduct, TailDelta <: shapeless.Coproduct](
    tail: Layer.Aux[Input0, Batch.Aux[TailData, TailDelta]])
    extends Layer {

  type Input = Input0

  final class Output private[Inr] (tailBatch: Batch.Aux[TailData, TailDelta])
      extends Batch
      with com.thoughtworks.deepLearning.utilities.CloseableOnce {
    def value = shapeless.Inr(tailBatch.value: TailData)

    type Data = shapeless.Inr[Nothing, TailData]
    type Delta = shapeless.:+:[scala.Any, TailDelta]

    override def backward(delta: shapeless.:+:[scala.Any, TailDelta]): Unit = {
      delta match {
        case shapeless.Inr(tailDelta) => tailBatch.backward(tailDelta)
        case shapeless.Inl(_) =>
      }
    }

    override def close(): Unit = {
      super.close()
      tailBatch.close()
    }
  }

  override def forward(input: BatchId.Aux[Input]) = new BatchId {
    override type Open = Output
    override def open() = new Output(tail.forward(input).open())
  }

}
