<p>字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入:</strong> s = "abcdefg", k = 2
<strong>输出:&nbsp;</strong>"cdefgab"
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入:</strong> s = "lrloseumgh", k = 6
<strong>输出:&nbsp;</strong>"umghlrlose"
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt; s.length &lt;= 10000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数学 | 双指针 | 字符串</details><br>

<div>👍 414, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题没啥难度，只要注意一下不同编程语言底层的字符串实现原理（可变/不可变）即可。

**标签：字符串**

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
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution {
public:
    string reverseLeftWords(string s, int n) {
        return s.substr(n) + s.substr(0, n);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def reverseLeftWords(self, s: str, n: int) -> str:
        return s[n:] + s[:n]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func reverseLeftWords(s string, n int) string {
    return s[n:] + s[:n]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {string} s
 * @param {number} n
 * @return {string}
 */
var reverseLeftWords = function(s, n) {
    return s.substring(n) + s.substring(0, n);
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_zuo-xuan-zhuan-zi-fu-chuan-lcof" data="G/8MABwHdmPXQmtcKb4MZy0CssP1x7z603WOi0HADzIfgdr0tcP10jXy4SFHxYdfv98rswN0J8pk4v5kfGQmxv3dvdkgwKMQOoS2MsJWq2rXRTxnpeKfcciVAc0bMG797kkl/FmLgS8MPGXMDSgHEWJdb0B/DjNjTPgf/tk4VG3czJmwPhRxk0GncqOvXBu9JRQkRlfyxA9LKcAYqm4DwMgff0s21wLZxAwGlA2qb9qdL1J649nXd4+bTjTHzSfSHrzoiFTzyydcdU8BlSowjc0GSD8EDPW5oD/1qVuhqnqQ/lqLn2BE5hjRurFtbPGX7YdcdOYCge9IXkBUCu6c2VDu6fmVrxlzAsE3UC58FfjBsZZAVQGuCrGv0fJczS7iK4wLyx6Nmnxn5P+ldheDGioXi+NZqfzzgwiSEjsw8yJuiavd9WxuIkWqxK45gY1L5U9brm6kxAe2GPgniE6eprrSLAyxaQwkgchx/Cn2Xfc7+67ASZ2WDS+Bhe66uyixePblhAWwnjF6aTRXcTo1hRAqur5v9bLJ2wMdjd+gPf4SlBXnXDM8WNdShuOpNT4VrGO0VG2wmA2DeEaa4c2kavbfXzzLo+UMCk0x68ln4VikCb/20Ti2aKHG9KJECViEIyooVS50pxle3lomhFStUNIkOnOBQG3zLBmUXPNQM2gvqWZcVi0wqUhC0aEdCCG7wCqhQzvA4TGeAuPWOpSwNIuqoTyHbKbhLo0yfwN29nyCKz2W5P87VblCe37H108vC3x9Z4ECPgqC9VZQQsIOx5lqNxZ7Cbv2Iqo+mhfzihtWwwGF8Ij+8LXCThkpfK1v6eSX8Dk58ilQvgmLMq9SlF0IzB2lbex9UJJ/LUvFJYXK3Asyxs5jiWInXH0IhqoC8SzhnzxudphiIIe3kzB0Pqq5dWRoNtcRJUKnvSxyc50YYVNTCNECzu39IPve2gmCnxdUhVGd8XRc5yufY4bYgsKE125jbE40ER3URm+2cuGdPbtyflHlBiKVuZyr5vg0lv3oswo2BG0uh2phZC6xDgK3mZ9MQuZM+MYQQ5V9Xz+9hJfyDz50im6vGVzfWewzAprSQytaBEzNwUlwXBvcmoW8aQ9gSNkPiOJLCsJiLuXOun3mF8THGc076jPxVASGmlidTBRHa7RAhiCX8XS1mhgag6QTLfqq36ZwbPS893t0pwtQp8Fdgtf+9jbqbt2UrO9w45Xy6QJl3impItP8ywohjOvsZPbgR6jqq+jRHTdtQRJfCIgFiUQpFa4GVxjXKJNjoMaOXrR4O5/BcVdzzex//6PbKM9rOO70YCUaK1ZU3mz4q+4Wd/9fnnyXv1tHBgd86cjUfCaOp2QmOhTMc+dmDzGfwEGsbwA="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_zuo-xuan-zhuan-zi-fu-chuan-lcof"></div></div>
</details><hr /><br />

</details>
</div>



