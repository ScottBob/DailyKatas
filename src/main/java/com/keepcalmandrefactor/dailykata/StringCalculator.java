package com.keepcalmandrefactor.dailykata;

import java.util.ArrayList;

public class StringCalculator {
    private String cr = System.lineSeparator();

    public int add(String delimitedString) {
        if (delimitedString.isEmpty()) {
            return 0;
        }

        if (delimitedString.contains(",") || delimitedString.contains(cr)) {
            return splitStringAndSum(delimitedString);
        }

        if (delimitedString.startsWith("-")) {
            throw new NumberFormatException("negatives not allowed: " + delimitedString);
        }
        return Integer.parseInt(delimitedString);
    }

    private int splitStringAndSum(String delimitedString) {
        String errNums = "";
        String comma = "";
        ArrayList<String> numbers = new ArrayList<>();
        String[] numberArray = delimitedString.split(",");
        for (String num : numberArray) {
            if (num.contains(cr)) {
                String[] crNumArray = num.split(cr);
                for (String crNum : crNumArray) {
                    if (crNum.startsWith("-")) {
                        errNums += comma + crNum;
                        comma = ",";
                    } else {
                        numbers.add(crNum);
                    }
                }
            } else {
                if (num.startsWith("-")) {
                    errNums += comma + num;
                    comma = ",";
                } else {
                    numbers.add(num);
                }
            }
        }

        if (!errNums.isEmpty()) {
            throw new NumberFormatException("negatives not allowed: " + errNums);
        }
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
