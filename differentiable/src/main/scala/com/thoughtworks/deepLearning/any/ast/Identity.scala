package com.thoughtworks.deepLearning.any.ast

import com.thoughtworks.deepLearning.{Batch, Ast}

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
final case class Identity[Input0 <: Batch]() extends Ast {
  type Input = Input0
  type Output = Input0

  override def forward(input: Input): Output = {
    input
  }
}