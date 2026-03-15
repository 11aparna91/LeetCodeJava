class Solution {
    public int maxProfit(int[] prices) {
        int minVal= Integer.MAX_VALUE;
        int maxDifr=0;
            
        for (int i=0; i<prices.length; i++) {
          if (prices[i] < minVal){
            minVal= prices[i];
          } else if (prices[i] - minVal > maxDifr) {
            maxDifr= prices[i] - minVal;
          }   
        }
        return maxDifr;
    }
}