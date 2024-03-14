public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> counts = new HashMap();
    for (int num : nums) {
        counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> queue = 
            new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
        queue.add(entry);
        if (queue.size() > k) {
            queue.remove();
        }
    }

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
        result[i] = queue.poll().getKey();
    }
    return result;
}
