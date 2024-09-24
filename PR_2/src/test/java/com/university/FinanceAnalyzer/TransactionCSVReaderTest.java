package com.university.FinanceAnalyzer;

import com.university.FinanceAnalyzer.dataReaders.TransactionCSVReader;
import com.university.FinanceAnalyzer.dataReaders.URLDataReader;
import com.university.FinanceAnalyzer.entities.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class TransactionCSVReaderTest {
    @Test
    public void testReadingDataFromCSV () throws URISyntaxException {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> expectedTransactions = TestData.getTestTransactions();
        List<Transaction> result = TransactionCSVReader.readAndProcessTransactions(new URLDataReader(), filePath);

        Assertions.assertEquals(expectedTransactions, result, "Розрахунок загального балансу неправильний");
    }
}
