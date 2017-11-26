> 使用Java语言实现，
> - [源代码](../src/main/kotlin/com/liuwill/kata/lcddigits)
> - [测试代码](../src/test/kotlin/com/liuwill/kata/test/LCDDigitsUtilsTest.kt)


## 打印LCD数字

Your task is to create an LCD string representation of an
integer value using a 3x3 grid of space, underscore, and 
pipe characters for each digit. Each digit is shown below 
(using a dot instead of a space)

```
._.   ...   ._.   ._.   ...   ._.   ._.   ._.   ._.   ._.
|.|   ..|   ._|   ._|   |_|   |_.   |_.   ..|   |_|   |_|
|_|   ..|   |_.   ._|   ..|   ._|   |_|   ..|   |_|   ..|

```

Example: 910
```
._. ... ._.
|_| ..| |.|
..| ..| |_|
```

# 解题思路：
先将每个数字存储成一个对应的三位数组，数组中有'.'、'_'、'|'三种符号。
每个数字都有用三种符号组成的形状。最后存储的结果也是一个三位数组，
在输出的时候，通过字符串连接就可以实现视觉输出

