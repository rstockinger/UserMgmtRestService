package at.reinisoft;

import at.reinisoft.domain.LotteryNumbers;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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

        FileReader fileReader = null;

        CSVParser csvFileParser = null;

        //Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

        //Create a new list of lotteryNumbers to be filled by CSV file data
        List<LotteryNumbers> lnumbers = new ArrayList();

        try {

            //initialize FileReader object
            fileReader = new FileReader(fileName);

            //initialize CSVParser object
            csvFileParser = new CSVParser(fileReader, csvFileFormat);

            //Get a list of CSV file records
            List<CSVRecord> csvRecords = csvFileParser.getRecords();

            //Read the CSV file records starting from the second record to skip the header
            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = csvRecords.get(i);
                //Create a new Lotterynumber object and fill his data
                LotteryNumbers lotteryNumbers = new LotteryNumbers(record.get(NUMBER_1), record.get(NUMBER_2), record.get(NUMBER_3), record.get(NUMBER_4), record.get(NUMBER_5), record.get(NUMBER_6), record.get(NUMBER_7), record.get(DRWADATE));
                lnumbers.add(lotteryNumbers);
            }

            //Print the new lotterynumber list
            for (LotteryNumbers lottery_numbers : lnumbers) {
                System.out.println(lottery_numbers.toString());
            }

        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader/csvFileParser !!!");
                e.printStackTrace();
            }
        }

       return lnumbers;
    }

}
