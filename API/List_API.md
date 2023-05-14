## List method
https://www.geeksforgeeks.org/list-interface-java-examples/

## General
```java
List a = new ArrayList();
List b = new LinkedList();
List c = new Vector(); 
List d = new Stack(); 

// Obj is the type of object to be stored in List
List<Obj> list = new ArrayList<Obj> ();

 ```

 ## Positional Access
 ``` Java
void add(int index, Object O)//This method adds given element at specified index.
l1.add(0, 1);
boolean addAll(int index, Collection c)// This method adds all elements from specified collection to list. First element gets inserted at given index. If there is already an element at that position, that element and other subsequent elements(if any) are shifted to the right by increasing their index.
l1.addAll(1, l2); // Will add list l2 from 1 index 
Object remove(int index)// This method removes an element from the specified index. It shifts subsequent elements(if any) to left and decreases their indexes by 1.
l1.remove(1); 
Object get(int index)// This method returns element at the specified index.
l1.get(3);
Object set(int index, Object new)//This method replaces element at given index with new element. This function returns the element which was just replaced by new element.
l1.set(0, 5); 
```

## Search
```Java
int indexOf(Object o) // This method returns first occurrence of given element or -1 if element is not present in list.
l.indexOf("Geeks");
int lastIndexOf(Object o) // This method returns the last occurrence of given element or -1 if element is not present in list.
l.lastIndexOf("Geeks");
```

## Iteration
https://www.geeksforgeeks.org/list-listiterator-method-in-java-with-examples/


## Range-view
```Java
List subList(int fromIndex, int toIndex)// This method returns List view of specified List between fromIndex(inclusive) and toIndex(exclusive).
List<String> range = new ArrayList<String>(); 
range = l.subList(2, 4); 
```