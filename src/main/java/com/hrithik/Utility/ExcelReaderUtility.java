package com.hrithik.Utility;

import jakarta.annotation.PostConstruct;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelReaderUtility {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelReaderUtility.class);
    @Value("${excelPath}")
    public String PATH;
    @PostConstruct
    public String getPath(){
        LOGGER.info("**** Excel Path : [{}] ***** " ,PATH);
        return PATH;
    }
    public List<String> getDataByColumn(String sheetName,int columnNum){
        List<String> data = new ArrayList<>();
        Workbook workbook = getWorkBook();
        Sheet sheet = workbook.getSheet(sheetName);
        for (Row row : sheet) {
            if (row != null) {
                Cell cell = row.getCell(0);
                if (cell != null) {
                    data.add(cell.toString());
                }
            }
        }
        LOGGER.info("**** Sheet Name : [{}] , Column Number : [{}] and Number-Of-Row : [{}] ***** ", sheetName, columnNum,data.size());
        return data;
    }

    public List<String> getAllSheetName() {
        List<String> sheetList = new ArrayList<>();
        Workbook workBook = getWorkBook();
        int numberOfSheets = workBook.getNumberOfSheets();
        LOGGER.info("**** Number of Sheet in Excel : [{}] is [{}] ***** ", PATH, numberOfSheets);
        for (int i = 0; i < numberOfSheets; i++) {
            sheetList.add(workBook.getSheetName(i));
        }
        return sheetList;
    }
    public Workbook getWorkBook() {
        Workbook workbook = null;
        File file = getFile(PATH);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            if (file.getAbsolutePath().endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fileInputStream);
            } else if (file.getAbsolutePath().endsWith(".xls")) {
                workbook = new HSSFWorkbook(fileInputStream);
            }
        } catch (Exception e) {
            LOGGER.info("*** Please Check Excel File Format : [{}] *** ", e.getMessage());
        }
        return workbook;
    }

    public File getFile(String filePath) {
        File file = null;
        if (filePath != null) {
            file = new File(filePath);
            if (file.isFile()) LOGGER.info("*** File is [{}] already Exist *** ", filePath);
            else {
                try {
                    file.createNewFile();
                    LOGGER.info("*** File is [{}] Created *** ", filePath);
                } catch (Exception e) {
                    LOGGER.info("Some-Thing Went Wrong in File Creation : [{}]", e.getMessage());
                }
            }
        } else {
            LOGGER.info("*** Please Configure Excel File Path : [{}] *** ", filePath);
        }
        return file;
    }
}
