See the previous (../1/README.md)[README] for more explaination about the code.  I'm only going to discuss specifically the part of my solution that required a change to complete part 2.

I needed to adapt the match case to support the new data type we were going to need to use in order to track the largest three calorie counts.  I created a list, and the plan was to LIFO check to see which was higher.  If the new calorie count was higher then add it to the list, sort the list in ascending order, and then chop off the lowest first item if contained more than 3 calorie counts.  Sorting was no big deal due to the size of the list never exceeding three calorie counts.  Once all lines had been iterated, sum the largest three.  Boom!
```scala
    var largestThree = List[Int]()
    
// ...
    
    case l if l == "" =>
        if largestThree.length == 0 then largestThree = sum :: largestThree
        else if largestThree.head < sum then largestThree = sum :: largestThree 
        
        largestThree = largestThree.sorted
        
        if largestThree.length > 3 
            then largestThree = largestThree.drop(1)
    
        sum = 0

// ...
    
    println(largestThree.sum)
```


output:
```
[info] running main
203905
[success] Total time: 0 s, completed Dec 4, 2022 8:11:46 AM
```
