package at.reinisoft;

import at.reinisoft.domain.LotteryNumbers;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stocki on 24.01.15.
 */
public class CsvFileReader {

    //CSV file header
    private static final String [] FILE_HEADER_MAPPING = {"Zahl1","Zahl2","Zahl3","Zahl4","Zahl5","Zahl6","ZusatzZahl","Datum"};

    private static final String NUMBER_1 = "Zahl1";
    private static final String NUMBER_2 = "Zahl2";
    private static final String NUMBER_3 = "Zahl3";
    private static final String NUMBER_4 = "Zahl4";
    private static final String NUMBER_5 = "Zahl5";
    private static final String NUMBER_6 = "Zahl6";
    private static final String NUMBER_7 = "ZusatzZahl";
    private static final String DRWADATE = "Datum";

    public static List<LotteryNumbers> readCsvFile(String fileName) {

        List<LotteryNumbers> numbers = new ArrayList();

        try {
            CSVReader reader = new CSVReader(new FileReader(fileName));

            String[] line;
            while ((line = reader.readNext()) != null) {
                numbers.add(new LotteryNumbers(line));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       return numbers;
    }

}
