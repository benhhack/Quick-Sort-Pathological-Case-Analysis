package cases;

import sorter.QuickSorter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class SortRunner {

    final int ARRAY_LENGTH = 1000;
    final int NUMBER_OF_SORTS = 25;
    QuickSorter sorter = new QuickSorter();
    int [] array;
    int [] sorted;
    PathologicalCase result;

    Timestamp startTime;
    Timestamp endTime;
    long executionTime;
    List<Long> executionTimes;
    long sum;
    long averageExecutionTime;


    public static void main(String[] args) throws IOException {

        // path to csv and file writer object
        String csvFile = ".../results.csv";
        FileWriter writer = new FileWriter(csvFile);

        // initalise a results list
        List<PathologicalCase> results = new ArrayList<>();

        // run pathological cases

        results.add()

    }

    private PathologicalCase fullySortedArray() {

        // create fully sorted array
        array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = i;
        }

        // runs the sort 25 times on original list
        for (int i = 0; i < NUMBER_OF_SORTS; i++){
            sorted = array.clone();
            startTime = new Timestamp(System.currentTimeMillis());
            sorted = sorter.quickSort(sorted, 0, ARRAY_LENGTH - 1);
            endTime = new Timestamp(System.currentTimeMillis());

            executionTime = endTime.getTime() - startTime.getTime();
            executionTimes.add(executionTime);
        }

        // finds average execution time and return pathological case object
        sum = 0;
        for (long i: executionTimes){
            sum += i;
        }
        averageExecutionTime = sum / NUMBER_OF_SORTS;
        return new PathologicalCase("Fully Sorted", 1, averageExecutionTime);
    }


}
