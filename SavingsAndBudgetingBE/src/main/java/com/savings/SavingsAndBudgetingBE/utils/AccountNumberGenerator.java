package com.savings.SavingsAndBudgetingBE.utils;

import java.time.Instant;
import java.util.Random;

public class AccountNumberGenerator {
    public static String generateAccountNumber(String accType) {
        long timestamp = Instant.now().toEpochMilli();
        int randomSuffix = new Random().nextInt(9000) + 1000; // 4-digit random number
        return accType + timestamp + randomSuffix;
    }
}
