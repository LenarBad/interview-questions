class MedianFinder {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    private double median;
    private boolean isEven = true;

    public MedianFinder() {
        right = new PriorityQueue();
        left = new PriorityQueue(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (isEven) {
            right.add(num);
            left.add(right.poll());
            this.median = left.peek();
        } else {
            left.add(num);
            right.add(left.poll());
            median = (left.peek() + right.peek()) / 2.0;
        }
        isEven = !isEven;
    }
    
    public double findMedian() {
        return median;
    }
}
