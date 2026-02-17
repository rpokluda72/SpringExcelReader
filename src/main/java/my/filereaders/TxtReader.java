package my.filereaders;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TxtReader {

    Logger logger = Logger.getLogger(TxtReader.class.getName());

    public String getTxtContent(String fileLocation) {
        try (InputStream inputStream = TxtReader.class.getClassLoader().getResourceAsStream(fileLocation)) {
            if (inputStream == null) {
                log(Level.INFO,"File " + fileLocation + " not found!");
                return null;
            }
            return new Scanner(inputStream).useDelimiter("\\Z").next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    private void log(Level level, String textToLog) {
        logger.log(level, textToLog);
//        System.out.println(textToLog);
    }
}
