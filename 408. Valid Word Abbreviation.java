class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            char abbCh = abbr.charAt(j);
            if (Character.isLetter(abbCh)) {
                if (abbCh == word.charAt(i)) {
                    i++;
                    j++;
                    continue;
                } else {
                    return false;
                }
            } else {
                if (abbCh == '0')
                    return false;
                StringBuilder sb = new StringBuilder();
                sb.append(abbCh);
                j++;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    sb.append(abbr.charAt(j));
                    j++;
                }
                int num = Integer.parseInt(sb.toString());
                i += num;
            }
        }
        if (i == word.length() && j == abbr.length()) {
            return true;
        } else {
            return false;
        }
    }
}
