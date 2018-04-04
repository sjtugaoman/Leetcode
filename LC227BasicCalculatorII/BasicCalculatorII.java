import java.util.Stack;

class BasicCalculatorII {
    public static int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            //when it is digit
            if(Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            //when it is not digit
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if(sign == '+') {
                    stack.push(num);
                } else if(sign == '-') {
                    stack.push(-num);
                } else if(sign == '*') {
                    stack.push(stack.pop() * num);
                } else if(sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int result = 0;
        for(int i: stack) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "5  + 3-2  * 3/3 + 1";
        System.out.println(calculate(s));
    }
}