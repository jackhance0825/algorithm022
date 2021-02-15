class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i += 2 * k) {
            reverseStr(arr, i, i + k - 1 >= s.length() ? s.length() - 1 : i + k - 1);
        }
        return new String(arr);
    }

    private void reverseStr(char[] arr, int s, int e) {
        if(s >= e) return;
        int m = (e - s) >> 1;
        for(int i = 0; i <= m; i++) {
            char temp = arr[i + s];
            arr[i + s] = arr[e - i];
            arr[e - i] = temp;
        }
    }
}