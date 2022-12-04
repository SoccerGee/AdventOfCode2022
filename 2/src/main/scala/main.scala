import os._

@main def main: Unit = 
  val filePath = pwd / "src" / "main" / "scala" / "food"
  var sum = 0
  var largestThree = List[Int]()
  for line <- read.lines.stream(filePath) do 
    line match
      case l if l == "" =>
        if largestThree.length == 0 then largestThree = sum :: largestThree
        else if largestThree.head < sum then largestThree = sum :: largestThree 
        
        largestThree = largestThree.sorted
        
        if largestThree.length > 3 
          then largestThree = largestThree.drop(1)
        
        sum = 0
      case _ => sum += line.toInt
  println(largestThree.sum)
