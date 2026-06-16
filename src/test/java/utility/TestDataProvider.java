package utility;

import org.testng.annotations.DataProvider;

import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "productData")
    public Object[][] getProductData()
    {
        List<String[]> csvData =
                CSVReader.getData(
                        "src/test/resources/testdata.csv"
                );

        Object[][] data =
                new Object[csvData.size()][];

        for(int i = 0; i < csvData.size(); i++)
        {
            data[i] = csvData.get(i);
        }

        return data;
    }
}