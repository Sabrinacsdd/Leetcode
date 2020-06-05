## Keyword
Two Pointer

## Problem description
```
Usually for array, two pointers are used to traversed to whole array either same direction or one starts from beginning one starts from end. 
1. Same direction from start
2. One from beginning, one from end
3. Two pointer points two array

```



//dutch flag
//quicksort

## Same direction from start
# 
```Java

```
## 



## One from beginning, one from end
```
[X,X,X,X,X,X,X]
 i->       <-j
```
# 11. Container With Most Water
```Java
class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int ans = 0;
        while(i < j){
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
}
```
# 42. Trapping Rain Water
```Java
class Solution {
    public int trap(int[] height) {
        if(height.length < 3) return 0;
        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        int ans = 0;
        while(l < r){
            if(maxL < maxR){
                l++;
                if(height[l] > maxL){
                    maxL = height[l];
                }
                else{
                    ans += maxL - height[l];
                }
            }
            else{
                r--;
                if(height[r] > maxR){
                    maxR = height[r];
                }
                else{
                    ans += maxR - height[r];
                }
            }
        }
        return ans;
    }
}
```
# 881. Boats to Save People
```Java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if(people.length <= 1) return people.length;
        int i = 0;
        int j = people.length - 1;
        int ans = 0;
        Arrays.sort(people);
        while(i < j){
            ans++;
            if(people[i] + people[j] <= limit){
                i++;
            }  
            j--;
        }
        if(j == i) ans++;
        return ans;
    }
}
```

## Two pointer points two array, both from beginning
```
[XXXXX]
 i
[YYYYY]
 j
```
# 455. Assign Cookies
```Java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0;
    for(int j=0;i<g.length && j<s.length;j++) {
	    if(g[i]<=s[j]) i++;
    }
    return i;
    }
}
```
# 986. Interval List Intersections
```Java
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        List<int[]> ans = new ArrayList<>();
        while (i < A.length && j < B.length){
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if (start <= end){
                ans.add(new int[]{start,end});
                
            }
            if (A[i][1] < B[j][1]){
                ++i;
            } else {
                ++j;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
```

## Two pointer points two array, both from back

```
[XXXXX]
     i
[YYYYY]
     j
```
# 844. Backspace String Compare
```Java
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int N = S.length() - 1;
        int M = T.length() - 1;
        int count_s = 0;
        int count_t = 0;
        while(N >= 0 || M >= 0){
            
            while(N >= 0 && (S.charAt(N) == '#' || count_s > 0)){
                if(S.charAt(N) == '#'){
                    count_s++;
                    N--;
                }
                else if( count_s > 0){
                    count_s--;
                    N--;
                }
            }
           
            while(M >= 0 && (T.charAt(M) == '#' || count_t > 0)){
                if(T.charAt(M) == '#'){
                    count_t++;
                    M--;
                }
                else if( count_t > 0){
                    count_t--;
                    M--;
                }
            }      

            
            if(M == -1 && N == -1) return true;
            if(M == -1 ^ N == -1) return false;
            if(S.charAt(N) != T.charAt(M)){
                return false;
            }
            N--;
            M--;
        }
        return true;
    }
}
```

