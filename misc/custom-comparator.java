class NodeComparator implements Comparator<ListNode> {
    public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
    }
}

new PriorityQueue<ListNode>(new NodeComparator());
