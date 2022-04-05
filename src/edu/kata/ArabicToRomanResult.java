package edu.kata;

public class ArabicToRomanResult {

    private static String romanNumeralsResult;

    public static void Convert() {
        // создаем массив римских чисел (по условиям ТЗ - рузультат никогда не будет больше 100)
        String[] romanNumerals = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "L", "C"};

        int result = Calculate.Result();
        String tmp = "";
        int tens = result / 10;
        int units = result % 10;

        // конвертируем результат из арабского числа в римское
        if (tens == 0) {
            romanNumeralsResult = romanNumerals[units];
        } else if (tens > 0 && tens < 4) {
            for (int i = 0; i < tens; i++) {
                tmp = tmp + romanNumerals[10];
            }
            romanNumeralsResult = tmp + romanNumerals[units];
        } else if (tens == 4) {
            romanNumeralsResult = romanNumerals[10] + romanNumerals[11] + romanNumerals[units];
        } else if (tens > 4 && tens < 9) {
            for (int i = 0; i < (tens-5); i++) {
                tmp = tmp + romanNumerals[10];
            }
            romanNumeralsResult = romanNumerals[11] + tmp + romanNumerals[units];
        } else if (tens == 9) {
            romanNumeralsResult = romanNumerals[10] + romanNumerals[12] +romanNumerals[units];
        } else if (tens == 10) {
            romanNumeralsResult = romanNumerals[12];
        }
        setRomanNumeralsResult(romanNumeralsResult);
    }

    public static void setRomanNumeralsResult(String romanNumeralsResult) {
        ArabicToRomanResult.romanNumeralsResult = romanNumeralsResult;
    }

    public static String getRomanNumeralsResult() {
        return romanNumeralsResult;
    }
}
