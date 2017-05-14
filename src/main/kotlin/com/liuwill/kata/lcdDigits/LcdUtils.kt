package com.liuwill.kata.lcdDigits

/**
 * Created by videopls on 2017/3/26.
 */
class LcdUtils {
    fun encode(source: Char): Array<CharArray> {
        val pos:Int = source - LcdDigits.BASE_DIGIT

        if(pos > 9 || pos < 0){
            throw IllegalArgumentException()
        }

        return LcdDigits.DIGIT_DICT[pos]
    }

    fun compare(first:Array<CharArray>,second:Array<CharArray>):Boolean{
        if(first == null || second == null){
            return false
        }else if(first.size != second.size){
            return false
        }

        for(i in 0..(first.size-1)){
            if(first[i].size != second[i].size){
                return false
            }

            /*for(j in 0..(first[i].size-1)){
                if(first[i][j] != second[i][j]){
                    return false
                }
            }*/
            (0..(first[i].size-1))
                .filter { first[i][it] != second[i][it] }
                .forEach { return false }
        }
        return true
    }

    fun printDigit(input:Array<CharArray>):String{
        var result = ""
        if(input.isEmpty()){
            return result
        }

        var count = 1
        for(col in input){
            for(digit in col){
                result += digit
            }

            if(count < input.size){
                result += "\n"
            }

            count++
        }
        return result
    }

    fun parse(input:String): Array<Array<CharArray>?> {
        val inputCharArr = input.toCharArray()

        var resultArr = arrayOfNulls<Array<CharArray>>(inputCharArr.size)
        inputCharArr
            .map { encode(it) }
            .forEachIndexed { i, singleResult -> resultArr[i] = singleResult }
        /*var i = 0
        for(singleNum in inputCharArr){
            val singleResult = encode(singleNum)
            resultArr[i++] = singleResult
        }*/
        return resultArr
    }

    fun print(input: Array<Array<CharArray>?>, space:Int = 1):String{
        var resultArr = arrayOf(
            "","",""
        )

        var count = 1
        for(top in input){

            for((i, chars) in top!!.withIndex()){
                var curStr = resultArr[i]
                for(item in chars){
                    curStr += item
                }
                if(count < input.size){
                    (0..space-1).forEach {
                        curStr += LcdDigits.BLANK_STR
                    }
                }

                resultArr[i] = curStr

            }
            count++
        }
        return resultArr.joinToString("\n")
    }
}