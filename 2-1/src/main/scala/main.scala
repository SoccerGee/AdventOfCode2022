import os._

@main def main: Unit = 
  // Wins is easily defined and small enough for thise Space + Time Complexity to work
  val wins = Map(
    "A Y" -> 6,
    "B Z" -> 6,
    "C X" -> 6,
  )
  val draws = List(
    "A X",
    "B Y",
    "C Z"
  )
  // Easy lookup and result.
  val shapeScoreMap = Map(
    "X" -> 1,
    "Y" -> 2,
    "Z" -> 3
  )
  def isDrawReturn3OrZero(line : String): Int = if draws.contains(line) then 3 else 0
  var score = 0;
  // you know the drill... get the daggum input
  val filePath = pwd / "src" / "main" / "scala" / "cheat_sheet"
  for line <- read.lines.stream(filePath) do
    // get the game outcome score
    score += wins.getOrElse(line, isDrawReturn3OrZero(line)) + shapeScoreMap.getOrElse(line.split(" ").last, 0)
  println(score)