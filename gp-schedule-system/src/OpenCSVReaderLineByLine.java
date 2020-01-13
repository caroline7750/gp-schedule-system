import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @sources https://www.callicoder.com/java-read-write-csv-file-opencsv/ AND 
 * https://www.journaldev.com/12014/opencsv-csvreader-csvwriter-example
 */

public class OpenCSVReaderLineByLine {
//    private static final String SAMPLE_CSV_FILE_PATH = ".csv"; //check this
//    ArrayList<Student> students = new ArrayList<Student>();

    public static void read_CSV(String file_name, PersonLinkedList students) throws IOException //put data structure in parenthesis
    {
            //Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH)); how to get file?
            CSVReader csvReader = new CSVReader(reader);
       
            // Reading Records One by One in a String array
            String[] record;
            try
            {
                while ((record = csvReader.readNext()) != null) { //csv reader read next
                        Student s = new Student();
                        int S_ID = (Integer.parseInt(record[0]));
                        String Name = (record[1]);
                        students.add(new Student());
                }
            }
            catch (Exception e)
            {
                //should i do anything here - look into CSV Validation Exception
            }

    }
    
}
