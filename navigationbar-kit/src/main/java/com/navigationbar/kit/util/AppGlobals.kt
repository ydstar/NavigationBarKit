package com.navigationbar.kit.util

import android.app.Application
import java.lang.Exception

/**
 * Author: 信仰年轻
 * Date: 2020-09-07 17:54
 * Email: hydznsqk@163.com
 * Des: 这种方式获取全局的Application 是一种拓展思路
 * 对于组件化项目,不可能把项目实际的Application下沉到Base,而且各个module也不需要知道Application真实名字
 * 这种一次反射就能获取全局Application对象的方式相比于在Application#OnCreate保存一份的方式显示更加通用了
 */
object AppGlobals {

    private var mApplication: Application? = null

    fun get(): Application? {
        if (mApplication == null) {
            try {
                mApplication = Class.forName("android.app.ActivityThread")
                    .getMethod("currentApplication")
                    .invoke(null) as Application
            } catch (ex: Exception) {
                ex.printStackTrace()
            }

        }
        return mApplication
    }

}