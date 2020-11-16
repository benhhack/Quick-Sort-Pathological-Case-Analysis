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

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Sorted", df.format(sortedness), df.format(averageExecutionTime));
    }

    public Result reversedSorted() {
        // create fully reversed array
        array = new int[ARRAY_LENGTH];

        int j = ARRAY_LENGTH;
        for (int i = ARRAY_LENGTH - 1; i > 0; i--) {
            array[i] = ARRAY_LENGTH-i;
        }

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("Reversed", df.format(sortedness), df.format(averageExecutionTime));
    }

    public Result allSame() {
        // create arrays of 1s
        array = new int[ARRAY_LENGTH];

        for (int i = ARRAY_LENGTH - 1; i > 0; i--) {
            array[i] = 1;
        }

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("All Same", df.format(sortedness), df.format(averageExecutionTime));
    }

    public Result firstHigher() {
        // create arrays of 1s
        array = new int[ARRAY_LENGTH];

        array[0] = 1001;
        for (int i = 1; i < ARRAY_LENGTH; i++) {
            array[i] = i;
        }

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("First Higher", df.format(sortedness), df.format(averageExecutionTime));
    }

    public Result lastLower() {
        // create arrays of 1s
        array = new int[ARRAY_LENGTH];

        for (int i = 1; i < ARRAY_LENGTH - 1; i++) {
            array[i] = i;
        }
        array[999] = 0;

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("Last Lower", df.format(sortedness), df.format(averageExecutionTime));
    }

    public Result zigzag() {
        // create arrays of 1s
        array = new int[ARRAY_LENGTH];

        for (int i = 0; i < ARRAY_LENGTH; i = i + 2) {
            array[i] = i;
            array[i+1] = 1;
        }
        array[999] = 0;

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("Zigzag", df.format(sortedness), df.format(averageExecutionTime));
    }

    public Result halfSorted() {
        // create a random array
        array = new int[ARRAY_LENGTH];
        for (int i = ARRAY_LENGTH - 1; i > 0; i--) {
            array[i] = random.nextInt();
        }
        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Random Sort", df.format(sortedness), df.format(averageExecutionTime));
    }

    public Result lastQuarterSorted(){

        array = new int[ARRAY_LENGTH];


        for (int i = ARRAY_LENGTH -1 ; i > 749; i--) {
            array[i] = i;
        }

        for (int i = 749; i > 0; i--) {
            array[i] = random.nextInt();
        }
        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Last Quarter Sorter", df.format(sortedness), df.format(averageExecutionTime));
    }

    public double findExecutionTime(int [] array) {

        executionTimes = new double[NUMBER_OF_SORTS];
        // runs the sort 25 times on original list
        for (int i = 0; i < NUMBER_OF_SORTS; i++){
            sorted = array.clone();
            startTime = System.currentTimeMillis();
            sorted = sorter.quickSort(sorted, 0, ARRAY_LENGTH - 1);
            endTime = System.currentTimeMillis();

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
            if (array[i] >= array[i -1]) sortedPairs++;
        }
        sortedness = sortedPairs/(array.length - 1);

        return sortedness;
    }
}
