package com.university.FinanceAnalyzer;

import com.university.FinanceAnalyzer.dataReaders.TransactionCSVReader;
import com.university.FinanceAnalyzer.dataReaders.URLDataReader;
import com.university.FinanceAnalyzer.entities.Transaction;
import com.university.FinanceAnalyzer.service.TransactionAnalyzer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TransactionAnalyzerTest {
    @Test
    public void testCalculateTotalBalance() {
        Transaction transaction1 = new Transaction("2023-01-01", 100.0, "Дохід");
        Transaction transaction2 = new Transaction("2023-01-02", -50.0, "Витрата");
        Transaction transaction3 = new Transaction("2023-01-03", 150.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        double result = TransactionAnalyzer.calculateTotalBalance(transactions);

        Assertions.assertEquals(200.0, result, "Розрахунок загального балансу неправильний");
    }

    @Test
    public void testCountTransactionsByMonth() {
        Transaction transaction1 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        int countFeb = TransactionAnalyzer.countTransactionsByMonth("02-2023", transactions);
        int countMar = TransactionAnalyzer.countTransactionsByMonth("03-2023", transactions);

        Assertions.assertEquals(2, countFeb, "Кількість транзакцій за лютий неправильна");
        Assertions.assertEquals(1, countMar, "Кількість транзакцій за березень неправильна");
    }

    @Test
    public void testFindTopTenExpenses() {
        List<Transaction> expectedTopExpenses = new ArrayList<>();
        for (Transaction t : TestData.getTestTransactions()) {
            if(t.getAmount() < 0) {
                expectedTopExpenses.add(t);
            }
        }
        expectedTopExpenses.sort(Comparator.comparing(Transaction::getAmount));
        if(expectedTopExpenses.size() > 10) {
            expectedTopExpenses = expectedTopExpenses.subList(0, 10);
        }

        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> transactions = TransactionCSVReader.readAndProcessTransactions(new URLDataReader(), filePath);
        List<Transaction> topExpenses = TransactionAnalyzer.findTopTenExpenses(transactions);

        Assertions.assertEquals(expectedTopExpenses, topExpenses, "Список найбільших витрат неправильний");
    }
}
