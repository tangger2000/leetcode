<p>定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL
<strong>输出:</strong> 5-&gt;4-&gt;3-&gt;2-&gt;1-&gt;NULL</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= 节点个数 &lt;= 5000</code></p>

<p>&nbsp;</p>

<p><strong>注意</strong>：本题与主站 206 题相同：<a href="https://leetcode-cn.com/problems/reverse-linked-list/">https://leetcode-cn.com/problems/reverse-linked-list/</a></p>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>

<div>👍 602, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=fan-zhuan-lian-biao-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [206. 反转链表](/problems/reverse-linked-list) 相同。

递归实现反转链表常常用来考察递归思想，我这里就用纯递归来翻转链表。

**对于递归算法，最重要的就是明确递归函数的定义**。具体来说，我们的 `reverse` 函数定义是这样的：

**输入一个节点 `head`，将「以 `head` 为起点」的链表反转，并返回反转之后的头结点**。

明白了函数的定义，再来看这个问题。比如说我们想反转这个链表：

![](https://labuladong.github.io/pictures/反转链表/1.jpg)

那么输入 `reverse(head)` 后，会在这里进行递归：

```java
ListNode last = reverse(head.next);
```

不要跳进递归（你的脑袋能压几个栈呀？），而是要根据刚才的函数定义，来弄清楚这段代码会产生什么结果：

![](https://labuladong.github.io/pictures/反转链表/2.jpg)

这个 `reverse(head.next)` 执行完成后，整个链表就成了这样：

![](https://labuladong.github.io/pictures/反转链表/3.jpg)

并且根据函数定义，`reverse` 函数会返回反转之后的头结点，我们用变量 `last` 接收了。

现在再来看下面的代码：

```java
head.next.next = head;
```

![](https://labuladong.github.io/pictures/反转链表/4.jpg)

接下来：

```java
head.next = null;
return last;
```

![](https://labuladong.github.io/pictures/反转链表/5.jpg)

神不神奇，这样整个链表就反转过来了！

**详细题解：[递归魔法：反转单链表](https://labuladong.github.io/article/fname.html?fname=递归反转链表的一部分)**

**标签：单链表**

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
    ListNode* reverseList(ListNode* head) {
        // 如果链表为空或只有一个节点，则直接返回该链表
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        ListNode* last = nullptr;
        // 开始迭代翻转节点
        while (head != nullptr) {
            // 先保存当前节点的后继节点
            ListNode* next = head->next;
            // 将当前节点的指针指向前一个节点
            head->next = last;
            // 更新前一个节点为当前节点
            last = head;
            // 更新当前节点为后继节点
            head = next;
        }
        // 翻转链表完成，返回头节点
        return last;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        # 如果链表为空或链表只有一个元素，则直接返回head
        if head == None or head.next==None:
            return head
        # 递归反转链表后面的部分
        last = self.reverseList(head.next)
        """
        反转之前的链表
        head      --> 3 --> 4 --> 5 --> null
        last      --> 5 --> null
        """
        # 将链表的下一个节点的后继指针指向当前节点
        head.next.next = head
        """
        反转之后的链表
        last      --> 5 --> 4 --> 3 --> null
                          ↑
        head      --> 4 ---┘
        """
        # 将当前节点的后继指针指向null
        head.next = None
        """
        反转之后的链表
        last      --> 5 --> 4 --> 3 --> null
        head      --> null
        """
        # 返回反转后的链表
        return last
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/3.jpg) */
        head.next.next = head;/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/4.jpg) */
        head.next = null;/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/5.jpg) */
        return last;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reverseList(head *ListNode) *ListNode {
    // 如果链表为空或者链表只有一个节点，直接返回head
    if head == nil || head.Next == nil {
        return head
    }
    // 递归处理下一个节点
    last := reverseList(head.Next)
    // 对于当前节点：
    // 原来指向下一个节点的指针反转指向上一个节点
    head.Next.Next = head
    // 原来指向下一个节点的指针指向nil
    head.Next = nil
    // 返回链表的最后一个节点，即反转后链表的头节点
    return last
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
  if (head === null || head.next === null) {
    return head;
  }
  var last = reverseList(head.next);/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/3.jpg) */
  head.next.next = head;/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/4.jpg) */
  head.next = null;/**<extend up -200>![](https://labuladong.github.io/pictures/反转链表/5.jpg) */
  return last;
};
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_reverse-linked-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reverse-linked-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [92. 反转链表 II 🟠](/problems/reverse-linked-list-ii)
  - [剑指 Offer 24. 反转链表 🟢](/problems/fan-zhuan-lian-biao-lcof)
  - [剑指 Offer II 024. 反转链表 🟢](/problems/UHnkqh)

</details>
</div>



