package business

import scala.collection.mutable.ListBuffer
import scala.io.Source
import resource._

class MyController() {
  def GetMeasurements(fileName: String) : List[List[Any]] = {
    var listBuffer: ListBuffer[List[Any]] = new ListBuffer[List[Any]]
    val windowCalculator = WindowCalculator()
    listBuffer += List("ET", "T", "V", "N", "RS", "MinV", "MaxV")

    for {
      source <- managed(Source.fromFile(fileName))
    }
    {
      for (line <- source.getLines()) {
        //ToDo: Assert file format
        val splitLine = line.split("	")
        val event = new Event(splitLine(0), splitLine(1))
        val measurement = windowCalculator.calculate(event)
        listBuffer += List(measurement.ET, measurement.T.toString, measurement.V, measurement.N, f"${measurement.RS}%1.5f", measurement.MinV, measurement.MaxV)
      }
    }
    listBuffer.toList
  }
}