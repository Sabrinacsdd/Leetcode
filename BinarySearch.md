## Binary Search - general case
```Java
    int l = 0;
    int r = nums.length;   // [l, r）
    while (l < r) {
        int m = l + (r - l) / 2; // make sure no overflow
        
        if (f(m)) {
            return m; // optional
        }
        if (g(m)) {
            r = m;     // new range [l, m）
        } else {
            l = m + 1; // new range [m+1, r)
        }
    }
    return l;
    // or not found, need to check l before return, l is the smallest index where g(m) is true
    // FFFFTTTT
    //     l
```
## Binary Search - Rotated Sorted Array case (81. Search in Rotated Sorted Array II)
```Java
    int l = 0;
    int r = nums.length;   // [l, r）
    while (l < r) {
        int m = l + (r - l) / 2;
        
        if (nums[m] == target) {  // F(m)
            return true;
        }
        if (nums[m] > nums[l]) {
            if (nums[l] <= target && target < nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        } else if (nums[l] > nums[m]) {
            if (nums[m] < target && target <= nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        } else {
            ++l;
        }
    }
    return l; // check if l is inbound and valid before return
```

## Binary Search - 隐式二分法(875. Koko Eating Bananas)
```Java
public int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        int l = 1;
        int r = max + 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if(g(m,piles) <= H){
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    public int g(int k, int[] piles){
        int ans = 0;
        for(int i = 0; i < piles.length; i++){
            ans += (piles[i]) / k;
            if ((piles[i]) % k > 0) {
                ans++;
            }
        }
        return ans;
    }
```























```Java

        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            
            int m = l + (r - l) / 2;
            //check if nums[l] to nums[m] is a sorted array
            if(nums[m] >= nums[l])
            //move l,r based on the sorted array already know. depends on each problem
            //do more if here to check where will the answer be
                l = m + 1;   
            //else that nums[m] to nums[r] is a sorted array
            else{
               r = m;  
            }   
            
        }
        return nums[l];
```


```
For rorated array, no duplicate number.
153. Find Minimum in Rotated Sorted Array

```
```Java
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            //special case
            if(nums[l] < nums[r]) return nums[l];
            int m = l + (r - l) / 2;
            //check if nums[l] to nums[m] is a sorted array
            if(nums[m] >= nums[l])
                l = m + 1;   
            //else that nums[m] to nums[r] is a sorted array
            else{
               r = m;  
            }   
            
        }
        return nums[l];
```


```
For rorated array, with duplicate number.
154. Find Minimum in Rotated Sorted Array II
```
```Java
  
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            //special case to find the smallest number
            if(nums[l] < nums[r]) return nums[l];
            int m = l + (r - l) / 2;
            //check if nums[l] to nums[m] is a sorted array
            if(nums[m] > nums[l]) 
                l = m + 1;
            //else that nums[m] to nums[r] is a sorted array
            else if(nums[m] < nums[l])
                r = m;
            //if nums[l] == nums[mid] means there are duplicate numbers
            else l++;
        }
        return nums[l];

```








## API
```java

Collections.binarySearch()
    public static <T>    int binarySearch(List<? extends Comparable<? super T>> list,
                   T key)
                   list - the list to be searched.
                   key - the key to be searched for.
    the index of the search key, if it is contained in the list; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the list: the index of the first element greater than the key, or list.size() if all elements in the list are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.


    public static <T> int binarySearch(List<? extends T> list,
                   T key,
                   Comparator<? super T> c)
                   list - the list to be searched.
                   key - the key to be searched for.
                   c - the comparator by which the list is ordered. A null value indicates that the elements natural ordering should be used.
    the index of the search key, if it is contained in the list; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the list: the index of the first element greater than the key, or list.size() if all elements in the list are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.
```