package com.liuwill.kata.numbernames

/**
 * Created by LiuWill on 2017/3/30.
 */
class NumberNamesUtils {
    fun getString(expect: Int): String {
        return expect.toString()
    }

    fun getArray(expect: Int): Array<Char?> {
        val rawExpect = expect.toString().toCharArray()
        val result = arrayOfNulls<Char>(rawExpect.size)

        var i = 0
        for (item in rawExpect) {
            result[i++] = item
        }
        return result
    }

    fun transformDigits(inputs: Array<Char?>): String {
        if (inputs.size > 3 || inputs.isEmpty()) {
            throw IndexOutOfBoundsException()
        }

        var result = ""
        var startIndex = 0
        var hundredMark = false
        if (inputs.size == 3 && inputs[0] != '0') {
            val hundredBit = inputs[0]!! - '0'
            val hundredStr = NumberNames.BITS_MAP[hundredBit]

            hundredMark = true
            startIndex++

            result += hundredStr + " hundred "
        }

        var leftBitsStr = ""
        for (i in startIndex..inputs.size - 1) {
            leftBitsStr += inputs[i]
        }

        val rightBit = leftBitsStr.toInt()
        if (rightBit > 0) {
            if (hundredMark) {
                result += "and "
            }

            val leftArr = leftBitsStr.toCharArray()
            if (rightBit > 19) {
                val tenBitsStr = NumberNames.TENS_MAP[leftArr[0]!! - '0']
                result += tenBitsStr

                if (leftArr[1] != '0') {
                    result += " " + NumberNames.BITS_MAP[leftArr[1]!! - '0']
                }
            } else {
                result += NumberNames.BITS_MAP[rightBit]
            }
        }

        return result.trim()
    }

    fun spellNumberName(input: Int): String {
        val inputArr = splitNumber(input)
        var resultArr = arrayOfNulls<String>(inputArr.size)

        var cur = 0
        for (i in 0..inputArr.size - 1) {
            val it = inputArr.size - 1 - i
            val item = inputArr[it]

            var numStr = transformDigits(getArray(item!!.toInt()))
            if (cur > 0) {
                val curStr = NumberNames.SPACE_MAP[cur]
                numStr = "$numStr $curStr"
            }
            resultArr[it] = numStr
            cur++
        }

        return resultArr.joinToString(", ")
    }

    fun splitNumber(input: Int): Array<String?> {
        val rawString = input.toString()
        val rawLength = rawString.length
        if (rawLength < 3) {
            return arrayOf(rawString)
        }
        val realLength = Math.ceil(rawLength.toDouble() / 3).toInt()

        val targetArr = arrayOfNulls<String>(realLength)
        var endIndex = rawLength
        for (i in 0..realLength - 1) {
            val it = realLength - 1 - i

            var startIndex = endIndex - 3
            if (startIndex < 0) {
                startIndex = 0
            }

            val theStr = rawString.substring(startIndex, endIndex)
            targetArr[it] = theStr

            endIndex -= 3
            if (endIndex < 0) {
                break
            }
        }

        return targetArr
    }
}