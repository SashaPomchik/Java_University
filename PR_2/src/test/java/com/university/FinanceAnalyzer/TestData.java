package com.university.FinanceAnalyzer;

import com.university.FinanceAnalyzer.entities.Transaction;

import java.util.Arrays;
import java.util.List;

public class TestData {
    public static List<Transaction> getTestTransactions() {
        return Arrays.asList(
                new Transaction("05-12-2023", -7850.0, "Сільпо"),
                new Transaction("07-12-2023", -1200.0, "Аптека"),
                new Transaction("10-12-2023", 80000.0, "Зарплата"),
                new Transaction("12-12-2023", 1500.0, "Авторські винагороди"),
                new Transaction("14-12-2023", -3200.0, "Комунальні послуги"),
                new Transaction("16-12-2023", 25000.0, "Фріланс"),
                new Transaction("18-12-2023", -600.0, "Кав'ярня"),
                new Transaction("20-12-2023", -7500.0, "Подарунки"),
                new Transaction("22-12-2023", -6000.0, "Бензин"),
                new Transaction("24-12-2023", -1950.0, "Ресторан"),
                new Transaction("26-12-2023", 3000.0, "Премія"),
                new Transaction("28-12-2023", -1900.0, "Кінотеатр"),
                new Transaction("30-12-2023", -3200.0, "Новорічні прикраси"),
                new Transaction("05-01-2024", -4500.0, "Сільпо"),
                new Transaction("07-01-2024", -2000.0, "Аптека"),
                new Transaction("10-01-2024", 85000.0, "Зарплата"),
                new Transaction("12-01-2024", 1600.0, "Авторські винагороди"),
                new Transaction("14-01-2024", -3300.0, "Комунальні послуги"),
                new Transaction("16-01-2024", 26000.0, "Фріланс"),
                new Transaction("18-01-2024", -750.0, "Кав'ярня"),
                new Transaction("20-01-2024", -8800.0, "Подарунки"),
                new Transaction("22-01-2024", -5500.0, "Бензин"),
                new Transaction("24-01-2024", -3000.0, "Ресторан"),
                new Transaction("26-01-2024", 3100.0, "Премія"),
                new Transaction("28-01-2024", -1850.0, "Кінотеатр"),
                new Transaction("30-01-2024", -9100.0, "Інші витрати")
        );
    }
}
