class Solution {
    public boolean doesValidArrayExist(int[] derived) {
         int n = derived.length;
        if (isValidOriginal(derived, 0)) {
            return true;
        }
        return isValidOriginal(derived, 1);
    }

    private static boolean isValidOriginal(int[] derived, int firstValue) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = firstValue;
        for (int i = 1; i < n; i++) {
            original[i] = derived[i - 1] ^ original[i - 1];
        }
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
}