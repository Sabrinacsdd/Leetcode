## Keyword
LinkedList

## 

## Problem description
```
LinkedList can be roughly categorized into: Singly LinkedList, doubly LinkedList, Circular Linked List 

Traverse(delete/add)
Swap
Add
Reverse(odd even LinkedList)
Detect cycle(Two pointer)
Merge / Intersection of two LinkedList
Delete(Remove Nth Node from the end)
Insert
OOD


***************
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
```
Swap every two nodes
```

```Java

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
## Add
# Add Two Numbers  
```Java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}
```
# 445. Add Two Numbers II
```Java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode q = l1;
        ListNode p = l2;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(q != null){
            s1.add(q.val);
            q = q.next;
        }
        while(p != null){
            s2.add(p.val);
            p = p.next;
        }
        ListNode dummy;
        ListNode cur = new ListNode();
        dummy = cur;
        int carry = 0;
        
        while(s1.size() != 0 || s2.size() != 0 || carry != 0){
            int a = (s1.size() != 0) ? s1.pop() : 0;
            int b = (s2.size() != 0) ? s2.pop() : 0;
            int sum = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            
            ListNode n = new ListNode();
            n.next = cur;
            cur.val = sum;
            cur = n;
        }
        return cur.next;
    }
}
```

## Reverse Linked List
# Singly LinkedList
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
# Doubly LinkedList
```Java


public DListNode reverse(DListNode head) {
    DListNode curr = null;
    while (head != null) {
        curr = head;
        head = curr.next;
        curr.next = curr.prev;
        curr.prev = head;
    }
    return curr;
}
```


## Two Pointer
# Floyd's Tortoise and Hare
```Java
public class Solution {
    private ListNode detectCycle(ListNode head) {
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

    public ListNode getIntersect(ListNode head) {
        if (head == null) {
            return null;
        }
        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        ListNode intersect = detectCycle(head);
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


# Use Two Pointer to find mid
```
Hare and Tortoise start from head
Use slow and fast pointer, initiate to head at the first beginning 
while (fast != null && fast.next != null)
1 -> 2 -> 3 -> 4 -> 5 -> null
          S         F
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
               S               F
So the slow pointer will point to the middle(odd cases) or the latter middle(even cases)
```
--------------------------------------------------------------------------------------------------------

## Delete/Remove
# 83. Remove Duplicates from Sorted List 
```Java
public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }

        return head;
    }
}
```
# 82. Remove Duplicates from Sorted List II
```Java
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while(node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                int val_prev = node.next.val;
                while (node.next != null && node.next.val == val_prev) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }

        return dummy.next;
    }
}
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
# Note
```
23. Merge k Sorted Lists
```


## OOD
# Note
```
380. Insert Delete GetRandom O(1)
146. LRU Cache
```

