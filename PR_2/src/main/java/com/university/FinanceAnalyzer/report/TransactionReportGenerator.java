package com.university.FinanceAnalyzer.report;

import com.university.FinanceAnalyzer.entities.Transaction;
import com.university.FinanceAnalyzer.service.TransactionAnalyzer;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TransactionReportGenerator {
    private static final Double SYMBOL_VALUE = 1000.0;
    private static final String SYMBOL_BY_VALUE = "*";
    private static final String NEW_LINE = "\n";

    public static void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public static void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public static void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("10 найбільших витрат:");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public static void printTopAndLowestExpensesByMonthReport(String monthYear, List<Transaction> topExpenses, List<Transaction> lowestExpenses) {
        System.out.println("10 найбільших витрат за " + monthYear + ": ");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
        System.out.println();

        System.out.println("10 найменших витрат за " + monthYear + ": ");
        for (Transaction expense : lowestExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public static void printTotalExpansesReportByMonthAndByCategory(List<Transaction> transactions) {
        Map<String, Map<String, Double>> expenses = TransactionAnalyzer.calculateTotalExpansesReport(transactions);
        StringBuilder report = new StringBuilder();

        for (String month : expenses.keySet()){
            report.append("Витрати за ").append(month).append(":").append(NEW_LINE);
            for (Map.Entry<String, Double> entry : expenses.get(month).entrySet()) {
                String category = entry.getKey();
                Double amount = entry.getValue();
                int countSymbols = amount > -1000 ? 1 : (int) Math.round(Math.abs((amount / SYMBOL_VALUE)));
                report
                        .append(category).append(": ").append(SYMBOL_BY_VALUE.repeat(countSymbols))
                        .append(" (Сума: ").append(amount).append(" грн)").append(NEW_LINE);
            }
            report.append(NEW_LINE);
        }
        System.out.println(report);
    }
}
