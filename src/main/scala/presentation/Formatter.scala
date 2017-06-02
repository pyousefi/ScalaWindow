package presentation


/**
  * Created by pyous on 5/28/2017.
  */
class Formatter {
  def format(table: Seq[Seq[Any]]) = table match {
    case Seq() => ""
    case _ =>
      val colSizes = for (row <- table) yield (for (cell <- row) yield if (cell == null) 0 else cell.toString.length)
      val maxColSizes = for (col <- colSizes.transpose) yield col.max
      val rows = for (row <- table) yield formatRow(row, maxColSizes)
      formatRows(rowSeparator(maxColSizes), rows)
  }

  def formatRow(row: Seq[Any], maxColSizes: Seq[Int]) = {
    val cells = (for ((item, size) <- row.zip(maxColSizes)) yield if (size == 0) "" else item + ("%" + (size-item.toString().length()+1) + "s").format(" "))
    cells.mkString(" ", " ", " ")
  }

  def rowSeparator(maxColSizes: Seq[Int]) = maxColSizes map { "-" * _ } mkString("--","--","--")

  def formatRows(rowSeparator: String, rows: Seq[String]): String = (
    rows.head ::
      rowSeparator ::
      rows.tail.toList :::
      List()).mkString("\n")


}
