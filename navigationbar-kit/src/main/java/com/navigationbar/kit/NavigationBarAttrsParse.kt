package com.navigationbar.kit

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import com.navigationbar.kit.util.DisplayUtil
import com.navigationbar.kit.util.ResUtil
/**
 * Author: 信仰年轻
 * Date: 2020-12-25 15:55
 * Email: hydznsqk@163.com
 * Des:解析属性
 */
internal object NavigationBarAttrsParse {

    fun parseNavAttrs(context: Context, attrs: AttributeSet?, defStyleAttr: Int): Attrs {
        val value = TypedValue()
        context.theme.resolveAttribute(R.attr.NavigationBarKitStyle, value, true)

        //如果在theme中设置了style,则用theme的(布局中就不用在设置style了),
        // 否则需要为布局单个设置style(要不然解析属性会报错),会覆盖theme设置的通用style
        val defStyleRes =if (value.resourceId != 0) value.resourceId else 0

        //解析自定义属性
        val array = context.obtainStyledAttributes(
            attrs,
            R.styleable.NavigationBarKit,
            defStyleAttr,
            defStyleRes
        )

        //返回按钮文本,大小,颜色(使用iconfont)
        val navIcon = array.getString(R.styleable.NavigationBarKit_nav_icon)
        val navIconSize = array.getDimensionPixelSize(
            R.styleable.NavigationBarKit_nav_icon_size,
            DisplayUtil.sp2px(18f)
        )
        val navIconColor = array.getColor(R.styleable.NavigationBarKit_nav_icon_color, Color.BLACK)

        //中间主标题的文本,大小和颜色,以及出现副标题时主标题的大小
        val navTitle = array.getString(R.styleable.NavigationBarKit_nav_title)
        val titleTextSize = array.getDimensionPixelSize(
            R.styleable.NavigationBarKit_title_text_size,
            DisplayUtil.sp2px(17f)
        )
        val titleTextColor = array.getColor(
            R.styleable.NavigationBarKit_title_text_color,
            ResUtil.getColor(R.color.normal_title_color)
        )
        val titleTextSizeWithSubtitle = array.getDimensionPixelSize(
            R.styleable.NavigationBarKit_title_text_size_with_subTitle,
            DisplayUtil.sp2px(16f)
        )

        //副标题文本,大小,颜色
        val navSubTitle = array.getString(R.styleable.NavigationBarKit_nav_subtitle)
        val subTitleTextSize = array.getDimensionPixelSize(
            R.styleable.NavigationBarKit_subTitle_text_size,
            DisplayUtil.sp2px(14f)
        )
        val subTitleTextColor = array.getColor(
            R.styleable.NavigationBarKit_subTitle_text_color,
            ResUtil.getColor(R.color.normal_title_color)
        )

        //添加的按钮的大小颜色(使用iconfont)
        val btnTextSize = array.getDimensionPixelSize(
            R.styleable.NavigationBarKit_text_btn_text_size,
            DisplayUtil.sp2px(16f)
        )
        val btnTextColor = array.getColorStateList(R.styleable.NavigationBarKit_text_btn_text_color)

        //按钮的横向内间距
        val horPadding = array.getDimensionPixelSize(R.styleable.NavigationBarKit_hor_padding, 0)

        //底部的横线
        val lineColor =
            array.getColor(R.styleable.NavigationBarKit_nav_line_color, ResUtil.getColor(R.color.normal_line_color))
        val lineHeight =
            array.getDimensionPixelOffset(R.styleable.NavigationBarKit_nav_line_height, 0)

        array.recycle()

        return Attrs(
            navIcon,
            navIconColor,
            navIconSize.toFloat(),
            navTitle,
            navSubTitle,
            horPadding,
            btnTextSize.toFloat(),
            btnTextColor,
            titleTextSize.toFloat(),
            titleTextSizeWithSubtitle.toFloat(),
            titleTextColor,
            subTitleTextSize.toFloat(),
            subTitleTextColor,
            lineColor,
            lineHeight
        )
    }

    data class Attrs(
        val navIconStr: String?,
        val navIconColor: Int,
        val navIconSize: Float,
        val navTitle: String?,
        val navSubtitle: String?,
        val horPadding: Int,
        val btnTextSize: Float,
        val btnTextColor: ColorStateList?,
        val titleTextSize: Float,
        val titleTextSizeWithSubTitle: Float,
        val titleTextColor: Int,
        val subTitleSize: Float,
        val subTitleTextColor: Int,
        val lineColor: Int,
        val lineHeight: Int
    )
}