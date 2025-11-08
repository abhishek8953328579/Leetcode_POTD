package Leetcode_POTD;

public class minimumOneBitOperations {
    public static void main(String[] args) {
        int n = 3;
        int res = 0;
        while (n > 0) {
            res ^= n;
            n >>= 1;
        }
        return res;
    }
    
}
