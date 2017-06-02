package business

/**
  * Created by pyous on 5/28/2017.
  */
class WindowCalculator private(var window: Window) {
  var currentWindow: Window = window

  def calculate(event: Event) : WindowMeasurement = {
    if(currentWindow.events.nonEmpty && event.timestamp > currentWindow.end){
      while (currentWindow.events.nonEmpty && event.timestamp > currentWindow.end){
        currentWindow.events.dequeue()
      }
      currentWindow.adjustWindow()
    }
    if (event.timestamp <= currentWindow.end || currentWindow.end == 0){
      currentWindow.add(event)
    }
    WindowMeasurement(event.timestamp, currentWindow.end, event.price_ratio, currentWindow.events.length, currentWindow.runningSum, currentWindow.minV, currentWindow.maxV)
  }
}

object WindowCalculator {
  def apply() : WindowCalculator = new WindowCalculator(Window())
}