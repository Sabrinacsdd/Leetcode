## LeetCode link(Easy)
https://leetcode.com/problems/first-missing-positive/

## Keyword
Array

## Problem description
```
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
```



## Notes


## Things to watchout

## 01/27/2020 Java

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = 0;
        while (n < nums.length){
            if(nums[n] == 1){
                break;
            }
            n++;
        }
        if (n == nums.length){
            return 1;
        }
        if (n == 1){
            return 2;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 1;
            }            
        }
        for(int i = 0; i < nums.length; i++){
            
            int a = Math.abs(nums[i]);
            
            if(a == nums.length){
                nums[0] = - Math.abs(nums[0]);
            }
            else{
                nums[a] = - Math.abs(nums[a]);
            }

        }
         for(int i = 1; i < nums.length; i++){
            if(nums[i] > 0){
                return i;
            }
        }
        if(nums[0] > 0){
            return nums.length;
        }
        else{
            return nums.length + 1;
        }
    }
}

```
## Complexity Analyze
