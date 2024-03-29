package com.thoughtworks.deepLearning.boolean
package utilities

import cats._
import cats.implicits._
import com.thoughtworks.deepLearning.Batch

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
private[deepLearning] trait BooleanMonoidBatch extends Batch {

  override type Data = Eval[scala.Boolean]

  override type Delta = Eval[scala.Boolean]

  protected final def monoid = new Monoid[Delta] {
    override def empty = Eval.now(false)

    override def combine(x: Delta, y: Delta) = x.map2(y)(_ ^ _)
  }

}
