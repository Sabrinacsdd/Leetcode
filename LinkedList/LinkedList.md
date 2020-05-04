## Keyword
LinkedList

## Problem description
```
LinkedList can be roughly categorized into: Singly LinkedList, doubly LinkedList, Circular Linked List 

1. Traverse(delete/add)
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







## Swap
# Iterative
```Java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        
        //swap the two nodes;
        p.next = swapPairs(q.next);
        q.next = p;
        
        return q;
    }
}
```
# Recusion
```Java
class Solution {
    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
}
```


## Reverse Linked List
# Iterative
```Java
public ListNode reverseList(ListNode head) {
    //prev is the head of the reversedList
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
# Recusion
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
# Detect cycle
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

# Floyd's Tortoise and Hare
```Java
public class Solution {
    private ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                //
                return tortoise;
            }
        }
        //this means there is no cycle in the linkedlist
        return null;
}

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }
        // To find the entrance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}
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
