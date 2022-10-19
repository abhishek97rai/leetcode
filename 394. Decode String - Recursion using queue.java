class Solution {
    public String decodeString(String s) {
        Deque<Character> dq = new LinkedList<>();
        for (char c: s.toCharArray())
            dq.offer(c);
        return getResult(dq);
    }
    
    public String getResult(Deque<Character> dq) {
        StringBuilder res = new StringBuilder("");
        int count = 0;
        while (!dq.isEmpty()) {
            char c = dq.poll();
            if (Character.isDigit(c)) {
                count = count*10 + c-'0';
            } else if (c == '[') {
                String sub = getResult(dq);
                for (int i = 0; i < count; i++)
                    res.append(sub);
                count = 0;
            } else if (c == ']') {
                break;
            } else {
                //normal character like a,b,c,etc
                res.append(c);
            }
        }
        return res.toString();        
    }
}
