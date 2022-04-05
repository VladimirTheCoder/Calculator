package edu.kata;

public class InvalidInputException extends Exception {

    public InvalidInputException() {
        super("ERROR: Invalid input format. Try again.");
    }
}
