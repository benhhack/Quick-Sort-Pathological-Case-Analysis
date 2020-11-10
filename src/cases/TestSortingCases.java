package cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sorter.QuickSorter;

import java.util.Arrays;
import java.sql.Timestamp;

public class TestSortingCases {

    QuickSorter sorter;

    int [] initial;
    int [] sorted;
    int [] expected;

    Timestamp startTime;
    Timestamp endTime;
    long executionTime;

    PathologicalCases cases;
    Result expectedResult;

    @BeforeEach
    public void prepare() {
        // initialise new array
        initial = new int[1000];

        //initalise quick sorter
        sorter = new QuickSorter();
        cases = new PathologicalCases();
    }

    @Test
    public void fullySortedArray() {


        for (int i = 0; i < 1000; i++) {
            initial[i] = i;
        }

        sorted = initial.clone();
        startTime = new Timestamp(System.currentTimeMillis());
        sorted = sorter.quickSort(sorted, 0, sorted.length - 1);
        endTime = new Timestamp(System.currentTimeMillis());

        executionTime = endTime.getTime() - startTime.getTime();
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(executionTime);

        expectedResult = new Result("Fully Sorted", 1, "");

        assertEquals(expectedResult, cases.fullySortedArray());
        assertArrayEquals(initial, sorted);
    }

}
