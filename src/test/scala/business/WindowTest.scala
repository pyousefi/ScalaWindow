package business

import org.scalatest.FlatSpec

import scala.util.Random

/**
  * Created by pyous on 5/30/2017.
  */
class WindowTest extends FlatSpec {

  var window = Window() //object initializer through apply
  var random = new Random()

  behavior of "A Window"

  it should "have default values on initialize " in {
    assert(window.end ==0)
    assert(window.events.isEmpty)
    assert(window.maxV == Double.MinValue)
    assert(window.minV == Double.MaxValue)
    assert(window.runningSum == 0)
  }

  it should "set values for event" in {
    val timestamp = random.nextInt
    val price_ratio = random.nextDouble
    val event = Event(timestamp, price_ratio)
    window.add(event)
    assert(window.end ==timestamp+60)
    assert(window.events.length == 1)
    assert(window.maxV == price_ratio)
    assert(window.minV == price_ratio)
    assert(window.runningSum == price_ratio)
  }

  it should "have default values after reset " in {
    window.reset()
    assert(window.end ==0)
    assert(window.events.isEmpty)
    assert(window.maxV == Double.MinValue)
    assert(window.minV == Double.MaxValue)
    assert(window.runningSum == 0)
  }
}
