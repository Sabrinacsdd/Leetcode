## Binary Search - general case (200. Number of Islands)
```Java
  public int numIslands(char[][] grid) {
        
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int ans = 0;
        
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                // check the current grid
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        
        // recursion find all it's neighbors
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);     
    }
```