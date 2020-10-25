package testbase;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    String filepath;
    File src;
    FileInputStream file;
    String sheetname;
    XSSFWorkbook book;



    public ExcelReader(ExcelReaderBuilder builder)
    {
        this.filepath = builder.fileName;
        this.sheetname = builder.sheetName;

    }

    public List<List<String>> getSheetData(String sheetname)
    {
        try{
            book = new XSSFWorkbook(file);
        }catch(Exception e)
        {
            e.getLocalizedMessage();
        }
        List<List<String>> outerList = new ArrayList<List<String>>();

        XSSFSheet sheet = book.getSheet(sheetname);
        for(int i = sheet.getFirstRowNum(); i<sheet.getLastRowNum(); i++)
        {
            List<String> innerList = new ArrayList<String>();
            XSSFRow row = sheet.getRow(i);
            for(int j = row.getFirstCellNum(); j<row.getLastCellNum(); j++)
            {
                switch(row.getCell(j).getCellType())
                {
                    case STRING:
                        innerList.add(row.getCell(j).getStringCellValue());
                        break;

                    case NUMERIC:
                    innerList.add(row.getCell(j).getNumericCellValue()+ "");
                    break;

                    case BOOLEAN:
                        innerList.add(row.getCell(j).getBooleanCellValue()+ "");
                        break;

                    case BLANK:
                        innerList.add("");
                        break;

                    default:
                        throw new IllegalArgumentException("Cannot read the column : " + j);
                }
            }
            outerList.add(innerList);
        }
        return outerList;

    }

    public static class ExcelReaderBuilder {

        private String fileName;
        private String sheetName;

        public ExcelReaderBuilder setFileLocation(String location) {
            this.fileName = location;
            return this;
        }

        public ExcelReaderBuilder setSheet(String sheetName) {
            this.sheetName = sheetName;
            return this;
        }

        public ExcelReader build() {
            return new ExcelReader(this);
        }

    }
}
