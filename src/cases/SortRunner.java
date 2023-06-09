package cases;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;


public class SortRunner {
    private static final String CSV_SEPARATOR = ",";


    public static void main(String[] args) {

        // create cases object and results list
        PathologicalCases cases = new PathologicalCases();
        ArrayList<Result> results = new ArrayList<>();

        // add results to arraylist
        results.add(new Result("Case", "Sortedness", "AverageExecutionTime(ms)"));

        // fully sorted
        results.add(cases.fullySorted());
        results.add(cases.firstHigher());
        results.add(cases.firstMedian());

        results.add(cases.allSame());
        results.add(cases.lastLower());
        results.add(cases.lastMedian());


        // unsorted
        results.add(cases.reversedSorted());
        results.add(cases.reversedFirstLower());
        results.add(cases.reversedFirstMedian());
        results.add(cases.reversedLastHigher());
        results.add(cases.unsortedLastMedian());

        // half sorted
        results.add(cases.zigzag());
        results.add(cases.halfSorted());
        results.add(cases.halfSortedLastHigher());
        results.add(cases.halfSortedLastLower());
        results.add(cases.halfSortedLastMedian());
        results.add(cases.halfSortedFirstLower());
        results.add(cases.halfSortedFirstHigher());
        results.add(cases.halfSortedFirstMedian());

        // 1/4 sorted
        results.add(cases.quarterSorted());
        results.add(cases.quarterSortedFirstHigher());
        results.add(cases.quarterSortedFirstLower());
        results.add(cases.quarterSortedFirstMedian());
        results.add(cases.quarterSortedLastHigher());
        results.add(cases.quarterSortedLastLower());
        results.add(cases.quarterSortedLastMedian());

        // 3/4 sorted
        results.add(cases.threeQuarterSorted());
        results.add(cases.threeQuarterSortedFirstHigher());
        results.add(cases.threeQuarterSortedFirstLower());
        results.add(cases.threeQuarterSortedFirstMedian());
        results.add(cases.threeQuarterSortedLastHigher());
        results.add(cases.threeQuarterSortedLastLower());
        results.add(cases.threeQuarterSortedLLastMedian());



        writeToCSV(results);

    }

    private static void writeToCSV(ArrayList<Result> results)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./results.csv"), StandardCharsets.UTF_8));
            for (Result result : results) {
                String oneLine = result.getName() +
                        CSV_SEPARATOR +
                        result.getSortedness() +
                        CSV_SEPARATOR +
                        result.getAverageExecutionTime();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
        }
    }
}
