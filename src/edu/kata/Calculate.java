package edu.kata;

public class Calculate {

    public static int Result() {

        int number1 = InputAndValidation.getNum1();
        int number2 = InputAndValidation.getNum2();
        String operator =InputAndValidation.getOperator();

        return switch (operator) {
            case ("+") -> Calculate.addition(number1, number2);
            case ("-") -> Calculate.subtraction(number1, number2);
            case ("*") -> Calculate.multiplication(number1, number2);
            case ("/") -> Calculate.division(number1, number2);
            default -> 0;
        };
    }

    public static int addition(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtraction(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    public static int division(int num1, int num2) {
        try {
            if (num1 % num2 == 1 ) {
                throw new InvalidInputException();
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return num1 / num2;
    }
}


