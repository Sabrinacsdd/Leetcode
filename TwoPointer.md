## Two pointer - 背向双指针：(基本上全是回文串的题)
### 125. Valid Palindrome
```Java
class Solution {
  public boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }
      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }

      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
        return false;
    }

    return true;
  }
}
```

## Two pointer - 相向双指针
### Leetcode 11. Container With Most Water
```Java
    while (i < j) { // move the pointer 
        int cur = Math.min(height[i], height[j]);
        ans = Math.max(ans, cur * (j - i));
        if (height[i] > height[j]) {
            --j;  
        } else {
            ++i;
        }
    }
```

## Two pointer - 同向双指针：(以two sum为基础的一系列题)
### Leetcode 283. Move Zeroes
```Java
    for (int i = 0, j = 0; j < n; ++j) {
        if (nums[j] != 0) {
            swap(nums, i, j);
            ++i;
        }
    }
```



## Two pointer - loop with the length first：
### 647. Palindromic Substrings
```Java
    boolean[][] p = new boolean[n][n];
        
    for (int i = 0; i < n; ++i) {
        p[i][i] = true;
    }
    for (int l = 2; l <= n; ++l) { // loop with the length first
        for (int i = 0; i < n; ++i) {  // check the substring by comparing [i, j] with [i + 1, j - 1]
            int j = i + l - 1;
            if (j >= n) {
                continue;
            }
            if (l == 2) {
                if (s.charAt(i) == s.charAt(j)) {
                    p[i][j] = true;
                }
            } else {
                if (s.charAt(i) == s.charAt(j) && p[i + 1][j - 1]) {
                    p[i][j] = true;
                }
            }
        }
    }
```


