class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xorNums1 = 0;
        int xorNums2 = 0;

        for (int num : nums1) {
            xorNums1 ^= num;
        }

        for (int num : nums2) {
            xorNums2 ^= num;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        int result = 0;

        if (len2 % 2 != 0) {
            result ^= xorNums1;
        }

        if (len1 % 2 != 0) {
            result ^= xorNums2;
        }
        return result;
    }
}