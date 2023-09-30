public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String st: strs) {
            sb.append(st);
            sb.append("₹");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] res = s.split("₹",-1);
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < res.length-1; i++) {
            resList.add(res[i]);
        }
        return resList;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
