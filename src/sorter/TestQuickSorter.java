package sorter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestQuickSorter {
    @Test
    public void testQuickSortStandard() {
        int [] input=new int[]{6,1,7,9,3,8,2,5,4,0};
        QuickSorter sort = new QuickSorter();
        int[] sortedArray = sort.quickSort(input, 0, input.length - 1);
        Arrays.sort(input);
        assertArrayEquals(input, sortedArray);
    }
}
