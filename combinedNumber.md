## 待解问题
Write a function accepting a list of non negative integers, 
and returning their largest possible combined number
as a string. For example

given [50, 2, 1, 9] it returns "95021"    (9 + 50 + 2 + 1)
given [5, 50, 56]   it returns "56550"    (56 + 5 + 50)
given [420, 42, 423] it returns "42423420" (42 + 423 + 420)

This Cucumber environment is bundled with:
- JMock2
- Cucumber

## 解题思路：

本质上还是可以简化成一个排序问题，只需要按照特定的顺序排序之后，按顺序连接起来，就得到了需要的结果。

为了保证更可靠的实现目标，保证每个数字在组合的时候都是比之后的每个数字更合适的数字，可以采用堆排序过程来实现。

 1. 建立一个大根堆；
 2. 循环取出根结点，拼接到目标字符串的末尾；
 3. 每次取出一个节点之后，重新整理新堆。

实现的重点就是比较两个数字字符串，谁更加合适的算法，关键在于处理前缀都相同，然后从某一位开始一样时的比较