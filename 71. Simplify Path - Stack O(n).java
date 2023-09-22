class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> st = new Stack<>();
        for (String s: parts) {
            if (s.equals(".") || s.isEmpty())
                continue;
            if (s.equals("..")) {
                if (!st.isEmpty())
                    st.pop();
            } else {
                st.push(s);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s: st) {
            sb.append("/");
            sb.append(s);
        }
        if (sb.length() > 0)
            return sb.toString();
        else
            return "/";
    }
}
