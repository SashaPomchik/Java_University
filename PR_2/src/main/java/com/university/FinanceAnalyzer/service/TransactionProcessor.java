package com.university.FinanceAnalyzer.service;

import com.university.FinanceAnalyzer.entities.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class TransactionProcessor {
    public static List<Transaction> processTransaction(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();

        for (String line : lines) {
            String[] values = line.split(",");
            Transaction transaction = new Transaction(values[0], Double.parseDouble(values[1]), values[2]);
            transactions.add(transaction);
        }
        return transactions;
    }
}
