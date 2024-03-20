class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == ')') {
                List<Character> tmpList = new ArrayList<>();
                while (stack.peek() != '(') {
                    tmpList.add(stack.pop());
                }
                //remove '('
                stack.pop();
                for (int i = 0; i < tmpList.size(); i++) {
                    stack.push(tmpList.get(i));
                }
            } else {
                stack.push(ch);
            }
        }
        //reverse stack content and return
        StringBuilder sb = new StringBuilder();
        //iterating over stack in below manner gives FIFO result instead of LIFO
        for (char ch: stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
