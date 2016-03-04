import java.util.Deque;
import java.util.LinkedList;

public class ReversePolishNotation {

    public int evaluate(String expression) {

        Deque<Integer> expressionStack = new LinkedList<>();
        StringBuilder num = new StringBuilder();
        boolean isNumberGet = false;
        int currentNumber;
        int firstOperand;
        int secondOperand;

        if (expression.length() == 1) {
            return Integer.parseInt(expression);
        }

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            while (Character.isDigit(expression.charAt(i))) {

                ch = expression.charAt(i);
                num.append(ch);
                isNumberGet = true;
                i++;

            }

            if (isNumberGet) {

                currentNumber = Integer.parseInt(num.toString());
                expressionStack.addFirst(currentNumber);
                num.delete(0, num.length());
                isNumberGet = false;

            }




            switch (ch) {

                case '+':
                    secondOperand = expressionStack.pop();
                    firstOperand= expressionStack.pop();
                    expressionStack.addFirst(firstOperand + secondOperand);
                    break;

                case '-':
                    secondOperand = expressionStack.pop();
                    firstOperand= expressionStack.pop();
                    expressionStack.addFirst(firstOperand - secondOperand);
                    break;

                case '*':
                    secondOperand = expressionStack.pop();
                    firstOperand= expressionStack.pop();
                    expressionStack.addFirst(firstOperand * secondOperand);
                    break;

                case '/':
                    secondOperand = expressionStack.pop();
                    firstOperand= expressionStack.pop();
                    expressionStack.addFirst(firstOperand / secondOperand);
                    break;

                default:
                    break;
            }

        }

        return expressionStack.getLast();
    }
}