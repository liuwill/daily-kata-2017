package com.liuwill.kata.NumberNames

/**
 * Created by videopls on 2017/3/30.
 */
class NumberNamesUtils {
    fun getString(expect: Int): String {
        return expect.toString()
    }

    fun getArray(expect: Int): Array<Char?> {
        val rawExpect = expect.toString().toCharArray()
        val result = arrayOfNulls<Char>(rawExpect.size)

        var i = 0
        for(item in rawExpect){
            result[i++] = item
        }
        return result
    }

    fun transformDigits(inputs: Array<Char?>):String{
        if (inputs.size > 3 || inputs.isEmpty()){
            throw IndexOutOfBoundsException()
        }

        var result = ""
        var startIndex = 0
        var hundredMark = false
        if(inputs.size == 3 && inputs[0] != '0'){
            val hundredBit = inputs[0]!! - '0'
            val hundredStr = NumberNames.BITS_MAP[hundredBit]

            hundredMark = true
            startIndex++

            result += hundredStr + " hundred "
        }

        var leftBitsStr = ""
        for( i in startIndex..inputs.size-1 ){
            leftBitsStr += inputs[i]
        }

        val rightBit = leftBitsStr.toInt()
        if(rightBit > 0){
            if(hundredMark){
                result += "and "
            }

            if(rightBit > 19){
                val tenBitsStr = NumberNames.TENS_MAP[inputs[1]!!-'0']
                result += tenBitsStr

                if(inputs[2] != '0'){
                    result += " " + NumberNames.BITS_MAP[inputs[2]!!-'0']
                }
            }else{
                result += NumberNames.BITS_MAP[rightBit]
            }
        }

        return result.trim()
    }
}