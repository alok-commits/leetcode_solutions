class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0; 
        }
        
        long exp = n; 
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        while (exp > 0) {
            if (exp % 2 == 1) { 
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            exp /= 2; 
        }
        
        return result;
    }
}