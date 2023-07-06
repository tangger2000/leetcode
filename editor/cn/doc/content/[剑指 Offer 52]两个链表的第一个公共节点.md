<p>输入两个链表，找出它们的第一个公共节点。</p>

<p>如下面的两个链表<strong>：</strong></p>

<p><a href="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png" target="_blank"><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png" style="height: 130px; width: 400px;" /></a></p>

<p>在节点 c1 开始相交。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png" target="_blank"><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_1.png" style="height: 130px; width: 400px;" /></a></p>

<pre><strong>输入：</strong>intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
<strong>输出：</strong>Reference of the node with value = 8
<strong>输入解释：</strong>相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
</pre>

<p>&nbsp;</p>

<p><strong>示例&nbsp;2：</strong></p>

<p><a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png" target="_blank"><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_2.png" style="height: 136px; width: 350px;" /></a></p>

<pre><strong>输入：</strong>intersectVal&nbsp;= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
<strong>输出：</strong>Reference of the node with value = 2
<strong>输入解释：</strong>相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
</pre>

<p>&nbsp;</p>

<p><strong>示例&nbsp;3：</strong></p>

<p><a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png" target="_blank"><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_3.png" style="height: 126px; width: 200px;" /></a></p>

<pre><strong>输入：</strong>intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
<strong>输出：</strong>null
<strong>输入解释：</strong>从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
<strong>解释：</strong>这两个链表不相交，因此返回 null。
</pre>

<p>&nbsp;</p>

<p><strong>注意：</strong></p>

<ul> 
 <li>如果两个链表没有交点，返回 <code>null</code>.</li> 
 <li>在返回结果后，两个链表仍须保持原有的结构。</li> 
 <li>可假定整个链表结构中没有循环。</li> 
 <li>程序尽量满足 O(<em>n</em>) 时间复杂度，且仅用 O(<em>1</em>) 内存。</li> 
 <li>本题与主站 160 题相同：<a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">https://leetcode-cn.com/problems/intersection-of-two-linked-lists/</a></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 链表 | 双指针</details><br>

<div>👍 659, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [160. 相交链表](/problems/intersection-of-two-linked-lists) 相同。

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 64 页。

这题难点在于，由于两条链表的长度可能不同，两条链表之间的节点无法对应：

![](https://labuladong.github.io/pictures/链表技巧/5.jpeg)

如果用两个指针 `p1` 和 `p2` 分别在两条链表上前进，并不能**同时**走到公共节点，也就无法得到相交节点 `c1`。

**解决这个问题的关键是，通过某些方式，让 `p1` 和 `p2` 能够同时到达相交节点 `c1`**。

如果用两个指针 `p1` 和 `p2` 分别在两条链表上前进，我们可以让 `p1` 遍历完链表 `A` 之后开始遍历链表 `B`，让 `p2` 遍历完链表 `B` 之后开始遍历链表 `A`，这样相当于「逻辑上」两条链表接在了一起。

如果这样进行拼接，就可以让 `p1` 和 `p2` 同时进入公共部分，也就是同时到达相交节点 `c1`：

![](https://labuladong.github.io/pictures/链表技巧/6.jpeg)

另一种思路，先计算两条链表的长度，然后让 `p1` 和 `p2` 距离链表尾部的距离相同，然后齐头并进，

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
    ListNode* getIntersectionNode(ListNode* headA, ListNode* headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode* p1 = headA;
        ListNode* p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == nullptr) {
                p1 = headB;
            } else {
                p1 = p1->next;
            }
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == nullptr) {
                p2 = headA;
            } else {
                p2 = p2->next;
            }
        }
        return p1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # p1 指向 A 链表头结点，p2 指向 B 链表头结点
        p1, p2 = headA, headB
        while p1 != p2:
            # p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if p1 == None:
                p1 = headB
            else:
                p1 = p1.next
            # p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if p2 == None:
                p2 = headA
            else:
                p2 = p2.next
        return p1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func getIntersectionNode(headA, headB *ListNode) *ListNode {
    // p1 指向 A 链表头结点，p2 指向 B 链表头结点
    p1, p2 := headA, headB
    for p1 != p2 {
        // p1 走一步，如果走到 A 链表末尾，转到 B 链表
        if p1 == nil {
            p1 = headB
        } else {
            p1 = p1.Next
        }
        // p2 走一步，如果走到 B 链表末尾，转到 A 链表
        if p2 == nil {
            p2 = headA
        } else {
            p2 = p2.Next
        }
    }
    return p1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var getIntersectionNode = function(headA, headB) {
    // p1 指向 A 链表头结点，p2 指向 B 链表头结点
    let p1 = headA, p2 = headB;
    while (p1 != p2) {
        // p1 走一步，如果走到 A 链表末尾，转到 B 链表
        if (p1 == null) {
            p1 = headB;
        } else {
            p1 = p1.next;
        }
        // p2 走一步，如果走到 B 链表末尾，转到 A 链表
        if (p2 == null) {
            p2 = headA;
        } else {
            p2 = p2.next;
        }
    }
    return p1;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_intersection-of-two-linked-lists" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_intersection-of-two-linked-lists"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [1650. 二叉树的最近公共祖先 III 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-iii)
  - [19. 删除链表的倒数第 N 个结点 🟠](/problems/remove-nth-node-from-end-of-list)
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



