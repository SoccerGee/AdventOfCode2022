import os._

@main def main: Unit = 
  val filePath = pwd / "src" / "main" / "scala" / "food"
  var largestSum = 0
  var sum = 0
  for line <- read.lines.stream(filePath) do 
    line match
      case l if l == "" =>
        if sum > largestSum then largestSum=sum
        sum = 0
      case _ => sum += line.toInt
  println(largestSum)
