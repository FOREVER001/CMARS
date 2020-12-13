package com.zxh.common

import android.app.Application
import android.content.Context
import com.zxh.common.http.core.HttpManager
import com.zxh.common.http.okhttpImpl.OkHttpImpl

/**
 * Application基类用来初始化各个模块的IApplife
 */
class BaseApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        initHttp()
    }


    override fun onTerminate() {
        super.onTerminate()
    }


    /**
     * 初始化Http
     */
    private fun initHttp() {
        HttpManager.instance.init(OkHttpImpl())
    }
}