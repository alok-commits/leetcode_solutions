class Solution {
     private static final int[][] DIRECTIONS = {
        {0, 1},  // Right
        {0, -1}, // Left
        {1, 0},  // Down
        {-1, 0}  // Up
    };
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        deque.offerFirst(new int[]{0, 0, 0});
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0], y = current[1], currentCost = current[2];

            if (currentCost > cost[x][y]) continue;

            for (int dir = 0; dir < DIRECTIONS.length; dir++) {
                int newX = x + DIRECTIONS[dir][0];
                int newY = y + DIRECTIONS[dir][1];
                int newCost = currentCost + (grid[x][y] == dir + 1 ? 0 : 1);

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && newCost < cost[newX][newY]) {
                    cost[newX][newY] = newCost;
                    if (grid[x][y] == dir + 1) {
                        deque.offerFirst(new int[]{newX, newY, newCost}); 
                    } else {
                        deque.offerLast(new int[]{newX, newY, newCost});
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}