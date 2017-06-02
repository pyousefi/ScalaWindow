package runtime

import business.MyController
import presentation.Formatter


object Program {
  def main(args: Array[String]): Unit = {
    require(args.length > 0, "No filename passed")
    val measurements = new MyController().GetMeasurements(args(0))
    print(new Formatter().format(measurements))
  }
}
