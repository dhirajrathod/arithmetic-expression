package com.pegasus.arithmetic.expression.commons;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.BiFunction;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class EvaluateString {
	
    private static final Logger LOGGER = Logs.getAppLoggers();

    public static String evaluate(String expression) {
        String returnValue = StringUtils.EMPTY;
        try {
            List<String> list = Arrays.asList(expression.split(""));

            String[] previousToken = new String[1];
            previousToken[0] = "";
            Stack<Integer> values = new Stack<>();
            Stack<String> ops = new Stack<>();

            list.forEach(tokens -> {
                if (!StringUtils.equals(tokens, " ")) {
                    boolean isTokenNumeric = StringUtils.isNumeric(tokens);
                    if (isTokenNumeric) {
                        int valueNumber = Integer.parseInt(tokens);

                        int lastElementStack = 0;
                        if (values.size() > 0) {
                            lastElementStack = values.lastElement();
                        }
                        if (StringUtils.isNumeric(previousToken[0])) {
                            int elementId = values.search(lastElementStack);
                            if (elementId != -1) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(lastElementStack);
                                stringBuilder.append(valueNumber);
                                if (values.size() > 1) {
                                    values.set((elementId), Integer.parseInt(stringBuilder.toString()));
                                } else {
                                    values.set((elementId - 1), Integer.parseInt(stringBuilder.toString()));
                                }
                            }
                        } else {
                            values.push(valueNumber);
                        }
                    } else if (StringUtils.equals(tokens, "(")) {
                        ops.push(tokens);
                    } else if (StringUtils.equals(tokens, ")")) {
                        while (!StringUtils.equals(ops.peek(), "(")) {
                            values.push(applyOps(ops.pop(), values.pop(), values.pop()));
                        }
                        ops.pop();
                    } else if (StringUtils.equals(tokens, "+")
                            || StringUtils.equals(tokens, "-")
                            || StringUtils.equals(tokens, "*")
                            || StringUtils.equals(tokens, "/")) {
                        while (!ops.empty() && hasPrecedence(tokens, ops.peek())) {
                            values.push(applyOps(ops.pop(), values.pop(), values.pop()));
                        }
                        ops.push(tokens);
                    }
                    previousToken[0] = tokens;
                }
            });

            while (!ops.empty()) {
                values.push(applyOps(ops.pop(), values.pop(), values.pop()));
            }

            returnValue = String.valueOf(values.pop());
        } catch (Exception e) {LOGGER.error("Exception occurred in evaluate in EvaluateString : " + e.getMessage());
        }
        return returnValue;
    }

    public static boolean hasPrecedence(String op1, String op2) {
        if (StringUtils.equals(op2, "(") || StringUtils.equals(op2, ")")) {
            return false;
        } else {
            return !((StringUtils.equals(op1, "*") || StringUtils.equals(op1, "/"))
                    && (StringUtils.equals(op2, "+") || StringUtils.equals(op2, "-")));
        }
    }

    // Use of Java 8 InBuilt Functional Interface.
    public static int applyOps(String op, int b, int a) {
        switch (op) {
            case "+":
                BiFunction<Integer, Integer, Integer> functionAdd = (i1, i2) -> Math.addExact(i1, i2);
                return functionAdd.apply(a, b);
            case "-":
                BiFunction<Integer, Integer, Integer> functionSubtract = (i1, i2) -> Math.subtractExact(i1, i2);
                return functionSubtract.apply(a, b);
            case "*":
                BiFunction<Integer, Integer, Integer> functionMultiply = (i1, i2) -> Math.multiplyExact(i1, i2);
                return functionMultiply.apply(a, b);
            case "/":
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                } else {
                    BiFunction<Integer, Integer, Integer> functionDivide = (i1, i2) -> Math.floorDiv(i1, i2);
                    return functionDivide.apply(a, b);
                }
            default:
                return 0;
        }
    }
	
}