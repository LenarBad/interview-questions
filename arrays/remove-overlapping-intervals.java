class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] -b[1]);
        int count = -1;
        int[] cur = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] < cur[1]) {
                count++;
            } else {
                cur = interval;
            }
        }
        return count;
    }
}
