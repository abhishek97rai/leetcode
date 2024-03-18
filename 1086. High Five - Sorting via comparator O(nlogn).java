class Solution {
    public int[][] highFive(int[][] items) {
        //this approach involves sorting original array as per increasing order of IDs first and 
        //then decreasing order of scores if the IDs are same
        //we can do that by creating a custom comparator
        //once we have the sorted array, we traverse it and calculate avg and store it in result array
        Arrays.sort(items, 
            new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) {
                        //increasing order of id
                        return a[0] - b[0];
                    }
                    //decreasing order of score
                    return b[1] - a[1];
                }
            }
        );

        List<List<Integer>> listOfLists = new ArrayList<>();
        int i = 0;
        while (i < items.length) {
            int id = items[i][0];
            int k = 0;
            int sum = 0;
            while (i < items.length && items[i][0] == id && k != 5) {
                sum += items[i][1];
                i++;
                k++;
            }
            int avg = sum/5;
            List<Integer> temp = new ArrayList<>();
            temp.add(id);
            temp.add(avg);
            listOfLists.add(temp);
            while (i < items.length && items[i][0] == id) {
                i++;
            }
        }

        int[][] res = new int[listOfLists.size()][listOfLists.get(0).size()];
        for (int j = 0; j < res.length; j++) {
            res[j][0] = listOfLists.get(j).get(0);
            res[j][1] = listOfLists.get(j).get(1);
        }

        return res;
    }
}
