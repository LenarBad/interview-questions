class Node {
    char[] values;
    int size;
    Node next;
}

class UnrolledList {
    Node head;
    int length;

    public char get(int index) {
        validateIndex(index);
        Node node = head;
        int count = 0;
        while (count + node.size < index) {
            count += node.size;
            node = node.next;
        }
        int targetIndex = count + node.size - index;
        return node.values[targetIndex];
    }
    
    public void insert(int index, char character) {
        validateIndex(index);
        Node node = head;
        int capacity = node.values.length;
        int count = 0;
        while (count + node.size < index) {
            count += node.size;
            node = node.next;
        }
        int targetIndex = count + node.size - index;
        if (node.size == capacity) { 
            // need to move the lost one to the next node or new node
            char lastChar = node.values[capacity - 1];
            if (node.next.size == capacity) { 
                // create and insert new node
                Node nextNode = new Node();
                nextNode.next = node.next;
                node.next = nextNode;
                nextNode.values[0] = lastChar;
                nextNode.size = 1;
            } else {
                // insert the last character into next node's values
                insertToArray(0, lastChar, node.next.values);
            }
        }
        insertToArray(targetIndex, charcter, node.values);
        length++;
    }
    
    private void insertToArray(int index, char character, Node node) {
        for (int i = Math.min(node.size, node.values.length - 1); i > index; i--) {
            node.values[i] = arr[i - 1];
        }
        node.values[index] = character;
        node.size = Math.min(node.size + 1, node.values.capacity);
    }
    
    private validateIndex(int index) {
        if (index < 0 || index >= head.values.length) {
            throw new RuntimeException("Array Index Out Of Bounds Exception")
        }
    }

}
