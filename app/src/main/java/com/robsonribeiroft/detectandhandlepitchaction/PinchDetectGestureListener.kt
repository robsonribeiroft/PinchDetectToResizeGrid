package com.robsonribeiroft.detectandhandlepitchaction

import android.view.ScaleGestureDetector

class PinchDetectGestureListener(
    private val isZoomingOut: (Boolean) -> Unit
): ScaleGestureDetector.OnScaleGestureListener {

    var isEnable = true

    private fun Float.isZoomingOut(): Boolean = this > 1

    override fun onScale(detector: ScaleGestureDetector?): Boolean {
        detector?.scaleFactor?.let { scaleFactor ->
            isZoomingOut(scaleFactor.isZoomingOut())
        }
        return true
    }

    override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean = true

    override fun onScaleEnd(detector: ScaleGestureDetector?) = Unit
}
