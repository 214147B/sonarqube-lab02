package main.java.com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {
        if (op == null) {
            return 0;
        }

        switch (op) {
            case "add":
                return a + b;
            case "sub":
                return a - b;
            case "mul":
                return a * b;
            case "div":
                if (b == 0) {
                    return 0;
                }
                return a / b;
            case "mod":
                if (b == 0) {
                    return 0;
                }
                return a % b;
            default:
                return 0;
        }
    }

    public int addNumbers(int x, int y) {
        return x + y;
    }
}