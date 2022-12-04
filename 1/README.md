I used (https://www.lihaoyi.com/)[Haoyi's] (https://github.com/com-lihaoyi/os-lib)[os-lib] to help parse the big food file.  Big props!  Very Helpful!

I used `os.read.lines.stream` to send each individual line as a stream to the for loop to avoid increasing the memory impact of the large food file.

I thougth the `match` could help with the readability of the different decisions we had to make on each line.  We only needed to catch the blank in order to decide if the largestSum needed to be set and the sum reset.  Every other line could fall through to the catch all where we can sum up the "calories".  However `read.lines.stream` reads each line as a string, so we need to cast the line to an integer in order to add the "calories" to the sum.


output:
```
[info] running main
70764
[success] Total time: 1 s, completed Dec 4, 2022 6:49:40 AM
```