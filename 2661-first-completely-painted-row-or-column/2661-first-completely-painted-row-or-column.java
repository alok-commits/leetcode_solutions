class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] indexArray = new int[m * n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                indexArray[mat[i][j]][0] = i; 
                indexArray[mat[i][j]][1] = j; 
            }
        }
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int row = indexArray[num][0];
            int col = indexArray[num][1];
            rowCount[row]++;
            colCount[col]++;
            if (rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }

        return -1; 
    }
}