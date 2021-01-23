使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

#### 约定：
- 数组不存在重复元素
- 数组中间一定存在无序的地方，这里约定无序的地方为旋转点
- 数组数值升序，即旋转点为最小值

#### 代码
```
public int findMin(int[] nums) {
	int left = 0;
	int right = nums.length - 1;
	while(left < right) {
		int mid = left + (right - left) / 2;
		if(nums[mid] < nums[left]) {// mid < left,即左区域存在旋转点
			right = mid;
		} else {// mid >= left，即左区域升序
			if(nums[right] > nums[left]) {// [left, right]升序，left为最小值(即旋转点)
				right = left;
			} else {// 右区域存在旋转点
				left = left == mid ? right : mid;
			}
		}
	}
	return nums[left];
}
```
