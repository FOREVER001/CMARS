package com.zxh.common.http.core

import java.lang.NullPointerException

/**
 * Http请求管理类
 */
class HttpManager private constructor(){
     var mHttpImpl:HttpImpl?=null
    companion object{
        val instance:HttpManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            HttpManager()
        }
    }

    fun init(ihttp: Ihttp){
        mHttpImpl=HttpImpl()
        mHttpImpl!!.mIhttp=ihttp
    }

    /**
     * get请求
     */
     fun <T> doGetAsync(url: String, params: Map<String, Object>, callback: HttpReslutCallback<T>) {
        mHttpImpl?.doGetAsync(url,params,callback)?:NullPointerException("请先调用init方法")
    }

    /**
     *
     */
     fun <T> doPostAsync(url: String, params: Map<String, Object>, callback: HttpReslutCallback<T>) {
         mHttpImpl?.doPostAsync(url,params,callback)?:NullPointerException("请先调用init方法")
    }

}