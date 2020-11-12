package cases;

import sorter.QuickSorter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PathologicalCases {

    final int ARRAY_LENGTH = 1000;
    final int NUMBER_OF_SORTS = 10500;
    QuickSorter sorter = new QuickSorter();

    Random random = new Random();
    int [] array;
    int [] sorted;
    Result result;
    List<Result> results;

    DecimalFormat df = new DecimalFormat("#.###");
    double startTime;
    double endTime;
    double executionTime;
    double [] executionTimes;
    double [] executionTimesNoOutliers;
    double sum;
    double averageExecutionTime;

    double sortedness;
    double sortedPairs;

    // constructor
    public PathologicalCases() {
    }

    // returns Result with average execution time of ordinary quicksort on a fully sorted list
    public  Result fullySortedArray() {

        // create fully sorted array
        array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = i;
        }

        averageExecutionTime = findExecutionTime(array);

        return new Result("Fully Sorted", 1, df.format(averageExecutionTime));
    }

    public Result reversedSorted() {
        // create fully sorted array
        array = new int[ARRAY_LENGTH];
        for (int i = ARRAY_LENGTH - 1; i > 0; i--) {
            array[i] = i;
        }

        averageExecutionTime = findExecutionTime(array);


        return new Result("Sorted in Reverse", 0, df.format(averageExecutionTime));
    }

    public Result randomArray() {
        // create a random array
        array = new int[ARRAY_LENGTH];
        for (int i = ARRAY_LENGTH - 1; i > 0; i--) {
            array[i] = random.nextInt();
        }
        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Random Sort", sortedness, df.format(averageExecutionTime));
    }

    public double findExecutionTime(int [] array) {

        executionTimes = new double[NUMBER_OF_SORTS];
        // runs the sort 25 times on original list
        for (int i = 0; i < NUMBER_OF_SORTS; i++){
            sorted = array.clone();
            startTime = System.nanoTime();
            sorted = sorter.quickSort(sorted, 0, ARRAY_LENGTH - 1);
            endTime = System.nanoTime();

            executionTime = (endTime - startTime);

            executionTimes[i] = executionTime;
        }

        Arrays.sort(executionTimes);
        executionTimesNoOutliers = Arrays.copyOfRange(executionTimes, 250, executionTimes.length - 250);


        // finds average execution time and return pathological case object
        sum = 0.0;
        for (double i: executionTimesNoOutliers){
            sum += i;
        }
        averageExecutionTime = sum / NUMBER_OF_SORTS;

        return averageExecutionTime;
    }

    public double findSortedness(int [] array) {
        sortedPairs = 0.0;
        for(int i = 1; i < array.length; i++) {
            if (array[i] > array[i -1]) sortedPairs++;
        }
        sortedness = sortedPairs/(array.length - 1);

        return sortedness;
    }
}
