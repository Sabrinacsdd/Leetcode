## Map method
```java
 Map <Integer, Interger> map = new HashMap <> ();
 map.put(key, element);
 map.containsKey(key);
 map.get(key);
 map.getOrDefault(key, defaultValue); // key : which is the key of the element whose value has to be obtained. Default value: which is the default value that has to be returned, if no value is mapped with the specific key.   This method returns value mapped with the specified key, otherwise default value is returned.
 HashMap.keySet(); //HashMap.keySet() method in Java is used to create a set out of the key elements contained in the hash map. It basically returns a set view of the keys or we can create a new set and store the key elements in them.

Iterate through a HashMap
HashMap<Integer, GNode> graph = new HashMap<>(); 
 for (Map.Entry<Integer, GNode> entry : graph.entrySet()) {
      GNode node = entry.getValue();
      if (node.inDegrees == 0)
        nodepCourses.add(entry.getKey());
}



 ```
