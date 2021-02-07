class Solution {
    /**
    * Quick Sort 
    * TimeComplexity: O(nlogn)
    */
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 1) return intervals;
        quickSort(intervals, 0, intervals.length - 1);
        List<int[]> res = new ArrayList<>(intervals.length);
        int s = intervals[0][0];
        int e = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > e) {
                res.add(new int[]{s, e});
                s = intervals[i][0];
                e = intervals[i][1];
            } else {
                e = e > intervals[i][1] ? e : intervals[i][1];
            }
            if(i == intervals.length - 1) res.add(new int[]{s, e});
        }
        int[][] arr = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void quickSort(int[][] data, int begin, int end) {
        if(begin >= end) return;
        int partition = end;
        int right = begin;
        for(int i = begin; i < end; i++) {
            if(data[i][0] < data[partition][0]) swap(data, i, right++);
        }
        swap(data, partition, partition = right);

        quickSort(data, begin, partition - 1);
        quickSort(data, partition + 1, end);
    }

    private void swap(int[][] data, int a, int b) {
        int[] temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}