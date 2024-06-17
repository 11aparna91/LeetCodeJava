// problem number 633
class Solution {
    public boolean judgeSquareSum(int c) {
        if (c<0) return false;
        int left = 0;
        long right = (long) Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}