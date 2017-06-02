package business

/**
  * Created by pyous on 5/28/2017.
  */
/*
* ET — event number of seconds
* T — number of seconds since beginning of epoch at which rolling window ends.
* V — measurement of price ratio at time T.
* N — number of measurements in the window.
* RS — a rolling sum of measurements in the window.
* MinV — minimum price ratio in the window.
* MaxV — maximum price ratio the window.
* */
case class WindowMeasurement(ET: Int = 0, T: Int = 0, V: Double = 0.0, N: Int = 0, RS: Double = 0.0, MinV:Double = 0.0, MaxV: Double = 0.0)
