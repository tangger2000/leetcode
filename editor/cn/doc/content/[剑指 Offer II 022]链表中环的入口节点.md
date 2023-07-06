<p>给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 <code>next</code> 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回&nbsp;<code>null</code>。</p>

<p>为了表示给定链表中的环，我们使用整数 <code>pos</code> 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 <code>pos</code> 是 <code>-1</code>，则在该链表中没有环。<strong>注意，<code>pos</code> 仅仅是用于标识环的情况，并不会作为参数传递到函数中。</strong></p>

<p><strong>说明：</strong>不允许修改给定的链表。</p>

<ul> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png" style="height: 97px; width: 300px;" /></p>

<pre>
<strong>输入：</strong>head = [3,2,0,-4], pos = 1
<strong>输出：</strong>返回索引为 1 的链表节点
<strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png" style="height: 74px; width: 141px;" /></p>

<pre>
<strong>输入：</strong>head = [1,2], pos = 0
<strong>输出：</strong>返回索引为 0 的链表节点
<strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png" style="height: 45px; width: 45px;" /></p>

<pre>
<strong>输入：</strong>head = [1], pos = -1
<strong>输出：</strong>返回 null
<strong>解释：</strong>链表中没有环。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点的数目范围在范围 <code>[0, 10<sup>4</sup>]</code> 内</li> 
 <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li><code>pos</code> 的值为 <code>-1</code> 或者链表中的一个有效索引</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>是否可以使用 <code>O(1)</code> 空间解决此题？</p>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 142&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/linked-list-cycle-ii/">https://leetcode-cn.com/problems/linked-list-cycle-ii/</a></p>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 链表 | 双指针</details><br>

<div>👍 114, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 即将开始，最后 1 天报名！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=c32eOV" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [142. 环形链表 II](/problems/linked-list-cycle-ii) 相同。

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

基于 [141. 环形链表](/problems/linked-list-cycle) 的解法，直观地来说就是当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置。

原理也简单说下吧，我们假设快慢指针相遇时，慢指针 `slow` 走了 `k` 步，那么快指针 `fast` 一定走了 `2k` 步：

![](https://labuladong.github.io/pictures/双指针/3.jpeg)

`fast` 一定比 `slow` 多走了 `k` 步，这多走的 `k` 步其实就是 `fast` 指针在环里转圈圈，所以 `k` 的值就是环长度的「整数倍」。

假设相遇点距环的起点的距离为 `m`，那么结合上图的 `slow` 指针，环的起点距头结点 `head` 的距离为 `k - m`，也就是说如果从 `head` 前进 `k - m` 步就能到达环起点。

巧的是，如果从相遇点继续前进 `k - m` 步，也恰好到达环起点：

![](https://labuladong.github.io/pictures/双指针/2.jpeg)

所以，只要我们把快慢指针中的任一个重新指向 `head`，然后两个指针同速前进，`k - m` 步后一定会相遇，相遇之处就是环的起点了。

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
    ListNode *detectCycle(ListNode *head) {
        ListNode *fast, *slow;
        fast = slow = head;
        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
            if (fast == slow) break;/**<extend down -200>![](https://labuladong.github.io/pictures/双指针/3.jpeg) */
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == nullptr || fast->next == nullptr) {
            // fast 遇到空指针说明没有环
            return nullptr;
        }

        // 重新指向头结点
        slow = head;/**<extend up -100>![](https://labuladong.github.io/pictures/双指针/2.jpeg) */
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast->next;
            slow = slow->next;
        }
        return slow;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        fast, slow = head, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break # <extend down -200>![](https://labuladong.github.io/pictures/双指针/3.jpeg) #
        # 上面的代码类似 hasCycle 函数
        if not fast or not fast.next:
            # fast 遇到空指针说明没有环
            return None

        # 重新指向头结点
        slow = head # <extend up -100>![](https://labuladong.github.io/pictures/双指针/2.jpeg) #
        # 快慢指针同步前进，相交点就是环起点
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;/**<extend down -200>![](https://labuladong.github.io/pictures/双指针/3.jpeg) */
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }

        // 重新指向头结点
        slow = head;/**<extend up -100>![](https://labuladong.github.io/pictures/双指针/2.jpeg) */
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func detectCycle(head *ListNode) *ListNode {
    fast, slow := head, head
    for fast != nil && fast.Next != nil {
        fast = fast.Next.Next
        slow = slow.Next
        if fast == slow {
            break/**<extend down -200>![](https://labuladong.github.io/pictures/双指针/3.jpeg) */
        }
    }
    // 上面的代码类似 hasCycle 函数
    if fast == nil || fast.Next == nil {
        // fast 遇到空指针说明没有环
        return nil
    }

    // 重新指向头结点
    slow = head/**<extend up -100>![](https://labuladong.github.io/pictures/双指针/2.jpeg) */
    // 快慢指针同步前进，相交点就是环起点
    for slow != fast {
        fast = fast.Next
        slow = slow.Next
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var detectCycle = function(head) {
    let fast, slow;
    fast = slow = head;
    while (fast !== null && fast.next !== null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast === slow) break;/**<extend down -200>![](https://labuladong.github.io/pictures/双指针/3.jpeg) */
    }
    // 上面的代码类似 hasCycle 函数
    if (fast === null || fast.next === null) {
        // fast 遇到空指针说明没有环
        return null;
    }

    // 重新指向头结点
    slow = head;/**<extend up -100>![](https://labuladong.github.io/pictures/双指针/2.jpeg) */
    // 快慢指针同步前进，相交点就是环起点
    while (slow !== fast) {
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_linked-list-cycle-ii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_linked-list-cycle-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
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



