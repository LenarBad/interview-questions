## Reverse order comparator

`Collections.reverseOrder()`

Example

```java
PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
```

## Custom Comparator

```java
class NodeComparator implements Comparator<ListNode> {
    public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
    }
}

new PriorityQueue<ListNode>(new NodeComparator());
```
or 

```java
new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
```

## Multiple Fields Comparator

```java
Collections.sort(reportList, Comparator.comparing(Report::getReportKey)
            .thenComparing(Report::getStudentNumber)
            .thenComparing(Report::getSchool));
```
=
```java
Comparator<Report> comparator = Comparator.comparing(report -> report.getReportKey())
            .thenComparing(report -> report.getStudentNumber())
            .thenComparing(report -> report.getSchool());
Collection.sort(reportList, comparator);
```

Add .reversed() to the "comparing" that needs to be reversed
```java
Comparator<Report> comparator = Comparator.comparing(report -> report.getReportKey())
            .thenComparing(report -> report.getStudentNumber()).reversed()
            .thenComparing(report -> report.getSchool());
```
