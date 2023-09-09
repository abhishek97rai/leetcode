class Solution {
    public int maximumPopulation(int[][] logs) {
        if (logs.length == 1)
            return logs[0][0];
        int minBirthYr = logs[0][0];
        int maxBirthYr = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            int year = logs[i][0];
            if (year < minBirthYr)
                minBirthYr = year;
            if (year > maxBirthYr)
                maxBirthYr = year;
        }
        int size = maxBirthYr-minBirthYr+1;
        int[] years = new int[size];
        for (int i = 0; i < logs.length; i++) {
            int birthYr = logs[i][0];
            int deathYr = logs[i][1];
            years[birthYr-minBirthYr]++;
            if (deathYr <= maxBirthYr) {
                years[deathYr-minBirthYr]--;
            }
        }
        int maxSum = 0;
        int sum = 0;
        int resultYear = 0;
        for (int i = 0; i < size; i++) {
            sum += years[i];
            if (sum > maxSum) {
                maxSum = sum;
                resultYear = i + minBirthYr;
            }            
        }
        return resultYear;
    }
}
