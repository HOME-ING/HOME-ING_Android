package org.techtown.homeing.util

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDeco (context : Context, isGrid : Boolean = false, size : Int = 10) : RecyclerView.ItemDecoration() {
    private val size_space: Int
    private val checking = isGrid

    init {
        size_space = dpToPx(context, size)
    }

    private fun dpToPx(context: Context, dp: Int): Int {

        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics)
            .toInt()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = size_space
    }
}