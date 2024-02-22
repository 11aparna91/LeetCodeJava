import java.math.BigInteger;

/*
https://leetcode.com/problems/add-strings/
Problem Number: 415
*/

class Sol {
    public String addStrings(String num1, String num2) {
        BigInteger res1 = new BigInteger(num1);
        BigInteger res2 = new BigInteger(num2);
        BigInteger result = res1.add(res2);
        return String.valueOf(result);
    }
}