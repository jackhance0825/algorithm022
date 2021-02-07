class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        quickSort(sArr, 0, sArr.length - 1);
        quickSort(tArr, 0, tArr.length - 1);
        return Arrays.equals(sArr, tArr);
    }

    private void quickSort(char[] arr, int begin, int end) {
        if(arr == null || begin >= end) return;
        int partition = end;
        int right = begin;
        for(int i = begin; i < end; i++) {
            if(arr[i] < arr[partition]) {
                swap(arr, i, right++);
            }
        }
        swap(arr, partition, partition = right);

        quickSort(arr, begin, partition - 1);
        quickSort(arr, partition + 1, end);
    }

    private void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}