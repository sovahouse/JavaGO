import java.util.Deque;
import java.util.LinkedList;

public class ReversePolishNotation {

    public int evaluate(String expression) {

        Deque<Integer> expressionStack = new LinkedList<>();
        StringBuilder num = new StringBuilder();
        boolean isNumberGet = false;
        int currentNumber = 0;
        int firstOperand = 0;
        int secondOperand = 0;

        if (expression.length() == 1) {
            return Integer.parseInt(expression);
        }

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {

                num.append(ch);
                isNumberGet = true;
                continue;

            }
            if (isNumberGet) {

                currentNumber = parseToInt(num);
                expressionStack.add(currentNumber);
                num.delete(0, num.length());
                isNumberGet = false;

            }




            switch (ch) {

                case '+':
                    firstOperand= expressionStack.pop();
                    secondOperand = expressionStack.pop();
                    expressionStack.clear();
                    expressionStack.add(firstOperand + secondOperand);
                    break;

                case '-':
                    firstOperand= expressionStack.pop();
                    secondOperand = expressionStack.pop();
                    expressionStack.clear();
                    expressionStack.add(firstOperand - secondOperand);
                    break;

                case '*':
                    firstOperand= expressionStack.pop();
                    secondOperand = expressionStack.pop();
                    expressionStack.clear();
                    expressionStack.add(firstOperand * secondOperand);
                    break;

                case '/':
                    firstOperand= expressionStack.pop();
                    secondOperand = expressionStack.pop();
                    expressionStack.clear();
                    expressionStack.add(firstOperand / secondOperand);
                    break;

                default:
                    break;
            }

        }

        return expressionStack.getLast();
    }
    private int parseToInt(StringBuilder s) {

        int result = 0;

        for (int i = s.length() - 1, j = 1; i >= 0; i--, j *= 10) {

            result += Character.getNumericValue(s.charAt(i)) * j;

        }

        return result;
    }
}