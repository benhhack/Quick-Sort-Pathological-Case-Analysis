package cases.tests;

import static org.junit.jupiter.api.Assertions.*;

import cases.PathologicalCases;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sorter.QuickSorter;

public class TestSortingCases {

    QuickSorter sorter;

    int [] initial;
    PathologicalCases cases;

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
    public void testAverageExecutionTime(){
        int [] array = new int[1000];
        for (int i =0; i < 1000; i++) {
            array[i] = i;
        }
        assertTrue(cases.findExecutionTime(array)> 0);
    }

    @Test
    public void testCreateRandomArray() {
        int [] array = cases.createRandomArray();
        assertEquals(1000, array.length);

        for (int i: array) {
            assertTrue((i <= 1000) && (i>=0));
        }
    }


}
