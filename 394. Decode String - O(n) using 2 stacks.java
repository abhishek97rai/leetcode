class Solution {
    public String decodeString(String s) {
        int index = 0;
        StringBuilder res = new StringBuilder("");
        Stack<Integer> countSt = new Stack<>();
        Stack<String> resultSt = new Stack<>();
        while (index < s.length()) {
            int count = 0;
            if (Character.isDigit(s.charAt(index))) {
                //calculate actual numerical value using some formula while traversing once only
                while (Character.isDigit(s.charAt(index))) {
                    count = count*10 + s.charAt(index)-'0';
                    index++;
                }
                countSt.push(count);                
            } else if (s.charAt(index) == '[') {
                resultSt.push(res.toString());
                res = new StringBuilder("");
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(resultSt.pop());
                int repeat = countSt.pop();
                for (int i = 0; i < repeat; i++)
                    temp.append(res);
                res = temp;
                index++;
            } else {
                //normal character like a,b,c,etc
                res.append(s.charAt(index));
                index++;
            }
        }
        return res.toString();
    }
}
