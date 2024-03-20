class Solution {
    public int[] sortByBits(int[] arr) {
        //using in built java bit count method
        //to create a custom comparator, we need wrapper classes, for which we'll use Arrays.stream
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums, comparator);
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}

class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        int bitCountA = Integer.bitCount(a);
        int bitCountB = Integer.bitCount(b);
        if (bitCountA == bitCountB)
            return a-b;
        return bitCountA-bitCountB;
    }
}
