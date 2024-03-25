class Solution {
    public String reverseParentheses(String s) {
        //we can do this in O(n) as well
        //first use a stack<int> to generate a pairs[] array
        //this pairs[] will keep track of corresponding matching brackets
        //above will take O(n) to generate
        //now we will again iterate the input, with iterable i=0 and i=i+d, initally d=1
        //whenever we encounter any bracket, we will move to its pair index, and reverse d
        //whenever we encounter any other char, we simply push it to result
        //this way we have our result in O(n) total!

        Stack<Integer> stack = new Stack<>();
        int[] pairs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int matching = stack.pop();
                pairs[i] = matching;
                pairs[matching] = i;
            }
        }

        int i = 0;
        int d = 1;
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < s.length(); i = i + d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pairs[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
