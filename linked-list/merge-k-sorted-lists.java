/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new NodeComparator());
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }
        if (q.isEmpty()) {
            return null;
        }

        ListNode next = q.poll();
        ListNode head = new ListNode(next.val);
        ListNode curr = head;
        if (next.next != null) {
            q.add(next.next);
        }

        while (!q.isEmpty()) {
            next = q.poll();
            curr.next = next;
            if (next.next != null) {
                q.add(next.next);
            }
            curr = next;
        }
        return head;
    }

    class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
}
