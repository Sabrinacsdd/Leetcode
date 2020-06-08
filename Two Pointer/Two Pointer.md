## Keyword
Two Pointer

## Problem description
```
Usually for array, two pointers are used to traversed to whole array either same direction or one starts from beginning one starts from end. 
1. Same direction from start
2. One from beginning, one from end
3. Two pointer points two array

```

## Same direction from start
# 3. Longest Substring Without Repeating Characters
```Java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map <Character, Integer> unique = new HashMap<>();
        int ans = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            if(unique.containsKey(s.charAt(j))){
                i = Math.max(unique.get(s.charAt(j)) + 1, i);
            }
            ans= Math.max(ans, j - i + 1);
            unique.put(s.charAt(j), j);
        }
        return ans;
    }
}
```
# 76. Minimum Window Substring
```Java
class Solution {
  public String minWindow(String s, String t) {

      if (s.length() == 0 || t.length() == 0) {
          return "";
      }

      // Dictionary which keeps a count of all the unique characters in t.
      Map<Character, Integer> dictT = new HashMap<Character, Integer>();
      for (int i = 0; i < t.length(); i++) {
          int count = dictT.getOrDefault(t.charAt(i), 0);
          dictT.put(t.charAt(i), count + 1);
      }

      // Number of unique characters in t, which need to be present in the desired window.
      int required = dictT.size();

      // Left and Right pointer
      int l = 0, r = 0;

      // formed is used to keep track of how many unique characters in t
      // are present in the current window in its desired frequency.
      // e.g. if t is "AABC" then the window must have two A's, one B and one C.
      // Thus formed would be = 3 when all these conditions are met.
      int formed = 0;

      // Dictionary which keeps a count of all the unique characters in the current window.
      Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

      // ans list of the form (window length, left, right)
      int[] ans = {-1, 0, 0};

      while (r < s.length()) {
          // Add one character from the right to the window
          char c = s.charAt(r);
          int count = windowCounts.getOrDefault(c, 0);
          windowCounts.put(c, count + 1);

          // If the frequency of the current character added equals to the
          // desired count in t then increment the formed count by 1.
          if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
              formed++;
          }

          // Try and contract the window till the point where it ceases to be 'desirable'.
          while (l <= r && formed == required) {
              c = s.charAt(l);
              // Save the smallest window until now.
              if (ans[0] == -1 || r - l + 1 < ans[0]) {
                  ans[0] = r - l + 1;
                  ans[1] = l;
                  ans[2] = r;
              }

              // The character at the position pointed by the
              // `Left` pointer is no longer a part of the window.
              windowCounts.put(c, windowCounts.get(c) - 1);
              if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                  formed--;
              }

              // Move the left pointer ahead, this would help to look for a new window.
              l++;
          }

          // Keep expanding the window once we are done contracting.
          r++;   
      }

      return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
  }
}
```



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

## Three Pointers
# 75. Sort Colors
```
               j
[000000000 111102010201021 2222222]
           i             k
i : to the left of i, all 1s
j : current pointer
k : to the right of k, all 2s
```
```Java
class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int k = nums.length - 1;
        int j = 0;
        while(j <= k) {
            //if current is 0
            if(nums[j] == 0){
                swap(i, j, nums);
                j++;
                i++;
            //if current is 2
            } else if (nums[j] == 2) {
                swap(k, j, nums);
                k--;
            //if current is 1
            } else { 
                j++;
            }
        }
    }
    public void swap(int a , int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
```

## QuickSort
# 912. Sort an Array
```Java
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void quickSort(int[] nums, int l, int r){
        if(l < r){
            int index = partition(nums, l ,r);
            quickSort(nums, l, index - 1);
            quickSort(nums, index + 1, r);
        }
    }
    public int partition(int[] nums, int l, int r){
        //take the last number as pivot
        int pivot = nums[r];
        int i = l;
        for(int j = l; j < r; j++){
            if(nums[j] < pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }
    public void swap(int[] nums, int i ,int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
```
