class Solution {
    private static final int[][] DIRECTIONS = {
        {0, 1},  // Right
        {0, -1}, // Left
        {1, 0},  // Down
        {-1, 0}  // Up
    };
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3) {
            return 0; 
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    minHeap.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int totalWater = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int x = current[0], y = current[1], height = current[2];
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    int waterTrapped = Math.max(0, height - heightMap[newX][newY]);
                    totalWater += waterTrapped;
                    minHeap.offer(new int[]{newX, newY, Math.max(height, heightMap[newX][newY])});
                }
            }
        }
        return totalWater;
    }
}