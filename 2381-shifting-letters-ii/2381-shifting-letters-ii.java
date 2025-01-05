class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1]; 
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) { 
                diff[start] += 1;
                diff[end + 1] -= 1;
            } else { 
                diff[start] -= 1;
                diff[end + 1] += 1;
            }
        }
        int[] netShifts = new int[n];
        int cumulative = 0;
        for (int i = 0; i < n; i++) {
            cumulative += diff[i];
            netShifts[i] = cumulative % 26; 
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char originalChar = s.charAt(i);
            int shift = (netShifts[i] + 26) % 26;
            char newChar = (char) ((originalChar - 'a' + shift) % 26 + 'a');
            result.append(newChar);
        }

        return result.toString();
    
    }
}