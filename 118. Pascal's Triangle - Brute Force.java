class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalList = new ArrayList<List<Integer>>();
        List<Integer> firstRow = new ArrayList<Integer>(1);
        firstRow.add(1);
        pascalList.add(firstRow);
        if (numRows == 1)
            return pascalList;
        if (numRows >= 2) {
            List<Integer> secondRow = new ArrayList<Integer>(2);
            secondRow.add(1);
            secondRow.add(1);
            pascalList.add(secondRow);
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<Integer>(i+1);
            currentRow.add(1);
            List<Integer> previousRow = pascalList.get(i-1);
            for (int j = 1; j < i+1; j++) {
                int value = 0;
                int value1 = 0;
                int value2 = 0;
                value1 = previousRow.get(j-1);
                if (j == i)
                    value2 = 0;
                else
                    value2 = previousRow.get(j);
                value = value1 + value2;
                currentRow.add(value);
            }
            pascalList.add(currentRow);
        }
        return pascalList;
    }
}
