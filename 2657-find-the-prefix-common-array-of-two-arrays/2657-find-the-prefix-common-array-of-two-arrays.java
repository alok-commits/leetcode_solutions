class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        HashSet<Integer> seenA = new HashSet<>();
        HashSet<Integer> seenB = new HashSet<>();
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            if (seenB.contains(A[i])) {
                commonCount++;
            }
            if (seenA.contains(B[i])) {
                commonCount++;
            }
            if (A[i] == B[i]) {
                commonCount++;
            }
            seenA.add(A[i]);
            seenB.add(B[i]);
            C[i] = commonCount;
        }
        return C;
    }
}