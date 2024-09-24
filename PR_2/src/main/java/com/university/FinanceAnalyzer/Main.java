package com.university.FinanceAnalyzer;

import com.university.FinanceAnalyzer.dataReaders.DataReader;
import com.university.FinanceAnalyzer.dataReaders.TransactionCSVReader;
import com.university.FinanceAnalyzer.dataReaders.URLDataReader;
import com.university.FinanceAnalyzer.entities.Transaction;
import com.university.FinanceAnalyzer.report.TransactionReportGenerator;
import com.university.FinanceAnalyzer.service.TransactionAnalyzer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataReader dataReader = new URLDataReader();
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> transactions = TransactionCSVReader.readAndProcessTransactions(dataReader, filePath);

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(totalBalance);
        System.out.println();

        String monthYear = "01-2024";
        int transactionsCount = TransactionAnalyzer.countTransactionsByMonth(monthYear, transactions);
        TransactionReportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);
        System.out.println();

        List<Transaction> topExpenses = TransactionAnalyzer.findTopTenExpenses(transactions);
        TransactionReportGenerator.printTopExpensesReport(topExpenses);
        System.out.println();

        monthYear = "12-2023";
        List<Transaction> topExpensesByMonth = TransactionAnalyzer.findTopTenExpensesByMonth(monthYear,transactions);
        List<Transaction> lowestExpensesByMonth = TransactionAnalyzer.findLowestTenExpensesByMonth(monthYear, transactions);
        TransactionReportGenerator.printTopAndLowestExpensesByMonthReport(monthYear, topExpensesByMonth, lowestExpensesByMonth);
        System.out.println();

        TransactionReportGenerator.printTotalExpansesReportByMonthAndByCategory(transactions);
    }
}
