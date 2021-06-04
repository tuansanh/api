package com.seveneleven.utilities;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CsvHelper {

    
    public static <T> Object[][] fileTo2DArray(String filename, Class<T> clazz) {
        Path path = getPathToFile(filename);
        List<T> lists = convertCsvToObject(path, clazz);
        
        Object[][] data = new Object[lists.size()][1];
        for (int i = 0; i < lists.size(); i++) {
            data[i][0] = lists.get(i);
        }
        return data;
    }
    
    private static <T> List<T> convertCsvToObject(Path path, Class<T> clazz){
        List<T> lists = new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(path, UTF_8)){
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(br)
                    .withType(clazz)
                    .build();
            lists = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lists;
    }

    private static Path getPathToFile(String filename) {
        File file = new File("src/test/resources/testdata/promotion/single/" + filename);
        return Paths.get(file.getAbsolutePath());
    }
}
