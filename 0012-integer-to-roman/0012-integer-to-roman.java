class Solution {
    public String intToRoman(int num) {
         String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; i++) {
            int count = num / values[i]; 
            num %= values[i];           

            while (count-- > 0) {
                roman.append(symbols[i]);
            }
        }
        return roman.toString();
    }
}