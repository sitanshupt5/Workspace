package Samaritan;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class ChandanTest {

    @Test
    public void getdata() throws IOException
    {
        Excel e = new Excel();
        String filepath = "C:\\Users\\BlackGhost\\Desktop\\DataFile.xlsx";
        ArrayList<String> data = e.getData(filepath, "Test_Data", "Data2", "Sitanshu");
        String x = (data.get(0));
        System.out.println(x);
    }
}
