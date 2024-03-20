class Solution {
    public int[] sortByBits(int[] arr) {
        //using hamming code logic to find 1s count
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
        int hammingCountA = calculateHammingCount(a);
        int hammingCountB = calculateHammingCount(b);
        if (hammingCountA == hammingCountB)
            return (a - b);
        return (hammingCountA - hammingCountB);
    }

    //use mask bit as 1 to & with num
    //if result is >0 means the corresponding bit in num was 1
    //flip that bit to 0 so that eventual condition to break loop becomes num == 0 once all bits are traversed
    //left shift mask bit by 1 bit each time to test next bit of num
    public int calculateHammingCount(Integer num) {
        int count = 0;
        int mask = 1;
        while (num > 0) {
            if ((num & mask) > 0) {
                count++;
                //xor num and mask to flip bit of num from 1 to 0
                num = num ^ mask;
            }
            mask = mask << 1;
        }
        return count;
    }
}
