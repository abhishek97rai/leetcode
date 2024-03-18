class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        //first step is to append sign based on input, and then take abs values of the inputs
        //second step is to append left part before the decimal, ie quotient
        //if remainder after this is 0, return answer
        //if not, append decimal, and calculate right part after it
        //main funda for calculating right part is that we will go until remainder != 0, and at each step we do rem *= 10
        //for calculating right part, we need to take care of recurring decimals
        //for that purpose, we will use a hashmap, that will store remainder and its index at each step
        //if the remainder is repeated, we know that we need to add an opening bracket at that index, and close it at end
        StringBuilder sb = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sb.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        sb.append(String.valueOf(dividend/divisor));
        long remainder = dividend % divisor;
        if (remainder == 0)
            return sb.toString();
        sb.append(".");
        Map<Long, Integer> hm = new HashMap<>();
        while (remainder != 0) {
            if (hm.containsKey(remainder)) {
                int index = hm.get(remainder);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            hm.put(remainder, sb.length());
            remainder *= 10;
            sb.append(String.valueOf(remainder/divisor));
            remainder = remainder % divisor;
        }
        return sb.toString();
    }
}
