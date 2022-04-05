package edu.kata;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputAndValidation {

    private static int num1;
    private static int num2;
    private static String operator;

    private static boolean isRomanNumerals;

    public static void InputAndValidationInitialize() throws Exception {

        //инициализируем массивы для дальнейшей валидации
        String[] arabicNumerals = new String[]{"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romanNumerals = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] operators = new String[]{"+", "-", "*", "/"};

        // Вносим данные в консоль используя BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Читаем данные с помощью readLine
        String name = reader.readLine();

        // Разбиваем полученные данные в массив (разделитель - пробел)
        String[] array = name.split("\\s");

        // Проверяем какой длины получился массив (по условию вводятся три символа
        try {
            if (array.length != 3) {
                throw new InvalidInputException();
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        // Проверяем корректность ввода арифметического оператора
        boolean isOperatorValid = Arrays.asList(operators).contains(array[1]);
        try {
            if (isOperatorValid) {
                operator = array[1];
            } else {
                throw new InvalidInputException();
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        // Проверяем, чтобы введенные числа были либо ОБА арабскими либо ОБА римскими
        boolean isArabicNumerals = Arrays.asList(arabicNumerals).contains(array[0]) && Arrays.asList(arabicNumerals).contains(array[2]);
        isRomanNumerals = Arrays.asList(romanNumerals).contains(array[0]) && Arrays.asList(romanNumerals).contains(array[2]);
        try {
            if (isArabicNumerals) {
                num1 = Integer.parseInt(array[0]);
                num2 = Integer.parseInt(array[2]);
            } else if (isRomanNumerals) {
                String tmp1 = array[0];
                String tmp2 = array[2];
                num1 = Arrays.asList(romanNumerals).indexOf(tmp1);
                num2 = Arrays.asList(romanNumerals).indexOf(tmp2);
            } else {
                throw new InvalidNumberException();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public static int arabicNumeralsResult() {
        return Calculate.Result();
    }

    public static String romanNumeralResult() {
        try {
            if (isRomanNumerals && Calculate.Result() < 1) {
                throw new Exception();
            } else {
                ArabicToRomanResult.Convert();
                return ArabicToRomanResult.getRomanNumeralsResult();
            }
        } catch (Exception e) {
            System.out.println("Value of Roman numeral must be positive. Try again.");
            System.exit(0);
        }
        return null;
    }

    public static int getNum1 () {
        return num1;
    }

    public static String getOperator () {
        return operator;
    }

    public static int getNum2 () {
        return num2;
    }

    public static boolean getIsRomanNumerals () {
        return isRomanNumerals;
    }
}

