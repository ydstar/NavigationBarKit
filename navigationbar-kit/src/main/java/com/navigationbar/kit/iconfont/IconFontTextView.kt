package com.navigationbar.kit.iconfont

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView


/**
 * Author: 信仰年轻
 * Date: 2020-12-25 17:59
 * Email: hydznsqk@163.com
 * Des:用以支持全局iconfont资源的引用，可以在布局中直接设置text
 */
class IconFontTextView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    defStyle: Int = 0
) :AppCompatTextView(context, attributeSet, defStyle) {
    init {
        val typeface = Typeface.createFromAsset(context.assets, "fonts/iconfont.ttf")
        setTypeface(typeface)
    }
}