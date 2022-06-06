package com.robsonribeiroft.detectandhandlepitchaction

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PinchDetectLayoutManager(
    context: Context,
    private val maxNumberOfColumns: Int,
    private val minNumberOfColumns: Int = 1,
    orientationList: Int = VERTICAL,
    isReverse: Boolean = false
): GridLayoutManager(context, maxNumberOfColumns, orientationList, isReverse) {

    private var currentNUmberOfColumns = maxNumberOfColumns

    init {
        validateMinNumberOfColumns()
    }

    private fun validateMinNumberOfColumns() {
        if (minNumberOfColumns <= 0)
            throw Exception("Minimum value required for columns must be greater than or equal to 1")
    }

    fun increaseNumberOfColumns() {
        if (currentNUmberOfColumns < maxNumberOfColumns){
            currentNUmberOfColumns++
            spanCount = currentNUmberOfColumns
        }
    }

    fun decreaseNumberOfColumns() {
        if (currentNUmberOfColumns > minNumberOfColumns){
            currentNUmberOfColumns--
            spanCount = currentNUmberOfColumns
        }
    }

    companion object {
        const val VERTICAL = RecyclerView.VERTICAL
        const val HORIZONTAL = RecyclerView.HORIZONTAL
    }
}
