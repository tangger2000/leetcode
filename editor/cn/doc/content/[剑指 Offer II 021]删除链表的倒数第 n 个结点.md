<p>给定一个链表，删除链表的倒数第&nbsp;<code>n</code><em>&nbsp;</em>个结点，并且返回链表的头结点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" /></p>

<pre>
<strong>输入：</strong>head = [1,2,3,4,5], n = 2
<strong>输出：</strong>[1,2,3,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = [1], n = 1
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1,2], n = 1
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中结点的数目为 <code>sz</code></li> 
 <li><code>1 &lt;= sz &lt;= 30</code></li> 
 <li><code>0 &lt;= Node.val &lt;= 100</code></li> 
 <li><code>1 &lt;= n &lt;= sz</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>能尝试使用一趟扫描实现吗？</p>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 19&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/">https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/</a></p>

<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>

<div>👍 79, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=SLwz0R" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [19. 删除链表的倒数第 N 个结点](/problems/remove-nth-node-from-end-of-list) 相同。

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 64 页。

要删除倒数第 `n` 个节点，就得获得倒数第 `n + 1` 个节点的引用。

获取单链表的倒数第 `k` 个节点，就是想考察 [双指针技巧](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中快慢指针的运用，一般都会要求你**只遍历一次链表**，就算出倒数第 `k` 个节点。

第一步，我们先让一个指针 `p1` 指向链表的头节点 `head`，然后走 `k` 步：

![](https://labuladong.github.io/pictures/链表技巧/1.jpeg)

第二步，用一个指针 `p2` 指向链表头节点 `head`：

![](https://labuladong.github.io/pictures/链表技巧/2.jpeg)

第三步，让 `p1` 和 `p2` 同时向前走，`p1` 走到链表末尾的空指针时走了 `n - k` 步，`p2` 也走了 `n - k` 步，也就是链表的倒数第 `k` 个节点：

![](https://labuladong.github.io/pictures/链表技巧/3.jpeg)

这样，只遍历了一次链表，就获得了倒数第 `k` 个节点 `p2`。

解法中在链表头部接一个虚拟节点 `dummy` 是为了避免删除倒数第一个元素时出现空指针异常，在头部加入 `dummy` 节点并不影响尾部倒数第 `k` 个元素是什么。

**详细题解：[双指针技巧秒杀七道链表题目](https://labuladong.github.io/article/fname.html?fname=链表技巧)**

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    // 主函数
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // 虚拟头结点
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode* x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x->next = x->next->next;
        return dummy->next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode* findFromEnd(ListNode* head, int k) {
        ListNode* p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1->next;
        }
        ListNode* p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != nullptr) {
            p2 = p2->next;
            p1 = p1->next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # 虚拟头结点
        dummy = ListNode(-1)
        dummy.next = head
        # 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        x = self.findFromEnd(dummy, n + 1)
        # 删掉倒数第 n 个节点
        x.next = x.next.next
        return dummy.next

    # 返回链表的倒数第 k 个节点
    def findFromEnd(self, head: ListNode, k: int) -> ListNode:
        p1 = head
        # p1 先走 k 步
        for i in range(k):
            p1 = p1.next
        p2 = head
        # p1 和 p2 同时走 n - k 步
        while p1:
            p2 = p2.next
            p1 = p1.next
        # p2 现在指向第 n - k 个节点
        return p2
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 主函数
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// removeNthFromEnd 主函数
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    // 虚拟头结点
    dummy := &ListNode{-1, head}
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    x := findFromEnd(dummy, n + 1)
    // 删掉倒数第 n 个节点
    x.Next = x.Next.Next
    return dummy.Next
}

// findFromEnd 返回链表的倒数第 k 个节点
func findFromEnd(head *ListNode, k int) *ListNode {
    p1 := head
    // p1 先走 k 步
    for i := 0; i < k; i++ {
        p1 = p1.Next
    }
    p2 := head
    // p1 和 p2 同时走 n - k 步
    for p1 != nil {
        p2 = p2.Next
        p1 = p1.Next
    }
    // p2 现在指向第 n - k 个节点
    return p2
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var removeNthFromEnd = function(head, n) {
    // 虚拟头结点
    var dummy = new ListNode(-1);
    dummy.next = head;
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    var x = findFromEnd(dummy, n + 1);
    // 删掉倒数第 n 个节点
    x.next = x.next.next;
    return dummy.next;
};

// 返回链表的倒数第 k 个节点
var findFromEnd = function(head, k) {
    var p1 = head;
    // p1 先走 k 步
    for (var i = 0; i < k; i++) {
        p1 = p1.next;
    }
    var p2 = head;
    // p1 和 p2 同时走 n - k 步
    while (p1 != null) {
        p2 = p2.next;
        p1 = p1.next;
    }
    // p2 现在指向第 n - k 个节点
    return p2;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_remove-nth-node-from-end-of-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-nth-node-from-end-of-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
  - [21. 合并两个有序链表 🟢](/problems/merge-two-sorted-lists)
  - [23. 合并K个升序链表 🔴](/problems/merge-k-sorted-lists)
  - [86. 分隔链表 🟠](/problems/partition-list)
  - [876. 链表的中间结点 🟢](/problems/middle-of-the-linked-list)
  - [剑指 Offer 22. 链表中倒数第k个节点 🟢](/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)
  - [剑指 Offer 25. 合并两个排序的链表 🟢](/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof)
  - [剑指 Offer 52. 两个链表的第一个公共节点 🟢](/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof)
  - [剑指 Offer II 021. 删除链表的倒数第 n 个结点 🟠](/problems/SLwz0R)
  - [剑指 Offer II 022. 链表中环的入口节点 🟠](/problems/c32eOV)
  - [剑指 Offer II 023. 两个链表的第一个重合节点 🟢](/problems/3u1WK4)
  - [剑指 Offer II 078. 合并排序链表 🔴](/problems/vvXgSW)

</details>
</div>



