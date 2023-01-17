package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps {
    public static List<String> readCSV(String csvFile) throws IOException {
        List<String> lines = null;
        File file = new File(csvFile);
        lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        return lines;
    }

    public static Object[][] getDataFromCSV(String filePath) throws IOException {
        Object[][] data = new Object[3][2];
        List<String> csvData = readCSV(filePath);
        for (int i = 0; i < csvData.size(); i++) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
        }
        return data;
    }

    @DataProvider(name = "data-provider-searches")
    public Object[][] getDataObject() throws IOException {
        return getDataFromCSV(getData("DDTFile"));
    }
}
