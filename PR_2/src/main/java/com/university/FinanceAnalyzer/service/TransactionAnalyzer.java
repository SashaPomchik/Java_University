package com.university.FinanceAnalyzer.service;

import com.university.FinanceAnalyzer.entities.Transaction;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;


public abstract class TransactionAnalyzer {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    ;

    public static double calculateTotalBalance(List<Transaction> transactions) {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public static int countTransactionsByMonth(String monthYear, List<Transaction> transactions) {
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter);
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }

    public static List<Transaction> findTopTenExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static List<Transaction> findTopTenExpensesByMonth(String monthYear, List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0 && LocalDate.parse(t.getDate(), dateFormatter).format(DateTimeFormatter.ofPattern("MM-yyyy")).equals(monthYear))
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static List<Transaction> findLowestTenExpensesByMonth(String monthYear, List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0 && LocalDate.parse(t.getDate(), dateFormatter).format(DateTimeFormatter.ofPattern("MM-yyyy")).equals(monthYear))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    public static Map<String, Map<String, Double>> calculateTotalExpansesReport(List<Transaction> transactions) {
        Map<String, Map<String, Double>> expenses = new HashMap<>();

        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                String monthYear = LocalDate.parse(t.getDate(), dateFormatter).format(DateTimeFormatter.ofPattern("MM-yyyy"));
                String category = t.getDescription();

                expenses
                        .computeIfAbsent(monthYear, k -> new HashMap<>())
                        .merge(category, t.getAmount(), Double::sum);
            }
        }
        return expenses;
    }
}
