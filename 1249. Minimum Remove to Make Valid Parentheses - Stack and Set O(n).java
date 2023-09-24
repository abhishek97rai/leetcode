class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    int index = stack.peek();
                    char peeked = s.charAt(index);
                    if (peeked == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        Set<Integer> set = new HashSet<>(stack);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
