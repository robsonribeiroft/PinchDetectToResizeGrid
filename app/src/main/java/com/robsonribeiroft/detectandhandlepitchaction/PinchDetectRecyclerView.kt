package com.robsonribeiroft.detectandhandlepitchaction

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.recyclerview.widget.RecyclerView

class PinchDetectRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    var isEnable = true

    private val pinchDetectGestureListener = PinchDetectGestureListener { isZoomingOut ->
        if (isZoomingOut) decreaseColumns()
        else increaseColumns()
    }

    private fun increaseColumns() =
        (layoutManager as PinchDetectLayoutManager).increaseNumberOfColumns()

    private fun decreaseColumns() =
        (layoutManager as PinchDetectLayoutManager).decreaseNumberOfColumns()

    private val scaleGestureDetector = ScaleGestureDetector(context, pinchDetectGestureListener)

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(motionEvent: MotionEvent?): Boolean {
        motionEvent?.let {

            when(it.actionMasked) {
                MotionEvent.ACTION_POINTER_UP -> {
                    isEnable = true
                }
            }
            scaleGestureDetector.onTouchEvent(it)
        }
        return super.onTouchEvent(motionEvent)
    }

}
