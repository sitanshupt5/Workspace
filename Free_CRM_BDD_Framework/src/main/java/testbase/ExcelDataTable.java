package testbase;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.Transformer;
import cucumber.runtime.ParameterInfo;
import cucumber.runtime.table.TableConverter;
import cucumber.runtime.xstream.LocalizedXStreams;
import gherkin.formatter.model.Comment;
import gherkin.formatter.model.DataTableRow;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ExcelDataTable extends Transformer<DataTable> {

    ExcelReader reader;

    public void setExcelReader()


    public DataTable transform(String filepath) {
        reader = new ExcelReader.ExcelReaderBuilder().setFileLocation(filepath).setSheet().build();
        List<List<String>> exceldata = reader.getSheetData(sheet);

        List<DataTableRow> tablerows = new ArrayList<DataTableRow>();
        int line = 1;

        for(List<String> list: exceldata)
        {
            Comment comment = new Comment("", line);
            DataTableRow row = new DataTableRow(Arrays.asList(comment), list, line);
            tablerows.add(row);
        }

        ParameterInfo parameterInfo = new ParameterInfo(null, null, null, null);
        TableConverter tableConverter = new TableConverter(new LocalizedXStreams(Thread.currentThread().getContextClassLoader()).get(Locale.getDefault()), parameterInfo);

        DataTable table = new DataTable(tablerows, tableConverter);
        return table;
    }
}
