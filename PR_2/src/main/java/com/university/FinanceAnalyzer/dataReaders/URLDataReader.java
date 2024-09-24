package com.university.FinanceAnalyzer.dataReaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLDataReader extends DataReader {
    @Override
    public BufferedReader readData(String source) throws IOException {
        URL url = new URL(source);
        return new BufferedReader(new InputStreamReader(url.openStream()));
    }
}
