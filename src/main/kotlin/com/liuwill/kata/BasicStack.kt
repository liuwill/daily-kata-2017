package com.liuwill.kata

/**
 * Created by LiuWill on 2017/3/30.
 */
class BasicStack<T>(length: Int) {
    private var balanceStack: Array<Any?> = emptyArray()

    var top: Int = 0

    fun push(input: T) {
        balanceStack[top] = input
        top++
    }

    @Suppress("UNCHECKED_CAST")
    fun pop(): T {
        if (top == 0) {
            throw IndexOutOfBoundsException()
        }

        val topItem = balanceStack[--top]
        return topItem as T
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
        balanceStack = arrayOfNulls<Any>(length)
    }
}