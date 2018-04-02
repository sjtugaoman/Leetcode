import java.util.*;

class basicCalculator {
    public static int calculate(String s) {
        int size = s.length(), result = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < size; i++) {
            if(Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while(i + 1 < size && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                result += sum * sign;
            } else if(s.charAt(i) == '+') {
                sign = 1;
            } else if(s.charAt(i) == '-') {
                sign = -1;
            } else if(s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if(s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "(1+(45+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}