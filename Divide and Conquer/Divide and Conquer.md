## Keyword
Divide and conquer

## Problem description
```


```




## Same direction from start
# 4. Median of Two Sorted Arrays
```Java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //0 - m    0 - n
        int odd = 0;
        double even1 = 0;
        double even2 = 0;
        if((m + n) % 2 == 1){
            odd = med(0, m, 0, n, nums1, nums2, (m + n) / 2 + 1);
            return odd;
        }
        if((m + n) % 2 == 0){
            even1 = med(0, m, 0, n, nums1, nums2, (m + n) / 2 );
            even2 = med(0, m, 0, n, nums1, nums2, (m + n) / 2 + 1);
            return (even1 + even2) / 2;
        }
        return - 1;
    }
    public int med(int l1, int r1, int l2, int r2, int[] nums1, int[] nums2, int k){
        int cur = k / 2;
        if(l1 > nums1.length - 1 && k == 1) return nums2[l2];
        if(l2 > nums2.length - 1 && k == 1) return nums1[l1];
        if(k == 1) return Math.min(nums1[l1], nums2[l2]);
        if ((l1 + cur - 1) > (nums1.length - 1) || (l2 + cur - 1 <= nums2.length - 1 && nums1[cur + l1 - 1] > nums2[cur + l2 - 1])){
            return med(l1, r1, l2 + cur, r2, nums1, nums2, k - cur);
        }else{
            return med(l1 + cur, r1, l2, r2, nums1, nums2, k - cur);
        }
    }
}
```
