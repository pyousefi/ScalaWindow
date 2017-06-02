package runtime

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by pyous on 5/28/2017.
  */
class ProgramTest extends FlatSpec with Matchers{

  it should "throw IllegalArgumentException if no filename passed" in {
    an [IllegalArgumentException] should be thrownBy(Program.main(new Array[String](0)))
  }
}
