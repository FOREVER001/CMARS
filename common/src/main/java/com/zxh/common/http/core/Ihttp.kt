package com.zxh.common.http.core

/**
 * 网络请求Api
 */
interface Ihttp {

    /**
     * Get请求
     */
    fun <T> doGetAsync(url:String, params:Map<String,Object>,callback: HttpReslutCallback<T>)

    /**
     * POST请求
     */
    fun <T>doPostAsync(url:String, params:Map<String,Object>,callback: HttpReslutCallback<T>)
}