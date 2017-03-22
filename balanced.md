Write a program to determine if the the parentheses (),
the brackets [], and the braces {}, in a string are balanced.

For example:

{{)(}} is not balanced because ) comes before (

({)} is not balanced because ) is not balanced between {}
     and similarly the { is not balanced between ()

[({})] is balanced

{}([]) is balanced

{()}[[{}]] is balanced

## 解题原理
这个问题是一个栈的进出问题：

1. 如果碰到一个左边元素，就添加到栈中；
2. 如果读取到一个右边元素，那么检查当前栈顶元素;
3. 如果当前的栈顶元素和右边元素不匹配，那么整体就不是balanced
4. 如果当前的栈顶元素和右边元素匹配，那么组成一组，继续往下进行
