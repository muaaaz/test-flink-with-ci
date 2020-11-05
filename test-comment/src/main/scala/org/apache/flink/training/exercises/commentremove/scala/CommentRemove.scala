package org.apache.flink.training.exercises.commentremove.scala

  import org.apache.flink.streaming.api.functions.co.RichCoFlatMapFunction
  import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _}
  import org.apache.flink.training.exercises.common.datatypes.{Comment}
  import org.apache.flink.training.exercises.common.sources.{CommentGenerator}
  import org.apache.flink.util.Collector

  /**
   * The "Stateful Enrichment" exercise of the Flink training in the docs.
   *
   * The goal for this exercise is to enrich TaxiRides with fare information.
   *
   */
  object CommentRemove {

    def main(args: Array[String]) {

      // set up streaming execution environment
      val env = StreamExecutionEnvironment.getExecutionEnvironment
      //env.setParallelism(ExerciseBase.parallelism)

      //val rides = env
      //  .addSource(rideSourceOrTest(new Comm()))
      //  .filter { ride => ride.isStart }
      //  .keyBy { ride => ride.rideId }

      val fares = env
        .addSource(new CommentGenerator())

      //val processed = rides
      //  .connect(fares)
      //  .flatMap(new EnrichmentFunction)

      fares.print()
      //printOrTest(processed)

      env.execute("Join Rides with Fares (scala RichCoFlatMap)")
    }

/* class EnrichmentFunction extends RichCoFlatMapFunction[TaxiRide, TaxiFare, (TaxiRide, TaxiFare)] {

  import org.apache.flink.api.common.state.ValueState

  val blocked = null
  override def flatMap1(ride: TaxiRide, out: Collector[(TaxiRide, TaxiFare)]): Unit = {

    throw new MissingSolutionException()
  }

  override def flatMap2(fare: TaxiFare, out: Collector[(TaxiRide, TaxiFare)]): Unit = {
  }

}

 */

}
