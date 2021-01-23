##### 学习笔记

#### 爬楼梯问题，爬行方法只能1和2间隔爬
比如：
1
1,2
1,2,1
2,1,2
求走到n台阶的方案数

#### 思路
f(n):
当n为偶数时，n % 3 == 0 ? f(n - 1) + 1 : f(n - 2) + 1
当n为奇数时，n % 3 == 2 ? f(n - 2) + 1 : f(n - 1) + 1

f(0) = 0
f(1) = 1

#### 代码
```
public int climbStairs(int n) {
	if(n <= 1) return n;
	int[] dp = new int[n + 1];
	dp[1] = 1;
	for(int i = 2; i <= n; i++) {
		if((i & 1) == 0) {
			dp[i] = i % 3 == 0 ? dp[i - 1] + 1 : dp[i - 2] + 1;
		} else {
			dp[i] = i % 3 == 2 ? dp[i - 2] + 1 : dp[i - 1] + 1;
		}
	}
	return dp[n];
}
``` 