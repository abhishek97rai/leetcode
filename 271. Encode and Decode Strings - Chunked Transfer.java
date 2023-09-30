public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String st: strs) {
            int len = st.length();
            sb.append(len);
            sb.append("#");
            sb.append(st);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int stLen = 0;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            stLen = 0;
            while (i < s.length() && ch != '#') {
                stLen = stLen*10 + (ch-'0');
                i++;
                ch = s.charAt(i);
            }
            i++;
            String word = s.substring(i, i + stLen);
            res.add(word);
            i += stLen;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
