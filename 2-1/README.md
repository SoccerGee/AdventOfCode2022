On this challenge, it's a matter of deciding if there is a win condition, and adding the correct value followed by adding an additional value based on your `shape`.

A win can be represented in the following way:
```
win  ==  (A,Y) | (B,Z) | (C,X) -> 6
```
The others were a little more straight forward:
```
draw ==  (n == n) -> 3
lose ==  (anything else) -> 0
```


There were a few different ways I explored being able to match and determine the win.  Did you know that tuples have the matchable trait... see [https://dotty.epfl.ch/api/scala/Tuple.html](here), and here for more information on the [https://docs.scala-lang.org/scala3/reference/other-new-features/matchable.html](matchable trait).

tested this in the repl with:
```
scala> (1,2) == (2,3)
val res3: Boolean = false

scala> (1,2) == (1,2)
val res4: Boolean = true
```

However, that's boring.  I didn't go that route.  I just created a bunch of look ups, and did some math.

One of the interesting challenges was selecting the right datatypes to do the lookups.  Here's a few things I learned in the process:

1) Maps gave me fits because as you can see below, Map.get() is defined as `def get(key: K): Option[V]` which returns `Option[V]`.  The compiler did not like this when doing math, due to the fact that the value might not be there.  The quick and dirty solution is to use `.getOrElse()` and ensure that atleast some integer comes back after the lookup.  I'm ashamed of myself for this.
```score += wins.getOrElse(line, isDrawReturn3OrZero(line)) + shapeScoreMap.getOrElse(line.split(" ").last, 0)```

2) It was easier to do a lookup in a List using contains with out splitting the input line into two separate values here:
```  
val draws = List(
  "A X",
  "B Y",
  "C Z"
)
```

There has to be a way to do this in one line using functional programming principles... I'll be on the look out.

```
[info] running main
12679
[success] Total time: 1 s, completed Dec 13, 2022 2:13:02 AM
```