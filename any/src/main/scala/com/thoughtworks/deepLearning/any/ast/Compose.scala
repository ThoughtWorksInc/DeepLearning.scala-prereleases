package com.thoughtworks.deepLearning.any.ast

import com.thoughtworks.deepLearning.{Batch, BatchId, NeuralNetwork}

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
final case class Compose[Input0 <: Batch, Temporary <: Batch, Output0 <: Batch](
    leftOperand: NeuralNetwork.Aux[Temporary, Output0],
    rightOperand: NeuralNetwork.Aux[Input0, Temporary])
    extends NeuralNetwork {
  override type Input = Input0
  override type Output = Output0

  override def forward(input: BatchId.Aux[Input]): BatchId.Aux[Output] = {
    leftOperand.forward(rightOperand.forward(input))
  }
}