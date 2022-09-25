class Solution {
    
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<Character>();
        for (char c: s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(')
                stack.push(c);
            else if (c == '}') {
                if (stack.empty() || (!stack.empty() && stack.pop() != '{'))
                    return false;
            } else if (c == ']') {
                if (stack.empty() || (!stack.empty() && stack.pop() != '['))
                    return false;
            } else if (c == ')') {
                if (stack.empty() || (!stack.empty() && stack.pop() != '('))
                    return false;
            } else
                return false;
        }
        return stack.empty();
    }
    
}
