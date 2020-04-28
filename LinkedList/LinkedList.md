## Keyword
LinkedList

## Problem description
```
LinkedList can be roughly categorized into: Singly LinkedList, doubly LinkedList, Circular Linked List 

1. Traverse
2. Swap
3. Reverse(odd even LinkedList)
4. Detect cycle
5. Merge / Intersection of two LinkedList
6. Delete(Remove Nth Node from the end)
7. Insert


Dummy Node
Two pointer 

Always try to break things down to small problems, reverse, swap, insert, delete, merge

Use mutiple pointers, and some cases, need to track the previous node

Several:
61. Rotate List
Odd Even Linked List



```
## Reverse Linked List
# Iterative
```Java
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}
```
# Recustion
```Java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    //for corner case, (the last node to be reversed)
    head.next = null;
    return p;
}
```

## Two Pointer
```Java
// Initialize slow & fast pointers
ListNode slow = head;
ListNode fast = head;
/**
 * Change this condition to fit specific problem.
 * Attention: remember to avoid null-pointer error
 **/
while (fast != null && fast.next != null) {
    slow = slow.next;           // move slow pointer one step each time
    fast = fast.next.next;      // move fast pointer two steps each time
    if (slow == fast) {         // change this condition to fit specific problem
        return true;
    }
}
return false;   // change return value to fit specific problem
```
## Notes
```
Hare and Tortoise
Use slow and fast pointer, initiate to head at the first beginning 
while (fast != null && fast.next != null)
1 -> 2 -> 3 -> 4 -> 5
          S         F
1 -> 2 -> 3 -> 4 -> 5 -> 6
          S         F
So the slow pointer will point to the middle(odd cases) or the front middle(even cases)
```


## Merge
```Java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode dummy = new ListNode(-1);

        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return dummy.next;
    }
}
```
