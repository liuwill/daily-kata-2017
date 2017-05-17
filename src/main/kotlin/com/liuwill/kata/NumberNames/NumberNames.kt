package com.liuwill.kata.NumberNames

/**
 * Created by LiuWill on 2017/3/30.
 */
class NumberNames {
    var bitsCount = 0
    var rawNumber = 0

    companion object{
        val BITS_MAP = arrayOf("","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen")
        val TENS_MAP = arrayOf("","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety")
        val SPACE_MAP = arrayOf("","thousand","million","billion")
    }

    constructor(input:Int){
        rawNumber = input
    }
}