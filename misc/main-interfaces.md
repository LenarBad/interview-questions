# Queue

|              | Throws Exception     | Returns special value |
|--------------|:--------------------:|:---------------------:|
| **Insert**   | add(e)               | offer(e)              |
| **Remove**   | remove()             | poll()                |
| **Examine**  | element()            | peek()                |

Also: `isEmpty()`, `size()`

Implementations: _**LinkedList**_, _**PriorityQueue**_

# Stack (class)

Methods: `peek()`, `pop()`, `push(e)`, `isEmpty()`, `size()`

# Map

Methods: `containsKey(key)`, `entrySet()`, `get(key)`, `getOrDefault(key, defaultValue)`, `keySet()`, `values()`, `remove(key)`

Implementations: _**HashMap**_, _**TreeMap**_, _**Hashtable**_, _**Properties**_

# List

Methods: `add(e)`, `get(i)`, `addAll(collection)`, `indexOf(e)`, `remove(i)`, `set(i, e)`, `sort(comparator)`, `subList(fromIndex, toIndex)`, `toArray()`

Implementations: _**ArrayList**_, _**LinkedList**_, _**Stack**_, _**Vector**_

# Set

Methods: `add(e)`, `contains(e)`, `containsAll(collection)`, `remove(e)`, `removeAll(collection)`, `toArray()`, `stream()`

Implementations: _**HashSet**_, _**TreeSet**_, _**LinkedHashSet**_
