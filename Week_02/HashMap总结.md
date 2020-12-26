#### 1. 简单说明
- HashMap 是根据键的hashCode值存储数据，在理想情况下（不发生hash冲突），根据键访问数据很快，时间复杂度为O(1)；
- 哈希表，处理哈希冲突的方式有俩个：链表法、开放寻址法。HashMap 使用的是链表法；
- 遍历顺序不确定；
- 键允许为null，值允许为null；
- 非线程安全，某一时刻，多个线程对HashMap进行写操作，可能会导致数据不一致、死循环等问题；
- 若在并发场景下使用HashMap，则可以使用工厂方法 Collections # synchronizeMap 赋予 HashMap 线程安全的能力，或者使用JUC ConcurentHashMap 来替代；

#### 2. 存储
从结构来说，HashMap是数组 + 链表 + 红黑树（JDK 1.8 新增红黑树）
- Node[] table，哈希桶数组，实现了Map.Entry，本质上是一个键值对；
```
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;
...
}
```
- 使用哈希表来存储，HashMap 使用链表法来解决哈希冲突；
插入数据时，结合 key # hashCode 和 HashMap # hash 得到 hash值，通过hash值，定位对应哈希桶；
若俩个不同的key定位到相同的哈希桶，即这俩个key发生了哈希碰撞；
哈希碰撞发生后，HashMap会使用链表法处理，即在冲突哈希桶下，以链表的形式存储数据，当链表长度大于8时，会将链表转换成红黑树；
若哈希桶很大，即使较差的hash算法也会比较分散，若哈希桶很小，即使好的hash算法，也会经常出现hash碰撞，并且随着数据的增加，碰撞的概率也会提升，随着哈希碰撞的发生，链表也会越来越长，极端情况下性能会退化成链表。为了解决此问题，HashMap使用较好的hash算法和扩容机制；
- 良好的hash算法和扩容机制；
Node[] table 初始长度为16，load factor负载因子为0.75，threshold最大数据量Node的个数 = table.length * load factor，threshold会在HashMap构造和扩容resize时，重新计算；
负载因子默认0.75，对空间和时间效率的平衡选择，一般情况下，不用修改。发生扩容时，table长度会翻倍。若空间多且时间敏感，可以降低；若内存空间紧张且时间不敏感，可以提高，甚至大于1；
哈希桶table的长度大小必须为2^n，主要为了取模和扩容时做优化。













