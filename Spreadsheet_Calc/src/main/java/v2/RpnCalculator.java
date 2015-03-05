package v2;

import java.util.*;

public class RpnCalculator {


    private static Set<String> operators = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));

    public static double calculate(List<String> tokens){

        Stack<String> stack = new Stack<String>();

        for (String token: tokens) {
            try {
                Double.parseDouble(token);
                stack.push(token);
            }
            catch (NumberFormatException e) {
                if (operators.contains(token)) {
                    if (stack.size() < 2)
                        throw new IllegalArgumentException(String.format("Too few arguments for '%s'", token));
                    double val2 = Double.parseDouble(stack.pop());
                    double val1 = Double.parseDouble(stack.pop());
                    if (token.equals("+"))
                        stack.push(String.valueOf(val1+val2));
                    if (token.equals("-"))
                        stack.push(String.valueOf(val1-val2));
                    if (token.equals("*"))
                        stack.push(String.valueOf(val1*val2));
                    if (token.equals("/")) {
                        if (val2 == 0)
                            throw new IllegalArgumentException("Division by zero");
                        stack.push(String.valueOf(val1/val2));
                    }

                }
                else throw new IllegalArgumentException("Unknown operator: " + token);
            }
        }

        if (stack.size() != 1)
            throw new IllegalArgumentException("Too many values in input");

        return Double.parseDouble(stack.pop());
    }

}
