package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "Data")
    public String[][] getALLData() {
        String path = System.getProperty("user.dir") + "//testData//testdata.xlsx";
        NALExcelXLSReader xl = new NALExcelXLSReader(path);
        int rownum = xl.getRowCount("register");
        int colcount = xl.getColumnCount("register");
        String[][] apidata = new String[rownum][colcount];
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                apidata[i - 1][j] = xl.getCellData("register", i, j);
            }
        }

        return apidata;
    }

    @DataProvider(name = "Usernames")
    public String[] getUsernames() {
        String path = System.getProperty("user.dir") + "//testData//testdata.xlsx";
        NALExcelXLSReader xl = new NALExcelXLSReader(path);
        int rownum = xl.getRowCount("register");
        String[] apidata = new String[rownum];
        for (int i = 1; i <= rownum; i++) {
            apidata[i - 1] = xl.getCellData("register", i, 1);
        }
        return apidata;
    }
}
