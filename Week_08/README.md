### 学习笔记

#### 初级排序代码
```
/**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    /**
     * 插入排序
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = i + 1; j >= 1 && arr[j - 1] > arr[j]; j--) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    /**
     * 计数排序
     */
    public static void countSort(int[] arr, int max) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length && i < arr.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }

    /**
     * 基数排序
     */
    public static void radixSort(int[] arr, int maxDigit) {
        if (arr == null || arr.length <= 1 || maxDigit < 1) {
            return;
        }
        List<Deque<Integer>> data = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            data.add(new LinkedList<>());
        }
        for (int dig = 1; dig <= maxDigit; dig++) {
            int d = 1;
            for (int i = 1; i < dig; i++) {
                d *= 10;
            }
            for (int i = 0; i < arr.length; i++) {
                int dig0 = arr[i] / d % 10;
                data.get(dig0).add(arr[i]);
            }
            for (int i = 0, p = 0; i < 10; i++) {
                while (!data.get(i).isEmpty()) {
                    arr[p++] = data.get(i).pop();
                }
            }
        }
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // heapify
            int len = arr.length - i;
            int half = len >>> 1;
            for (int j = half - 1; j >= 0; j--) {
                int max = arr[j];
                int k = j;
                while (k < half) {
                    int child = (k << 1) + 1;
                    int right = child + 1;
                    if (right < len && arr[child] < arr[right]) {
                        child = right;
                    }
                    if (arr[child] < max) {
                        break;
                    }
                    arr[k] = arr[child];
                    k = child;
                }
                arr[k] = max;
            }
            // swap
            int temp = arr[0];
            arr[0] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    /**
     * 快排
     */
    public static void quickSort(int[] arr, int begin, int end) {
        if (arr == null || begin >= end) {
            return;
        }
        int partition = end;
        int right = begin;// 最小右界
        for (int i = begin; i < end; i++) {
            if (arr[partition] > arr[i]) {
                int temp = arr[right];
                arr[right] = arr[i];
                arr[i] = temp;
                right++;
            }
        }
        int temp = arr[right];
        arr[right] = arr[partition];
        arr[partition] = temp;

        quickSort(arr, begin, right - 1);
        quickSort(arr, right + 1, end);
    }

    /**
     * 归并
     */
    public static void mergeSort(int[] arr, int begin, int end) {
        if (arr == null || begin >= end) {
            return;
        }
        int mid = begin + ((end - begin) >> 1);
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);

        int[] temp = new int[end - begin + 1];
        for (int i = begin; i <= end; i++) {
            temp[i - begin] = arr[i];
        }
        for (int i = begin, left = begin, right = mid + 1; i <= end; i++) {
            arr[i] = right > end || (left <= mid && temp[left - begin] < temp[right - begin]) ? temp[-begin + left++] : temp[-begin + right++];
        }
    }
```