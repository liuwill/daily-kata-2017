package com.liuwill.kata.balanced

/**
 * Created by videopls on 2017/3/22.
 */
class BalancedStack {
    var balanceStack:Array<Char?> = emptyArray()
    var top:Int = 0

    constructor(length: Int){
        Companion.maxLength = length
        balanceStack = arrayOfNulls<Char>(length)
    }

    fun push(input:Char){
        balanceStack[top] = input
        top++
    }

    fun pop():Char?{
        if(top == 0){
            return null
        }
        return balanceStack[--top]
    }

    fun size():Int{
        return top
    }

    fun length():Int{
        return Companion.maxLength
    }

    companion object {
        var maxLength:Int = 0
    }
}