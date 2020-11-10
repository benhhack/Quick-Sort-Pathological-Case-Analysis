package cases;

import sorter.QuickSorter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PathologicalCases {

    final int ARRAY_LENGTH = 1000;
    final int NUMBER_OF_SORTS = 25;
    QuickSorter sorter = new QuickSorter();
    int [] array;
    int [] sorted;
    Result result;
    List<Result> results;

    DecimalFormat df = new DecimalFormat("#.###");
    double startTime;
    double endTime;
    double executionTime;
    List<Double> executionTimes;
    double sum;
    double averageExecutionTime;

    Result fullySorted;
    Result notSorted;
    Result twentyFiveSorted;
    Result fiftySorted;
    Result seventyFifeSorted;


    // constructor
    public PathologicalCases() {
//        this.fullySorted = fullySortedArray();
    }

    // getter for fully sorted array
    public Result getFullySorted() {
        return fullySorted;
    }

    // returns Result with average execution time of ordinary quicksort on a fully sorted list
    public  Result fullySortedArray() {
        executionTimes = new ArrayList<>();
        // create fully sorted array
        array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = i;
        }

        // runs the sort 25 times on original list
        for (int i = 0; i < NUMBER_OF_SORTS; i++){
            sorted = array.clone();
            startTime = System.nanoTime();
            sorted = sorter.quickSort(sorted, 0, ARRAY_LENGTH - 1);
            endTime = System.nanoTime();

            executionTime = (endTime - startTime)/1000000;

            executionTimes.add(executionTime);
        }

        // finds average execution time and return pathological case object
        sum = 0.0;
        for (double i: executionTimes){
            System.out.println(i);
            sum += i;
        }
        averageExecutionTime = sum / NUMBER_OF_SORTS;

        return new Result("Fully Sorted", 1, df.format(averageExecutionTime));
    }
}
