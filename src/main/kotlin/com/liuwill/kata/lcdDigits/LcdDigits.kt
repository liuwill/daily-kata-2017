package com.liuwill.kata.lcdDigits

/**
 * Created by LiuWill on 2017/3/26.
 */
class LcdDigits {
    companion object{
        val BASE_DIGIT = '0'
        val BLANK_STR = " "
        val DIGIT_DICT = arrayOf(
            arrayOf(charArrayOf('.','_','.'),charArrayOf('|','.','|'),charArrayOf('|','_','|')),
            arrayOf(charArrayOf('.','.','.'),charArrayOf('.','.','|'),charArrayOf('.','.','|')),
            arrayOf(charArrayOf('.','_','.'),charArrayOf('.','_','|'),charArrayOf('|','_','.')),
            arrayOf(charArrayOf('.','_','.'),charArrayOf('.','_','|'),charArrayOf('.','_','|')),
            arrayOf(charArrayOf('.','.','.'),charArrayOf('|','_','|'),charArrayOf('.','.','|')),
            arrayOf(charArrayOf('.','_','.'),charArrayOf('|','_','.'),charArrayOf('.','_','|')),
            arrayOf(charArrayOf('.','_','.'),charArrayOf('|','_','.'),charArrayOf('|','_','|')),
            arrayOf(charArrayOf('.','_','.'),charArrayOf('.','.','|'),charArrayOf('.','.','|')),
            arrayOf(charArrayOf('.','_','.'),charArrayOf('|','_','|'),charArrayOf('|','_','|')),
            arrayOf(charArrayOf('.','_','.'),charArrayOf('|','_','|'),charArrayOf('.','.','|'))
        )
    }
}