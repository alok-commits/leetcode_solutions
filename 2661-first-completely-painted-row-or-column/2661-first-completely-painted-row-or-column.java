class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
         
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, int[]> cellPositions = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cellPositions.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int[] position = cellPositions.get(num);
            int row = position[0];
            int col = position[1];

            rowCount[row]++;
            colCount[col]++;
            if (rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }
        return -1; 
    }
}