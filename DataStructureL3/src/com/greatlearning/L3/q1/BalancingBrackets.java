package com.greatlearning.L3.q1;
import java.util.Stack;

public class BalancingBrackets {

	public static boolean areBracketsBalanced(String expression) {
        if (expression == null || expression.isEmpty()) {
            return true; 
        }

        Stack<Character> stack = new Stack<>();

        for (char character : expression.toCharArray()) {
            // Pushing opening brackets onto the stack
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } 
            // Handle closing brackets
            else if (character == ')' || character == ']' || character == '}') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing bracket
                }

                char top = stack.pop();
                if (!isMatchingPair(top, character)) {
                    return false; // Mismatched pair
                }
            }
        }

        // If the stack is empty, all brackets are balanced
        return stack.isEmpty();
    }

    //  function to check if a pair of brackets match
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    // Driver code
    public static void main(String[] args) {
        String bracketExpression = "([[{()}]])";

        if (areBracketsBalanced(bracketExpression)) {
            System.out.println("The entered string has Balanced Brackets");
        } else {
            System.out.println("The entered string does not contain Balanced Brackets");
        }
    }

}
