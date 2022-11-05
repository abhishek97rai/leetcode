class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email: emails) {
            String localName = email.substring(0, email.lastIndexOf("@"));
            String domainName = email.substring(email.lastIndexOf("@"));
            String filterDot = localName.replaceAll("\\.","");
            String filterPlus = "";
            if (filterDot.contains("+"))
                filterPlus = filterDot.substring(0, filterDot.indexOf("+"));
            else
                filterPlus = filterDot;
            emailSet.add(filterPlus+domainName);
        }
        return emailSet.size();
    }
}
