package cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sorter.QuickSorter;

import java.util.Arrays;
import java.sql.Timestamp;

public class SortingCases {

    QuickSorter sorter;

    int [] initial;
    int [] sorted;
    int [] expected;

    Timestamp startTime;
    Timestamp endTime;
    long executionTime;

    @BeforeEach
    public void prepare() {
        // initialise new array
        initial = new int[1000];

        //initalise quick sorter
        sorter = new QuickSorter();
    }

    @Test
    public void fullySortedArray() {


        for (int i = 0; i < 1000; i++) {
            initial[i] = i;
        }

        startTime = new Timestamp(System.currentTimeMillis());
        sorted = sorter.quickSort(initial, 0, initial.length - 1);
        endTime = new Timestamp(System.currentTimeMillis());

        executionTime = endTime.getTime() - startTime.getTime();
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(executionTime);


        assertArrayEquals(initial, sorted);
    }

}
