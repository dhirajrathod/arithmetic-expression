package com.pegasus.arithmetic.expression.commons;

import java.util.Stack;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class EvaluateString {
	
    private static final Logger LOGGER = Logs.getAppLoggers();

    public static String evaluate(String expression) {
        String returnValue = StringUtils.EMPTY;
        try {

            char[] tokens = expression.toCharArray();

            Stack<Integer> values = new Stack<>();
            Stack<Character> ops = new Stack<>();

            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i] == ' ') {
                    continue;
                }

                if (tokens[i] >= '0' && tokens[i] <= '9') {
                    StringBuilder sbuf = new StringBuilder();
                    sbuf.append(tokens[i]);
                    values.push(Integer.parseInt(sbuf.toString()));
                } else if (tokens[i] == '(') {
                    ops.push(tokens[i]);
                } else if (tokens[i] == ')') {
                    while (ops.peek() != '(') {
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    }
                    ops.pop();
                } else if (tokens[i] == '+' || tokens[i] == '-'
                        || tokens[i] == '*' || tokens[i] == '/') {
                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    }
                    ops.push(tokens[i]);
                }
            }

            while (!ops.empty()) {
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));
            }

            returnValue = String.valueOf(values.pop());
        } catch (Exception e) {
			LOGGER.error("Exception occurred in evaluate in EvaluateString : " + e.getMessage());
        }
        return returnValue;
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return !((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'));
    }

    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(EvaluateString.evaluate("qqqq"));
        System.out.println("--------------");
        System.out.println(EvaluateString.evaluate("(2+4)*4"));
        System.out.println("--------------");
        System.out.println(EvaluateString.evaluate("( 2 + 4 ) * 4"));
    }
}
