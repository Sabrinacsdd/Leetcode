## Keyword
Divide and conquer

## Problem description
```


```




## Merge
# 23. Merge k Sorted Lists
```Java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode h = new ListNode(0);
    ListNode ans = h;
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            h.next = l1;
            h = h.next;
            l1 = l1.next;
        } else {
            h.next = l2;
            h = h.next;
            l2 = l2.next;
        }
    }
    if(l1==null){
        h.next=l2;
    }
    if(l2==null){
        h.next=l1;
    } 
    return ans.next;
}
public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length==0){
        return null;
    }
    int interval = 1;
    while(interval<lists.length){
        System.out.println(lists.length);
        for (int i = 0; i + interval< lists.length; i=i+interval*2) {
            lists[i]=mergeTwoLists(lists[i],lists[i+interval]);            
        }
        interval*=2;
    }

    return lists[0];
}
```

# 215. Kth Largest Element in an Array
```Java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        int f = nums.length - k;
        return partition(nums, l, r, f); 
    }
    public int partition(int[] nums, int l, int h, int f){
        //if(l == h) return l;
        int pivot = nums[h];
        
        int i = l;
        int j = l;
        while(j < h){
            if(nums[j] < nums[h]){
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        swap(nums, i , h);       
        if(i > f){
            return partition(nums, l, i - 1, f);
        }else if(i < f){
            return partition(nums, i + 1, h, f);
        }else{
            return nums[i];
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
