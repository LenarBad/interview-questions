class MyQueue {
    private Stack<Integer> one;
    private Stack<Integer> two;

    public MyQueue() {
        one = new Stack<>();
        two = new Stack<>();
    }

    public void push(int x) {
        while (!one.isEmpty()) {
            two.push(one.pop());
        }
        one.push(x);
        while (!two.isEmpty()) {
            one.push(two.pop());
        }
    }

    public int pop() {
        return one.pop();
    }

    public int peek() {
        return one.peek();
    }

    public boolean empty() {
        return one.isEmpty();
    }
}
