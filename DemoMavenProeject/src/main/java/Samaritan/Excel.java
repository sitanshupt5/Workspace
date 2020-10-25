package Samaritan;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Excel {

    public ArrayList<String> getData(String filepath, String sheetname, String columnname, String testcase ) throws IOException
    {
        ArrayList<String> a = new ArrayList<String>();
        FileInputStream file = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        int sheetcount = workbook.getNumberOfSheets();
        for(int i= 0; i<sheetcount; i++)
        {
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetname))
            {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                Iterator<Cell> cell = firstrow.cellIterator();
                int k=0;
                int column = 0;
                int paracolumn = 0;
                while(cell.hasNext())
                {
                    Cell value = cell.next();
                    if(value.getStringCellValue().equalsIgnoreCase("Test_Case"))
                    {
                        column = k;
                    }
                    else if (value.getStringCellValue().equalsIgnoreCase(columnname))
                    {
                        paracolumn = k;
                    }
                    k++;
                }
                System.out.println(column);
                System.out.println(paracolumn);
                while(rows.hasNext())
                {
                    Row r = rows.next();
                    if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcase))
                    {
                        Iterator<Cell> c = r.cellIterator();
                        while(c.hasNext())
                        {
                            Cell ce = c.next();
                            if(ce.getColumnIndex() == paracolumn)
                            {
                                if(ce.getCellType() == CellType.STRING)
                                {
                                    a.add(ce.getStringCellValue());
                                }
                                else
                                {
                                    a.add(NumberToTextConverter.toText(ce.getNumericCellValue()));
                                }
                            }
                        }
                    }
                }
            }
        }
        return a;
    }
}
