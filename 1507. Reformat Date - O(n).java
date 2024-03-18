class Solution {
    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];
        StringBuilder sb = new StringBuilder();
        sb.append(year);
        sb.append("-");
        switch(month) {
            case "Jan":
                sb.append("01-");
                break;
            case "Feb":
                sb.append("02-");
                break;
            case "Mar":
                sb.append("03-");
                break;
            case "Apr":
                sb.append("04-");
                break;
            case "May":
                sb.append("05-");
                break;
            case "Jun":
                sb.append("06-");
                break;
            case "Jul":
                sb.append("07-");
                break;
            case "Aug":
                sb.append("08-");
                break;
            case "Sep":
                sb.append("09-");
                break;
            case "Oct":
                sb.append("10-");
                break;
            case "Nov":
                sb.append("11-");
                break;
            case "Dec":
                sb.append("12-");
                break;
        }
        StringBuilder yr = new StringBuilder();
        String yrSt = parts[0].substring(0, parts[0].length()-2);
        if (yrSt.length() == 1)
            yr.append("0");
        yr.append(yrSt);
        sb.append(yr);
        return sb.toString();
    }
}
