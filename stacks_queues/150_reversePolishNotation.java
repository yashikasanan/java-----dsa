import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens){
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int n2 = stack.pop();       
                int n1 = stack.pop();
                int res=0;
                if (str.equals("+")){
                    res = n1+n2;
                }
                else if (str.equals("-")){
                    res = n1-n2;
                }
                else if (str.equals("*")){
                    res = n1*n2;
                }
                else {
                    res = n1/n2;
                }
                stack.push(res);
            }
            else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
