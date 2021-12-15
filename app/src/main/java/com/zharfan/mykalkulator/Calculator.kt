package com.zharfan.mykalkulator

import android.view.View

interface Calculator {
    fun onEqual(view: View)
    fun onPlusMin(view: View)
    fun onDot(view: View)
    fun onPlus(view: View)
    fun onMin(view: View)
    fun onMultiply(view: View)
    fun onClear(view: View)
    fun onKurung(view: View)
    fun onPercent(view: View)
    fun onDivide(view: View)
    fun onHistory(view: View)
    fun onDelete(view: View)
    fun onDigit(view: View)
}