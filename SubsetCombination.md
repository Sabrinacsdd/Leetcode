### Leetcode 39 Combination Sum（I, II, III相似， IV为动态规划题目）
### Leetcode 78 Subsets （I, II 重点在于如何去重）
### Leetcode 46 Permutation (I, II 重点在于如何去重)
### Leetcode 77 Combinations (I, II 重点在于如何去重)

## Subset & Combination skip duplicates
### 90. Subsets II
```Java
    private void DFS(int[] nums, List<List<Integer>> ans, List<Integer> list, int index){
        //add current list
        ans.add(new ArrayList<>(list));  // pay attention to when to add it to the list
        //backtracking
        for(int i = index; i < nums.length; i++){
            //skip duplicates
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            };
            list.add(nums[i]);
            DFS(nums, ans, list, i + 1);
            list.remove(list.size() - 1); // remove the current one
        }
    }
```

## Permutations
### 46. Permutations
```Java
    public void DFS(List<List<Integer>> ans, List<Integer> cur, int[] nums, boolean[] visited){
        if(cur.size() == nums.length){  
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            cur.add(nums[i]);
            DFS(ans, cur, nums, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
```