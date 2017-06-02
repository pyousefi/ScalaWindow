package business

/**
  * Created by pyous on 5/28/2017.
  */

case class Event(timestamp: Int, price_ratio: Double){
  def this(timestamp: String, price_ratio: String) =  this(timestamp.toInt, price_ratio.toDouble)
}
