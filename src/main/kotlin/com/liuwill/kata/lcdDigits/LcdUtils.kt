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

            for(j in 0..(first[i].size-1)){
                if(first[i][j] != second[i][j]){
                    return false
                }
            }
        }
        return true
    }

    fun printDigit(input:Array<CharArray>):String{
        var result = ""
        if(input == null || input.size<1){
            return result
        }

        for(col in input){
            for(digit in col){
                result += digit
            }
            result += "\n"
        }
        return result
    }

    fun parse(input:String): Array<Array<CharArray>?> {
        val inputCharArr = input.toCharArray()

        var resultArr = arrayOfNulls<Array<CharArray>>(inputCharArr.size)
        var i = 0
        for(singleNum in inputCharArr){
            val singleResult = encode(singleNum)
            resultArr[i++] = singleResult
        }
        return resultArr
    }

    fun print(input: Array<Array<CharArray>?>, space:Int = 1):String{
        var resultArr = arrayOf(
            "","",""
        )

        var count = 1
        for(top in input){
            var i = 0

            for(chars in top!!){
                var curStr = resultArr[i]
                for(item in chars){
                    curStr += item
                }
                if(count < input.size){
                    for(it in 0..space-1){
                        curStr += LcdDigits.BLANK_STR
                    }
                }
                resultArr[i] = curStr

                i++
            }
            count++
        }
        return resultArr.joinToString("\n")
    }
}