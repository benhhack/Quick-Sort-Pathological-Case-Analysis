# Project

This project implements an ordinary (not in place) quicksort on a number of different pathalogical cases.
It then analyses the execution times of running these algorithms to examine the performance of the quicksort on 
these cases.

## Using the Project

Go into the `src` folder and run
```bash
javac *.java
java SortRunner.java

```
to run the sorter on the pathological cases. The data in `results.csv` will be overwritten when the Sort Runner is executed. 
From there, run the analysis (analysis.ipynb) to get the graphical output. An analysis of the results can be found in Report.pdf.

The tests can be run within sorter package and the cases.tests package.
Note that the Pathological Cases methods which 
create arrays were not tested. 