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

    /*
     * Sortedness = 1
     */
    // sorted array
    public  Result fullySorted() {

        // create fully sorted array
        array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = i;
        }

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Sorted", df.format(sortedness), df.format(averageExecutionTime));
    }

    // sorted with first higher
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

    // sorted with first lower
    public Result firstLower() {
        // create arrays of 1s
        array = new int[ARRAY_LENGTH];

        array[0] = -1;
        for (int i = 1; i < ARRAY_LENGTH; i++) {
            array[i] = i;
        }

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("First Lower", df.format(sortedness), df.format(averageExecutionTime));
    }

    // sorted with first median
    public Result firstMedian() {
        // create arrays of 1s
        array = new int[ARRAY_LENGTH];

        array[0] = 499;
        for (int i = 1; i < ARRAY_LENGTH; i++) {
            array[i] = i;
        }

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("First Median", df.format(sortedness), df.format(averageExecutionTime));
    }

    //sorted with last higher
    public Result lastHigher() {
        // create arrays of 1s
        array = new int[ARRAY_LENGTH];

        for (int i = 1; i < ARRAY_LENGTH - 1; i++) {
            array[i] = i;
        }
        array[999] = 1001;

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("Last Higher", df.format(sortedness), df.format(averageExecutionTime));
    }

    //sorted with last lower
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

    // fully sorted last mediam
    public  Result lastMedian() {

        // create fully sorted array
        array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH-1; i++) {
            array[i] = i;
        }
        array[999] = 499;

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Last Median", df.format(sortedness), df.format(averageExecutionTime));
    }

    // all values the same
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

    /*
     * Sortedness = 0
     */
    // completely unsorted array
    public Result reversedSorted() {
        // create fully reversed array
        array = new int[ARRAY_LENGTH];

        for (int i = ARRAY_LENGTH - 1; i > 0; i--) {
            array[i] = ARRAY_LENGTH-i;
        }

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("Reversed", df.format(sortedness), df.format(averageExecutionTime));
    }

    // unsorted first lower
    public Result reversedFirstLower(){
        array = new int[ARRAY_LENGTH];
        array[0] = -1;

        for (int i = ARRAY_LENGTH - 1; i > 1; i--) {
            array[i] = ARRAY_LENGTH-i;
        }
        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("Reversed First Lower", df.format(sortedness), df.format(averageExecutionTime));

    }

    // unsorted last higher
    public Result reversedLastHigher(){
        array = new int[ARRAY_LENGTH];
        array[999] = 1001;

        for (int i = ARRAY_LENGTH - 2; i > 0; i--) {
            array[i] = ARRAY_LENGTH-i;
        }
        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("Reversed Last Higher", df.format(sortedness), df.format(averageExecutionTime));

    }

    // reversed last median
    public  Result unsortedLastMedian() {

        // create fully sorted array
        array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH-1; i++) {
            array[i] = ARRAY_LENGTH - i;
        }
        array[999] = 499;

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Unsorted last median", df.format(sortedness), df.format(averageExecutionTime));
    }

    /*
     * Sortedness = 0.5
     */

    // zigzagging values
    public Result zigzag() {
        // create arrays of 1s
        array = new int[ARRAY_LENGTH];

        for (int i = 0; i < ARRAY_LENGTH; i = i + 2) {
            array[i] = i;
            array[i+1] = -2;
        }
        array[999] = 0;

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);


        return new Result("Zigzag", df.format(sortedness), df.format(averageExecutionTime));
    }

    // random vals (half sorted)
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

    public Result semiSortedLastMedian() {
        int max = 1000;
        int min = 0;
        array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH-1; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        array[999] = 499;

        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Random last median", df.format(sortedness), df.format(averageExecutionTime));
    }

    /*
     * Sortedness = 0.75
     */
    // first half same, second half random
    public Result firstHalfSame() {
        array = new int[ARRAY_LENGTH];
         for (int i = 0; i < ARRAY_LENGTH; i++) {
             array[i] = i < 500 ? 1: random.nextInt();
         }
        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("1st Half Same", df.format(sortedness), df.format(averageExecutionTime));
    }

    // last half same, first half random
    public Result lastHalfSame() {
        array = new int[ARRAY_LENGTH];
         for (int i = 0; i < ARRAY_LENGTH; i++) {
             array[i] = i > 500 ? 1: random.nextInt();
         }
        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Last Half Same", df.format(sortedness), df.format(averageExecutionTime));
    }

    // middle half same
    public Result middleHalfSame() {
        array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = (i > 250 && i < 750) ? 1: random.nextInt();
        }
        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Middle Half Same", df.format(sortedness), df.format(averageExecutionTime));
    }

    /*
     * Sortedness = 0.25
     */

    // quater sort
    public Result quarterSorted() {
        // create a random array
        array = new int[ARRAY_LENGTH];
        for (int i = ARRAY_LENGTH - 1; i > 0; i--) {
            array[i] = i % 4 == 0 ? 1: ARRAY_LENGTH - i;
        }
        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Quarter sort", df.format(sortedness), df.format(averageExecutionTime));
    }

    // quater sort
    public Result quarterSortedLastHigher() {
        // create a random array
        array = new int[ARRAY_LENGTH];
        for (int i = ARRAY_LENGTH - 2; i >= 0; i--) {
            array[i] = i % 4 == 0 ? 1: ARRAY_LENGTH - i;
        }
        array[999] = 1001;
        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Quarter sort last higher", df.format(sortedness), df.format(averageExecutionTime));
    }

    // quater sort
    public Result quarterSortedLastLower() {
        // create a random array
        array = new int[ARRAY_LENGTH];
        for (int i = ARRAY_LENGTH - 1; i > 1; i--) {
            array[i] = i % 4 == 0 ? 1: ARRAY_LENGTH - i;
        }
        array[999] = 1001;
        sortedness = findSortedness(array);
        averageExecutionTime = findExecutionTime(array);

        return new Result("Quarter sort last lower", df.format(sortedness), df.format(averageExecutionTime));
    }

    /*
     * Utility functions
     */

    // function for finding execution time
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

    // function for finding sortedness
    public double findSortedness(int [] array) {
        sortedPairs = 0.0;
        for(int i = 1; i < array.length; i++) {
            if (array[i] >= array[i -1]) sortedPairs++;
        }
        sortedness = sortedPairs/(array.length - 1);

        return sortedness;
    }
}
