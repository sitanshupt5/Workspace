package testbase;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {
     String filepath;
     File src;
     FileInputStream file;

     public void setFilePath(String path)
     {
         try{
             filepath = path;
             src = new File(filepath);
             file = new FileInputStream(src);
         }catch(Exception e)
         {
             e.getLocalizedMessage();
         }
     }


     public void closeFile()
     {
         try{
             file.close();
         }catch (Exception e){
             e.getLocalizedMessage();
         }
     }

     public String singleIteration(String sheetname, String parameter)
     {
         String data = null;
         if (this.equals(null))
         {
             setFilePath(filepath);
         }
         try{
             XSSFWorkbook workbook = new XSSFWorkbook(file);
             XSSFSheet sheet = workbook.getSheet(sheetname);
             Row   firstrow = sheet.getRow(0);
             int column = 0;

             for(int i = 0; i<firstrow.getLastCellNum(); i++)
             {
                 if(firstrow.getCell(i).getStringCellValue().equals(parameter))
                 {
                     column = i;
                 }
             }


             data = sheet.getRow(1).getCell(column).getStringCellValue();

         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         closeFile();
         setFilePath(filepath);
         return data;

     }

    public String multiIteration(String sheetname, String parameter, String testcase)
    {
        String data = null;
        if (this.equals(null))
        {
            setFilePath(filepath);
        }
        try{
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetname);
            Row   firstrow = sheet.getRow(0);
            int column = 0;
            int tcnumber = 0;

            for(int i = 0; i<firstrow.getLastCellNum(); i++)
            {
                if(firstrow.getCell(i).getStringCellValue().equals(parameter))
                {
                    column = i;
                }
                else if(firstrow.getCell(i).getStringCellValue().equals("TC_Name"))
                {
                    tcnumber = i;
                }
            }

            for(int i=1; i<sheet.getLastRowNum(); i++)
            {
                Row r = sheet.getRow(i);
                if(r.getCell(tcnumber).getStringCellValue().equals(testcase))
                {
                    data = r.getCell(column).getStringCellValue();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return data;

    }
}
