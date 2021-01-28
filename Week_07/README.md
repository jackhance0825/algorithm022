#### 学习笔记

##### Two-End BFS 代码模板
```
public int twoEndBFS(String start, String end, Set<String> words) {
	// 校验参数
	checkArgs();
	// 移除起点&终点
	words.remove(start);
	words.remove(end)
	// 创建双向BFS的容器，用于记录每一层状态
	Set<String> begins = new HashSet<>();
	Set<String> ends = new HashSet<>();
	begins.add(start);
	ends.add(end);
	int step = 1;// 起始步数
	while(!begins.isEmpty() && !ends.isEmpty()) {
		// 优先扩散状态空间更小的一端
		if(begins.size() > ends.size()) {
			Set<String> temp = begins;
			begins = ends;
			ends = temp;
		}
		Set<String> temp = new HashSet<>();// 记录下一层状态
		for(String s : begins) {
			char[] ch = s.toCharArray();
			for(int i = 0; i < ch.length; i++) {
				char c = ch[i];
				for(char m : mutas) {
					if(m == c) continue;// 与当前状态一致，跳过
					ch[i] = m;
					String str = new String(ch);
					if(ends.contains(str)) return step;// 触碰到另一端，返回
					if(!words.contains(str)) continue;// 下一状态是否在状态库中
					temp.add(str);
				}
				ch[i] = c;
			}
		}
		words.removeAll(begins = temp);// 移除下一层状态
		step++;
	}
	return -1;
}
```