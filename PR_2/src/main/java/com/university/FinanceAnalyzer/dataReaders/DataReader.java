package com.university.FinanceAnalyzer.dataReaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class DataReader {
    public abstract BufferedReader readData(String source) throws IOException;

    public List<String> readLines(String source) throws IOException {
        try(BufferedReader br = readData(source)) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        }
    }
}
