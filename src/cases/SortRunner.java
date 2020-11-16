package cases;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SortRunner {
    private static final String CSV_SEPARATOR = ",";


    public static void main(String[] args) throws IOException {

        // create cases object and results list
        PathologicalCases cases = new PathologicalCases();
        ArrayList<Result> results = new ArrayList<>();

        // add results to arraylist
        results.add(new Result("Case", "Sortedness", "AverageExecutionTime"));
        results.add(cases.fullySortedArray());
        results.add(cases.reversedSorted());
        results.add(cases.allSame());
        results.add(cases.firstHigher());
        results.add(cases.lastLower());
        results.add(cases.zigzag());
        results.add(cases.halfSorted());
//        results.add(cases.lastQuarterSorted());

        writeToCSV(results);
    }

    private static void writeToCSV(ArrayList<Result> results)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./results.csv"), "UTF-8"));
            for (Result result : results) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(result.getName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(result.getSortedness())  ;
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(result.getAverageExecutionTime());
                bw.write(oneLine.toString());
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
