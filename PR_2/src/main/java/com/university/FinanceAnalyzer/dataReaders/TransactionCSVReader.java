package com.university.FinanceAnalyzer.dataReaders;

import com.university.FinanceAnalyzer.entities.Transaction;
import com.university.FinanceAnalyzer.service.TransactionProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class TransactionCSVReader {
    public static List<Transaction> readAndProcessTransactions(DataReader dataReader, String source) {
        try {
            List<String> lines = dataReader.readLines(source);
            return TransactionProcessor.processTransaction(lines);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
