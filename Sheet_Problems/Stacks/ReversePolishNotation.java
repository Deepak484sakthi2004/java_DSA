package Sheet_Problems.Stacks;

import java.util.Stack;

public class ReversePolishNotation {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> st = new Stack<>();

            for (String token : tokens) {
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    int operand2 = st.pop();
                    int operand1 = st.pop();
                    int result = 0;

                    switch (token) {
                        case "+":
                            result = operand1 + operand2;
                            break;
                        case "-":
                            result = operand1 - operand2;
                            break;
                        case "*":
                            result = operand1 * operand2;
                            break;
                        case "/":
                            result = operand1 / operand2;
                            break;
                    }

                    st.push(result);
                } else {
                    int operand = Integer.parseInt(token);
                    st.push(operand);
                }
            }

            return st.pop();
        }
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        Solution solution = rpn.new Solution();
        int result = solution.evalRPN(new String[]{"2", "3", "+"});
        System.out.println(result);
    }
}
