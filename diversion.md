## 待解问题

Think of binary numbers: sequences of 0's and 1's.
How many n-digit binary numbers are there that
don't have two adjacent 1 bits?

For example, for three-digit numbers, Five of the
possible eight combinations meet the criteria:

   000, 001, 010, 011, 100, 101, 110, 111.

What is the number for sequences of length 4, 5, 10, n?

Having worked out the pattern, there's a second part to
the question: can you prove why that relationship exists?

(Source http://codekata.pragprog.com,
 Code Kata Fifteen -- A Diversion)

## 解题思路

> 实际上结果是一组斐波那契数列

计算过程本质上是一个递归的过程，无论是多少位的二进制数，本质上可以分成1开头和0开头的两组，
两个组中每组数又可以分成同样0开头和1开头的两组，那么0开头的组，将会全部继承子组中的符合条件纪录数，
1开头的组中原来1开头的一半将被排除，0开头的一半符合条件的数量，与再少一位的子组的数量相同。

就相当于(x符合条件的数量)=(x-1的符合条件的数量)+(x-2的符合条件的数量)

0位和1位时的符合条件组合分别是1和2 (我们假设0位的话，也是不存在相邻的1的)

这样的话，任何长度的组合数都可以通过递归的方法算出符合条件的组合数

然后我们就可以通过算法和逐一检查的两个方法互相验证。