package cases;

import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;
import sorter.QuickSorter;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class SortRunner {
    private static final String CSV_SEPARATOR = ",";


    public static void main(String[] args) throws IOException {

        // create cases object and results list
        PathologicalCases cases = new PathologicalCases();
        ArrayList<Result> results = new ArrayList<>();

        // add results to arraylist
        results.add(cases.fullySortedArray());
        writeToCSV(results);
    }

    private static void writeToCSV(ArrayList<Result> results)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./results.csv"), "UTF-8"));
            for (Result result : results)
            {
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
        } catch (IOException e){}
    }
}
