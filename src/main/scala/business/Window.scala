package business

import scala.collection.mutable

/**
  * Created by pyous on 5/28/2017.
  */
class Window private(var newEvents : mutable.Queue[Event]){
  var events: mutable.Queue[Event] = newEvents
  var minV: Double = Double.MaxValue
  var maxV: Double = Double.MinValue
  var runningSum: Double = 0.0

  def reset(): Unit = {
    events.clear
    minV = Double.MaxValue
    maxV = Double.MinValue
    runningSum = 0.0
  }

  def adjustWindow(): Unit = {
    val tempEvents = events.clone()
    reset()
    while (tempEvents.nonEmpty) {
      val tempEvent = tempEvents.dequeue()
      setValues(tempEvent)
    }
  }

  def setValues(event: Event) = {
    minV = Math.min(event.price_ratio, minV)
    maxV = Math.max(event.price_ratio, maxV)
    runningSum += event.price_ratio
  }

  def add(event: Event) = {
    setValues(event)
    events.enqueue(event)
  }

  def end : Int = if (events.isEmpty) 0 else events.front.timestamp + 60
}

object Window {
  def apply(): Window = new Window(new mutable.Queue[Event])
}
