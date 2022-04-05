package edu.kata;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello, dear user!");
        System.out.println("Welcome to \"The Calculator\". Here are some details to consider:");
        System.out.println("NOTE: 1. You can use EITHER Arabic numerals from 1 to 10 (inclusive), OR Roman numerals from I to X (inclusive). But never both at the same time;");
        System.out.println("\t  2. You can only use only Integers (no floats allowed);");
        System.out.println("Please, input numbers below as follows: a + b, a - b, a * b, a / b:");

        InputAndValidation.InputAndValidationInitialize();

        if (InputAndValidation.getIsRomanNumerals()) {
            String result = InputAndValidation.romanNumeralResult();
            System.out.println("The answer is: " + result);
        } else {
            int result = InputAndValidation.arabicNumeralsResult();
            System.out.println("The answer is: " + result);
        }
        System.out.println("Great attempt! You can try again.");
    }
}

