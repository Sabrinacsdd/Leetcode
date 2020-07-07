## Keyword
Graph

## Problem description
```
1. Union find

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
Class DSU{
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
    public void union(int x, int y, int[] parent){
        int rootx = find(x);
        int rooty = find(y);
        if(rootx == rooty) {
            return;
        }
        if(rootx < rooty) {
            parent[rooty] = parent[rootx];
        } else {
            parent[rootx] = parent[rooty];
        }
    }
}
```