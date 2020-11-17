package cases.tests;

import static org.junit.jupiter.api.Assertions.*;

import cases.PathologicalCases;
import cases.Result;
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

    /*
     * Tests the sortedness method
     */
    @Test
    public void testSortedness(){
        int [] array = {1,2,3,4,5,6,7,8,9};
        assertEquals(1, cases.findSortedness(array));

        int [] array1 = {9,8,7,6,5,4,3,2,1};
        assertEquals(0, cases.findSortedness(array1));

        int [] array2 = {1,2,3,4,5,4,3,2,1,};
        assertEquals(0.5, cases.findSortedness(array2));
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

        expectedResult = new Result("Fully Sorted", "", "");

        assertEquals(expectedResult, cases.fullySorted());
        assertArrayEquals(initial, sorted);
    }

}
