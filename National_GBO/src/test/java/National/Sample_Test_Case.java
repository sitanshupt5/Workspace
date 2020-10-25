package National;

import Utilities.BaseUitlities;

public class Sample_Test_Case extends BaseUitlities
{

    public static void main(String args[])
    {
        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();

    }
}
