## Binary Search 
```Java
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            
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
            // check if nums[]
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