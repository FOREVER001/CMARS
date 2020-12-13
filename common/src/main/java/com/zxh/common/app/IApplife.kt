package com.zxh.common.app

import android.content.Context

/**
 * 模拟Application的生命周期
 */
interface IApplife {

    fun attachBaseContext(base: Context?)

    fun onCreate()

    fun onTerminate()

}