package edu.kata;

public class InvalidNumberException extends Exception {

    public InvalidNumberException() {
        super("ERROR: You can use EITHER Arabic numerals from 1 to 10 (inclusive), OR Roman numerals from I to X (inclusive). Try again.");
    }
}
