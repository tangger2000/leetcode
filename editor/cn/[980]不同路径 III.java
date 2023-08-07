class Solution {
    private int m, n, zero_num;
    private int[][] grid;
    private boolean[][] vis;
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        zero_num = 0;
        int start_x = 0, start_y = 0;
        this.grid  = grid;

        // count zero
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0)
                    zero_num += 1;
                else if(grid[i][j] == 1){
                    start_x = i;
                    start_y = j;
                }
            }
        }

        vis = new boolean[m][n];
        vis[start_x][start_y] = true;

        // System.out.println(zero_num);
        // System.out.println(start_x);
        // System.out.println(start_y);

        return dfs(start_x, start_y, 0);
    }

    int dfs(int i, int j, int k){
        if(grid[i][j] == 2)
            return k == zero_num + 1 ? 1: 0;

        int ans = 0;
        int[] directions = {-1, 0, 1, 0, -1};
        for(int h=0; h<4; h++){
            int x = i + directions[h], y = j + directions[h+1];
            if(x >= 0 && x < m && y >=0 && y <n && !vis[x][y] && grid[x][y] != -1){
                vis[x][y] = true;
                ans += dfs(x, y, k+1);
                vis[x][y] = false;
            }
        }
        return ans;
    }
}