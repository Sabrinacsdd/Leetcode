## Keyword
Graph

## Problem description
```
1. Union find
2. Bipartite
3. BFS(unweighted, undirected)
4. Cycle (DFS, unionfind (684))

```




## Union Find
## Without rank
```Java
class DSU{
    int[] parent;
    public DSU(int N){
        parent = new int[N];
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }
    }
    public void union(int i, int j){
        parent[find(j)] = find(i);
    }
    public int find(int x){
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
```
## With rank
```Java
class DSU {
    int[] parent;
    int[] rank;
    public DSU(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = i;
        }
        rank = new int[N];
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px == py) return;
        if(rank[px] < rank[py]){
            parent[px] = py;
        } else if (rank[px] > rank[py]){
            parent[py] = px;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }
}
```


## Bipartite (graph coloring)
## DFS (coloring, 0 -> unknownm 1 -> red, -1 -> blue) 
### 785. Is Graph Bipartite?
```java
class Solution {
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        //unknow color 0; color 1; color -1
        for(int i = 0; i < N; i++){
            if(color[i] == 0 && !DFS(i, 1, color, graph)) {
                return false;
            }
        }
        return true;
    }
    public boolean DFS(int i, int c, int[] color, int[][] graph){
        if(color[i] != 0){
            return color[i] == c;
        }
        color[i] = c;
        for(var cur : graph[i]){
            if(!DFS(cur, -c, color, graph)) return false;
        }
        return true;
        
    }
}
```