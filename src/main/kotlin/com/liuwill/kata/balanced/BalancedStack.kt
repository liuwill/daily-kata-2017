package com.liuwill.kata.balanced

/**
 * Created by LiuWill on 2017/3/22.
 */
class BalancedStack(length: Int) {
    private var realBalanceStack: Array<Char?> = emptyArray()
    var balanceStack: Array<Char?>
        get() = this.realBalanceStack.clone()
        set(value) {
            this.realBalanceStack = value.copyOf()
        }

    var top: Int = 0

    fun push(input: Char) {
        realBalanceStack[top] = input
        top++
    }

    fun pop(): Char? {
        if (top == 0) {
            return null
        }
        return realBalanceStack[--top]
    }

    fun size(): Int {
        return top
    }

    fun length(): Int {
        return Companion.maxLength
    }

    companion object {
        var maxLength: Int = 0
    }

    init {
        Companion.maxLength = length
        realBalanceStack = arrayOfNulls<Char>(length)
    }
}