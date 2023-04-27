import scala.annotation.tailrec

object Main {

  def main(args: Array[String]): Unit = {
    //    println("Hello, Scala")
    println(sum(3, 0)) // 6
  }

  @tailrec
  def sum(n: Long, accumulator: Long): Long = {
    if (n == 1) {
      return 1 + accumulator
    }
    return sum(n - 1, n + accumulator)
  }

  /*
  sum(n=3, accumulator=0): Long = {
    return sum(2, 3)
  }
  sum(n=2, accumulator=3): Long = {
    return sum(1, 5)
  }
  sum(n=1, accumulator=5): Long = {
    if (n == 1) {
      return 1 + 5
    }
  }
   */

}
