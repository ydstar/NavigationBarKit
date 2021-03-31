package com.example.navigationbarkit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout

import android.widget.TextView
import android.widget.Toast
import com.navigationbar.kit.iconfont.IconFontButton

import com.navigationbar.kit.util.DisplayUtil
import com.navigationbar.kit.util.ResUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_bar.setTitle("首页")

        //设置返回按钮
        nav_bar.setNavBackListener(View.OnClickListener {
            onBackPressed()
        })

        //添加左侧按钮
        val leftBtn1 =
            nav_bar.addLeftTextButton(ResUtil.getString(R.string.favorite), R.integer.id_left_btn1)
        leftBtn1.setOnClickListener {
            toast("左侧按钮1")
        }

        //添加右侧
        val rightBtn1 =
            nav_bar.addRightTextButton(
                ResUtil.getString(R.string.share),
                R.integer.id_right_btn1
            )
        rightBtn1.setOnClickListener {
            toast("右侧按钮1")
        }

        val rightBtn2 =
            nav_bar.addRightTextButton("分享", R.integer.id_right_btn2)
        rightBtn2.setOnClickListener {
            toast("右侧按钮2")
        }

        //添加自定义按钮
        val generateTextButton = generateTextButton()
        nav_bar.addRightView(
            generateTextButton,
            RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
            )
        )
        generateTextButton.setOnClickListener {
            toast("右侧按钮3")
        }
    }

    /**
     * 自定义按钮
     */
    @SuppressLint("ResourceType")
    private fun generateTextButton(): TextView {
        val button = IconFontButton(this)
        button.setBackgroundResource(0)
        button.minWidth = 0
        button.text = "定位"
        button.minimumWidth = 0
        button.minHeight = 0
        button.minHeight = 0
        button.setTextSize(TypedValue.COMPLEX_UNIT_PX, DisplayUtil.sp2px(16f).toFloat())
        button.setTextColor(ResUtil.getColor(R.color.colorAccent))
        button.gravity = Gravity.CENTER
        button.includeFontPadding = false
        button.id = R.integer.id_right_btn3
        return button
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}