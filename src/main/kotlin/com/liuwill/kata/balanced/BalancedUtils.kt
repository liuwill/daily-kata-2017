package com.liuwill.kata.balanced

/**
 * Created by videopls on 2017/3/18.
 */
class BalancedUtils {
    val BRACKET_ELEMENT = "{}[]()"
    val LEFT_BRACKET_ELEMENT = "{[("
    val RIGHT_BRACKET_ELEMENT = "}])"
    companion object{
        val LEFT_BRACE='{'
        val RIGHT_BRACE='}'
        val LEFT_BRACKET='['
        val RIGHT_BRACKET=']'
        val LEFT_PARENTHESES='('
        val RIGHT_PARENTHESES=')'
    }

    fun isLeagueInput(input:Char):Boolean{
        return BRACKET_ELEMENT.contains(input)
    }

    fun isLeft(input:Char):Boolean{
        return LEFT_BRACKET_ELEMENT.contains(input)
    }

    fun compareElementBalance(left: Char, right: Char): Boolean {
        if(!isLeagueInput(left) || !isLeagueInput(right)){
            return false
        }
        return BRACKET_ELEMENT.contains(left.toString()+right) && BRACKET_ELEMENT.indexOf(left)%2==0
    }

    fun compute(rawStr :String) :Int{
        var balanceStack = BalancedStack(rawStr.length)
        /*val count = (0..rawStr.length-1)
                .map { rawStr[it] }
                .count { isLeft(it) }*/
        var realCount = 0

        for(i in 0..rawStr.length-1){
            val chr = rawStr[i]
            if(isLeft(chr)){
                balanceStack.push(chr)
            }else if(!isLeft(chr)){
                if(balanceStack.size()<1){
                    return 0
                }

                val left:Char = balanceStack.pop()!!
                if(compareElementBalance(left,chr)){
                    realCount++
                }else{
                    return 0
                }
            }
        }
        return realCount
    }
}