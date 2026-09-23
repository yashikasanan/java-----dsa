import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            // push every opening bracket.
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }
                // for closing bracket, check the top of the stack.
                char top = stack.pop();
                if ( ch == ')' && top != '(') {
                    return false;
                }
                if ( ch == ']' && top != '[') {
                    return false;
                }
                if ( ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        // valid only when no opening bracket exist.
        return stack.isEmpty();
    }
}
